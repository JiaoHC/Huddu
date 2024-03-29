package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.WorkInfo;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

@Mapper
public interface WorkInfoMapper {

    List<LocalDate> getAllDates();

    int removeByDate(LocalDate localDate);

    int saverWorkInfos(List<WorkInfo> workInfos);
}
