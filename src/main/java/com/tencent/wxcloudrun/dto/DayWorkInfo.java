package com.tencent.wxcloudrun.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;

@Data
public class DayWorkInfo implements Serializable {
    private LocalDate wDate;
    private String wWeek;
    private Double wTotalAmount;
    private List<DayWorkInfSubitem> dwisList;

    public DayWorkInfo() {

    }
    public DayWorkInfo(LocalDate wDate) {
        this.wDate = wDate;
        int dayOfWeek= wDate.getDayOfWeek().getValue();

        switch (dayOfWeek) {
            case 1:
                this.wWeek = "星期一";
                this.wTotalAmount = 120.00;
                this.dwisList = new ArrayList<DayWorkInfSubitem>() {{
                    add(new DayWorkInfSubitem("政治课","上午3","18班",60.00,""));
                    add(new DayWorkInfSubitem("政治课","上午4","16班",60.00,""));
                }};
                break;
            case 2:
                this.wWeek = "星期二";
                this.wTotalAmount = 120.00;
                this.dwisList = new ArrayList<DayWorkInfSubitem>() {{
                    add(new DayWorkInfSubitem("政治课","下午1","16班",60.00,""));
                    add(new DayWorkInfSubitem("政治课","下午2","18班",60.00,""));
                }};
                break;
            case 3:
                this.wWeek = "星期三";
                this.wTotalAmount = 120.00;
                this.dwisList = new ArrayList<DayWorkInfSubitem>() {{
                    add(new DayWorkInfSubitem("政治课","下午1","18班",60.00,""));
                    add(new DayWorkInfSubitem("政治课","下午2","16班",60.00,""));
                }};
                break;
            case 4:
                this.wWeek = "星期四";
                this.wTotalAmount = 120.00;
                this.dwisList = new ArrayList<DayWorkInfSubitem>() {{
                    add(new DayWorkInfSubitem("政治课","上午2","16班",60.00,""));
                    add(new DayWorkInfSubitem("政治课","下午2","18班",60.00,""));
                }};
                break;
            case 5:
                this.wWeek = "星期五";
                this.wTotalAmount = 120.00;
                this.dwisList = new ArrayList<DayWorkInfSubitem>() {{
                    add(new DayWorkInfSubitem("政治课","上午1","18班",60.00,""));
                    add(new DayWorkInfSubitem("政治课","上午2","16班",60.00,""));
                }};
                break;
            case 6:
                this.wWeek = "星期六";
                this.wTotalAmount = 0.00;
                this.dwisList = new ArrayList<DayWorkInfSubitem>() ;
                break;
            case 7:
                this.wWeek = "星期天";
                WeekFields weekFields = WeekFields.ISO;
                if(wDate.get(weekFields.weekOfWeekBasedYear())%2 != 0) {
                    this.wTotalAmount = 320.00;
                    this.dwisList = new ArrayList<DayWorkInfSubitem>() {{
                        add(new DayWorkInfSubitem("政治课","上午3","16班",80.00,""));
                        add(new DayWorkInfSubitem("政治课","上午4","16班",80.00,""));
                        add(new DayWorkInfSubitem("政治课","下午1","18班",80.00,""));
                        add(new DayWorkInfSubitem("政治课","下午2","18班",80.00,""));
                    }};
                } else {
                    this.wTotalAmount = 0.00;
                }
                break;
        }
    }
}
