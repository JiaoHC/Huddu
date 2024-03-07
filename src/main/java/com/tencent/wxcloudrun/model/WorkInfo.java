package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
public class WorkInfo implements Serializable {

    private String uId;
    private LocalDate uDate;
    private String uType;
    private String uTime;
    private String uOb;
    private Double uAmount;
    private String uRemark;

    public WorkInfo() {
    }

    public WorkInfo(String uId,LocalDate uDate,String uType,String uTime,String uOb,Double uAmount,String uRemark) {
        this.uId = uId;
        this.uDate = uDate;
        this.uType = uType;
        this.uTime = uTime;
        this.uOb = uOb;
        this.uAmount = uAmount;
        this.uRemark = uRemark;
    }

}
