package com.tencent.wxcloudrun.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DayWorkInfSubitem implements Serializable {
    private String wType;
    private String wTime;
    private String wOb;
    private Double wAmount;
    private String wRemark;

    public DayWorkInfSubitem() {}

    public DayWorkInfSubitem(String wType,String wTime,String wOb,Double wAmount,String wRemark) {
        this.wType = wType;
        this.wTime = wTime;
        this.wOb = wOb;
        this.wAmount = wAmount;
        this.wRemark = wRemark;
    }
}
