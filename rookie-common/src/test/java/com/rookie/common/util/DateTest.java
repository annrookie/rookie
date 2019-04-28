package com.rookie.common.util;

import org.junit.Test;

import java.util.Date;
import java.util.Map;

/**
 * @author This
 * @version 1.0
 * @date 2019/4/22 16:16
 */
public class DateTest {
    @Test
    public void getDateTest() {
        System.out.println(DateUtil.getDate());
    }

    @Test
    public void getTimeTest() {
        System.out.println(DateUtil.getTime(DateUtil.getCalendar(), "yyyyMMdd HH:mm:ss"));
    }

    @Test
    public void nowTimeTest() {
        System.out.println(DateUtil.getTime("yyyy.MM.dd HH:mm:ss"));
    }

    @Test
    public void getCurrDateTest() {
        System.out.println(DateUtil.getCurrTime());
    }

    @Test
    public void timestampToTimeTest() {
        System.out.println(DateUtil.timestampToTime(DateUtil.getTimestamp()));
    }

    @Test
    public void timestampsToTimeTest() {
        System.out.println(DateUtil.secondStampToTime(DateUtil.getSecondStamp()));
    }

    @Test
    public void timeToDateTest() {
        System.out.println(DateUtil.toDate("2019年03月13日 10时32分10秒"));
    }

    @Test
    public void toLocalDateTimeTest() {

        System.out.println(DateUtil.toLocalDateTime("2019年03月13日10时32分10秒"));
    }

    @Test
    public void toCalendarTest() {

        System.out.println(DateUtil.toCalendar("2019年03月13日10时32分10秒"));
    }

    @Test
    public void normalDate() {
        Map<String, String> map = DateUtil.toNormalDate("2019-03-13");
        System.out.println(map);
    }

    @Test
    public void timestampToDateTest() {
        System.out.println(System.currentTimeMillis());
        Date s = DateUtil.timestampToDate(1556171750);
        System.out.println(s);
    }

    @Test
    public void getCalendar() {
        System.out.println(DateUtil.getCalendar());
    }

    @Test
    public void getLocalDateTest() {
        System.out.println(DateUtil.getLocalDate());
    }

    @Test
    public void getLocalTimeTest() {
        System.out.println(DateUtil.getLocalTime());
    }

    @Test
    public void getLocalDateTimeTest() {
        System.out.println(DateUtil.getLocalDateTime());
    }

    @Test
    public void dateToCalendarTest() {
        System.out.println(DateUtil.dateToCalendar(new Date()));
    }

    @Test
    public void calendarToDateTest() {
        System.out.println(DateUtil.calendarToDate(DateUtil.getCalendar()));
    }

    @Test
    public void getCurrYearTest() {
        System.out.println(DateUtil.getYear());
    }

    @Test
    public void getCurrMonthTest() {
        System.out.println(DateUtil.getMonth());
    }

    @Test
    public void getCurrDayTest() {
        System.out.println(DateUtil.getDayOfMonth());
    }

    @Test
    public void getCurrQuarterTest() {
        System.out.println(DateUtil.getQuarter());
        System.out.println(DateUtil.getQuarter("2019-10-3"));
    }

    @Test
    public void getCurrMonthLengthTest() {
        System.out.println(DateUtil.getMonthLength());
        System.out.println(DateUtil.getMonthLength("2019-3-1"));

    }

    @Test
    public void timestampToLocalDateTimeTest() {
        System.out.println(DateUtil.timestampToLocalDateTime(System.currentTimeMillis()));
    }

    @Test
    public void secondStampToLocalDateTimeTest() {
        System.out.println(DateUtil.secondStampToLocalDateTime(DateUtil.getSecondStamp()));
    }

    @Test
    public void getYearTest() {
        System.out.println(DateUtil.getYear(new Date()));
    }

    @Test
    public void getMonthTest() {
        System.out.println(DateUtil.getMonth(new Date()));
        System.out.println(DateUtil.getMonth(DateUtil.getLocalDate()));
    }

    @Test
    public void getDayTest() {
        System.out.println(DateUtil.getDayOfMonth(new Date()));
        System.out.println(DateUtil.getDayOfMonth(DateUtil.getCalendar()));
        System.out.println(DateUtil.getDayOfMonth(DateUtil.getLocalDate()));
        System.out.println(DateUtil.getDayOfMonth(DateUtil.getLocalDateTime()));
    }

    @Test
    public void getDayOfWeekTest() {
        System.out.println(DateUtil.getDayOfWeekCN());
        System.out.println(DateUtil.getDayOfWeekEN());
        System.out.println(DateUtil.getDayOfWeek());
        System.out.println(DateUtil.getDayOfWeekEN(new Date()));
        System.out.println(DateUtil.getDayOfWeekCN("2019-04-30"));
//        System.out.println(DateUtil.getDayOfWeek(DateUtil.getCalendar()));
//        System.out.println(DateUtil.getDayOfWeek(DateUtil.getLocalDate()));
//        System.out.println(DateUtil.getDayOfWeek(DateUtil.getLocalDateTime()));
    }

    @Test
    public void getDayOfYearTest() {
        System.out.println(DateUtil.getDayOfYear());
        System.out.println(DateUtil.getDayOfYear("2019-5-1"));
        System.out.println(DateUtil.getDayOfYear(DateUtil.getCalendar()));
        System.out.println(DateUtil.getDayOfYear(new Date()));
        System.out.println(DateUtil.getDayOfYear(DateUtil.getLocalDateTime()));
    }


    @Test
    public void getWeekOfMonthTest() {
        System.out.println(DateUtil.getWeekOfMonth());
        System.out.println(DateUtil.getWeekOfMonth("2019-05-15"));
        System.out.println(DateUtil.getWeekOfMonth(DateUtil.getLocalDateTime()));
    }

    @Test
    public void getWeekOfYearTest() {
        System.out.println(DateUtil.getWeekOfYear());
    }

    @Test
    public void getHourTest() {
        System.out.println(DateUtil.getHour());
        System.out.println(DateUtil.getHour("2019-10-3"));
        System.out.println(DateUtil.getHour(DateUtil.getLocalDateTime()));
    }

    @Test
    public void timeToTimestamp(){
        System.out.println(DateUtil.timeToTimestamp("2019-10-3 18:00:13"));
        System.out.println(DateUtil.timeToSecondStamp("2019-10-3 18:00:13"));
    }

    @Test
    public void getMinTime(){
        String minTime = DateUtil.getMinTime("2019-3-10 13:30:23", "2019年2月15日 18时30分2秒", "20190309");
        System.out.println(minTime);
    }

    @Test
    public void getDifferTimeTest(){
        Map<String, Integer> differTime = DateUtil.getDifferTime( "2019-4-29 00:00:00","2019-04-28 18:00:00");
        System.out.println(differTime);
    }

    @Test
    public void getHmsTest(){
        String hms = DateUtil.getHms(21661);
        System.out.println(hms);
    }
}
