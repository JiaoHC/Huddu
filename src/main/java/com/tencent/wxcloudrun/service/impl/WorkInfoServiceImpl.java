package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.WorkInfoMapper;
import com.tencent.wxcloudrun.dto.DayWorkInfSubitem;
import com.tencent.wxcloudrun.dto.DayWorkInfo;
import com.tencent.wxcloudrun.model.WorkInfo;
import com.tencent.wxcloudrun.service.WorkInfoService;
import com.tencent.wxcloudrun.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkInfoServiceImpl implements WorkInfoService {

    final WorkInfoMapper workInfoMapper;

    public WorkInfoServiceImpl(@Autowired WorkInfoMapper workInfoMapper) {
        this.workInfoMapper = workInfoMapper;
    }

    @Override
    public List<DayWorkInfo> getDlr() {
        List<DayWorkInfo> dlrDateInfo = new ArrayList<DayWorkInfo>();
        LocalDate fDate = LocalDate.of(2024, 2, 18);
        LocalDate nowDate = LocalDate.now();
        List<LocalDate> allList = new ArrayList<LocalDate>();
        while (nowDate.compareTo(fDate) > 0) {
            allList.add(nowDate);
            nowDate = nowDate.minusDays(1);
        }
        List<LocalDate> hasDates = workInfoMapper.getAllDates();
        for(LocalDate localDate : allList) {
            if(!hasDates.contains(localDate)) {
                dlrDateInfo.add(new DayWorkInfo(localDate));
            }
        }
        return dlrDateInfo;
    }

    @Override
    @Transient
    public Boolean saveDayWork(DayWorkInfo dayWorkInfo) {
        LocalDate wDate = dayWorkInfo.getWDate();
        workInfoMapper.removeByDate(wDate);
        List<WorkInfo> workInfos = new ArrayList<WorkInfo>();
        List<DayWorkInfSubitem> dayWorkInfSubitems = dayWorkInfo.getDwisList();
        if(dayWorkInfSubitems.size() > 0) {
            for(DayWorkInfSubitem dayWorkInfSubitem : dayWorkInfSubitems) {
                workInfos.add(new WorkInfo(UuidUtil.getShortUuid(),
                        wDate,
                        dayWorkInfSubitem.getWType(),
                        dayWorkInfSubitem.getWTime(),
                        dayWorkInfSubitem.getWOb(),
                        dayWorkInfSubitem.getWAmount(),
                        dayWorkInfSubitem.getWRemark()));
            }
        } else {
            workInfos.add(new WorkInfo(UuidUtil.getShortUuid(),wDate,"休息","","",0.00,""));
        }
        workInfoMapper.saverWorkInfos(workInfos);
        return true;
    }
}
