package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.DayWorkInfo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface WorkInfoService {

    List<DayWorkInfo> getDlr();

    Boolean saveDayWork(DayWorkInfo dayWorkInfo);
}
