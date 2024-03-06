package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.WorkInfoMapper;
import com.tencent.wxcloudrun.dto.DayWorkInfo;
import com.tencent.wxcloudrun.service.WorkInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
