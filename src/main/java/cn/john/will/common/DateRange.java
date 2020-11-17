package cn.john.will.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @title: DateRange in Workspaces
 * @description:
 * @author: zouxiru mei cuo jiu shi wo
 * @date: 2018/7/24 20:50
 * @version: 1.0
 */
@Data
public class DateRange implements Serializable {

    private static final long serialVersionUID = 5804316847008192107L;

    private String startTime;
    private String endTime;

    public DateRange() {
    }

    public DateRange(String start, String end) {
        this.startTime = start;
        this.endTime = end;
    }
}
