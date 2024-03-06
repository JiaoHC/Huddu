package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.DayWorkInfo;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.service.WorkInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class WorkInfoController {

    final WorkInfoService workInfoService;
    final Logger logger;

    public WorkInfoController(@Autowired WorkInfoService workInfoService) {
        this.workInfoService = workInfoService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }

    /**
     * 获取待录入日期
     * @return API response json
     */
    @GetMapping(value = "/work/getDlr")
    ApiResponse getDlr() {
        logger.info("/work/getDlr get request");
        List<DayWorkInfo> dList = workInfoService.getDlr();
        return ApiResponse.ok(dList);
    }

    // 保存数据（无添加有则更新）

    // 获取全部统计数据

    // 获取指定时间端统计数据

    // 获取全部详细数据

    // 修改某天数据
}
