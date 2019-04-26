package com.rookie.common.util;

import org.junit.Test;

import java.util.Date;

/**
 * @author This
 * @version 1.0
 * @date 2019/4/22 16:16
 */
public class DateTest {
    @Test
    public void getDateTest(){
        System.out.println(DateUtil.getDate());
    }

    @Test
    public void getTimeTest(){
        System.out.println(DateUtil.getTime(DateUtil.getCalendar(),"yyyyMMdd HH:mm:ss"));
    }

    @Test
    public void nowTimeTest(){
        System.out.println(DateUtil.getTime("yyyy.MM.dd HH:mm:ss"));
    }

    @Test
    public void getCurrDateTest(){
        System.out.println(DateUtil.getCurrTime());
    }
    @Test
    public void timestampToTimeTest(){
        System.out.println(DateUtil.timestampToTime(DateUtil.getTimestamp()));
    }

    @Test
    public void timestampsToTimeTest(){
        System.out.println(DateUtil.secondStampToTime(DateUtil.getSecondStamp()));
    }

    @Test
    public void timeToDateTest(){
        System.out.println(DateUtil.timeToDate("2019年03月13日 10时32分10秒"));
    }
    @Test
    public void normalDate(){
        String s = DateUtil.toNormalDate("2019 03 13");
        System.out.println(s);
    }
    @Test
    public void timestampToDateTest(){
        System.out.println(System.currentTimeMillis());
        Date s = DateUtil.timestampToDate(1556171750);
        System.out.println(s);
    }

    @Test
    public void getCalendar(){
        System.out.println(DateUtil.getCalendar());
    }

    @Test
    public void getLocalDateTest(){
        System.out.println(DateUtil.getLocalDate());
    }

    @Test
    public void getLocalTimeTest(){
        System.out.println(DateUtil.getLocalTime());
    }

    @Test
    public void getLocalDateTimeTest(){
        System.out.println(DateUtil.getLocalDateTime());
    }

    @Test
    public void dateToCalendarTest(){
        System.out.println(DateUtil.dateToCalendar(new Date()));
    }

    @Test
    public void calendarToDateTest(){
        System.out.println(DateUtil.calendarToDate(DateUtil.getCalendar()));
    }

    @Test
    public void getCurrYearTest(){
        System.out.println(DateUtil.getYear());
    }

    @Test
    public void getCurrMonthTest(){
        System.out.println(DateUtil.getMonth());
    }

    @Test
    public void getCurrDayTest(){
        System.out.println(DateUtil.getDayOfMonth());
    }

    @Test
    public void getCurrQuarterTest(){
        System.out.println(DateUtil.getQuarter());
    }

    @Test
    public void getCurrMonthLengthTest(){
        System.out.println(DateUtil.getMonthLength());
    }

    @Test
    public void timestampToLocalDateTimeTest(){
        System.out.println(DateUtil.timestampToLocalDateTime(System.currentTimeMillis()));
    }

    @Test
    public void secondStampToLocalDateTimeTest(){
        System.out.println(DateUtil.secondStampToLocalDateTime(DateUtil.getSecondStamp()));
    }

    @Test
    public void getYearTest(){
        System.out.println(DateUtil.getYear(new Date()));
    }

    @Test
    public void getMonthTest(){
        System.out.println(DateUtil.getMonth(new Date()));
        System.out.println(DateUtil.getMonth(DateUtil.getLocalDate()));
    }

    @Test
    public void getDayTest(){
        System.out.println(DateUtil.getDayOfMonth(new Date()));
        System.out.println(DateUtil.getDayOfMonth(DateUtil.getCalendar()));
        System.out.println(DateUtil.getDayOfMonth(DateUtil.getLocalDate()));
        System.out.println(DateUtil.getDayOfMonth(DateUtil.getLocalDateTime()));
    }

    @Test
    public void getDayOfWeekTest(){
        System.out.println(DateUtil.getDayOfWeekCN());
        System.out.println(DateUtil.getDayOfWeekEN());
        System.out.println(DateUtil.getDayOfWeek());
        System.out.println(DateUtil.getDayOfWeekEN(new Date()));
        System.out.println(DateUtil.getDayOfWeekCN("2019-04-30"));
//        System.out.println(DateUtil.getDayOfWeek(DateUtil.getCalendar()));
//        System.out.println(DateUtil.getDayOfWeek(DateUtil.getLocalDate()));
//        System.out.println(DateUtil.getDayOfWeek(DateUtil.getLocalDateTime()));
    }

}
