package com.rookie.common.util;


import com.rookie.common.exception.UtilException;
import com.rookie.common.resource.Constant;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期工具类
 *
 * @author This
 * @version 1.0
 * @date 2019/4/17 17:36
 * @since jdk 1.8
 */
public class DateUtil {

    /**
     * yyyy-MM-dd HH:mm:ss 日期格式
     */
    private static final DateTimeFormatter NORMAL = DateTimeFormatter.ofPattern(Constant.DATE_NORMAL);

    private static final ZoneId ZONE_ID = ZoneId.systemDefault();
    //日期对象==============================================================

    /**
     * 获取当前日期
     *
     * @return 当前日期Date形式
     */
    public static Date getDate() {
        return new Date();
    }

    /**
     * 日历对象
     *
     * @param calendar 日历对象
     * @return date对象
     */
    public static Date calendarToDate(Calendar calendar) {
        return calendar.getTime();
    }

    /**
     * LocalDateTime 转 Date对象
     *
     * @param localDateTime
     * @return
     */
    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZonedDateTime zdt = localDateTime.atZone(ZONE_ID);
        return Date.from(zdt.toInstant());
    }

    /**
     * localDate 转 Date对象
     *
     * @param localDate
     * @return
     */
    public static Date localDateToDate(LocalDate localDate) {
        ZonedDateTime zdt = localDate.atStartOfDay(ZONE_ID);
        return Date.from(zdt.toInstant());
    }

    /**
     * 当前日历对象
     *
     * @return 日历对象
     */
    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    /**
     * Date转日历对象
     *
     * @param date Date对象
     * @return 日历对象
     */
    public static Calendar dateToCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * localDate对象
     *
     * @return localDate对象
     */
    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    /**
     * localTime对象
     *
     * @return localTime对象
     */
    public static LocalTime getLocalTime() {
        return LocalTime.now();
    }

    /**
     * localDateTime对象
     *
     * @return localDateTime对象
     */
    public static LocalDateTime getLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * Date对象转LocalDateTime对象
     *
     * @param date 日期对象
     * @return localDateTime对象
     */
    public static LocalDateTime dateToLDT(Date date) {
        Instant instant = date.toInstant();
        return instant.atZone(ZONE_ID).toLocalDateTime();
    }

    /**
     * Date对象转LocalDate对象
     *
     * @param date 日期对象
     * @return localDate对象
     */
    public static LocalDate dateToLcoalDate(Date date) {
        Instant instant = date.toInstant();
        return instant.atZone(ZONE_ID).toLocalDate();
    }

    /**
     * Date对象转LocalTime对象
     *
     * @param date 日期对象
     * @return LocalTime对象
     */
    public static LocalTime dateToLcoalTime(Date date) {
        Instant instant = date.toInstant();
        return instant.atZone(ZONE_ID).toLocalTime();
    }

    //当前时间===========================================

    /**
     * 获取当前时间：
     * 标准格式 yyyy-MM-dd HH:mm:ss
     *
     * @return 返回当前时间字符串
     */
    public static String getTime() {
        return getTime(getLocalDateTime(), Constant.DATE_NORMAL);
    }

    /**
     * 获取当前时间，以指定日期格式
     *
     * @param format 指定日期格式
     * @return 当前时间字符串
     */
    public static String getTime(String format) {
        return getTime(getLocalDateTime(), format);
    }

    /**
     * 获取当天时间
     * yyyy-MM-dd
     *
     * @return 返回当天日期
     */
    public static String getCurrTime() {
        return getLocalDate().toString();
    }

    /**
     * 获取当前年份
     *
     * @return 当前年份
     */
    public static int getYear() {
        return getLocalDateTime().getYear();
    }

    /**
     * 获取当前月份
     *
     * @return 当前月份
     */
    public static int getMonth() {
        return getLocalDateTime().getMonthValue();
    }

    /**
     * 获取当前月到天数
     *
     * @return 天数
     */
    public static int getDayOfMonth() {
        return getLocalDate().getDayOfMonth();
    }

    /**
     * 获取星期 用数字表示 1-7
     *
     * @return 1-7
     */
    public static int getDayOfWeek() {
        return Integer.valueOf(getDayOfWeek(getLocalDateTime(), Constant.ZERO));
    }

    /**
     * 获取星期 用英文表示 Monday-Sunday
     *
     * @return 星期英文
     */
    public static String getDayOfWeekEN() {
        return getDayOfWeek(getLocalDateTime(), Constant.TWO);
    }

    /**
     * 获取星期中文
     *
     * @return 星期一 - 星期日
     */
    public static String getDayOfWeekCN() {
        return getDayOfWeek(getLocalDateTime(), Constant.ONE);
    }

    /**
     * 获取当前天数为今年的第几天
     *
     * @return 天数
     */
    public static int getDayOfYear() {
        return getLocalDateTime().getDayOfYear();
    }

    /**
     * 获取当前季度
     *
     * @return 当前季度
     */
    public static int getQuarter() {
        return getQuarter(getMonth());
    }

    /**
     * 获取当前月份总共天数
     *
     * @return 总共天数
     */
    public static int getMonthLength() {
        return getMonthLength(getYear(), getMonth());
    }

    /**
     * 获取当前日期在本月的周数
     *
     * @return 本月第几周
     */
    public static int getWeekOfMonth() {
        return getWeekOfMonth(getCalendar());
    }

    /**
     * 获取当前日期在其年份所在的周数
     *
     * @return 周数
     */
    public static int getWeekOfYear() {
        return getWeekOfYear(getDayOfYear());
    }

    /**
     * 获取当前时间小时部分
     *
     * @return
     */
    public static int getHour() {
        return getLocalDateTime().getHour();
    }

    /**
     * 获取当前时间分钟部分
     *
     * @return
     */
    public static int getMinute() {
        return getLocalDateTime().getMinute();
    }

    /**
     * 获取当前时间秒部分
     *
     * @return
     */
    public static int getSecond() {
        return getLocalDateTime().getSecond();
    }
    //指定日期操作=====================================================

    /**
     * 获取指定格式的时间
     *
     * @param localDateTime localDate
     * @param format        时间格式
     * @return 指定格式时间
     */
    public static String getTime(LocalDateTime localDateTime, String format) {
        return localDateTime.format(strFormat2DTF(format));
    }

    public static String getTime(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String getTime(Calendar calendar, String format) {
        Date date = calendarToDate(calendar);
        return getTime(date, format);
    }

    /**
     * 获取年份
     *
     * @param date 获取指定时间年份
     * @return 年
     */
    public static int getYear(Date date) {
        return Integer.valueOf(getTime(date, "yyyy"));
    }

    public static int getYear(Calendar calendar) {
        return calendar.get(Calendar.YEAR);
    }

    public static int getYear(LocalDateTime localDateTime) {
        return localDateTime.getYear();
    }

    public static int getYear(LocalDate localDate) {
        return localDate.getYear();
    }

    /**
     * 获取月份
     *
     * @param date 时间对象
     * @return 月份
     */
    public static int getMonth(Date date) {
        return Integer.valueOf(getTime(date, "MM"));
    }

    public static int getMonth(Calendar calendar) {
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getMonth(LocalDateTime localDateTime) {
        return localDateTime.getMonthValue();
    }

    public static int getMonth(LocalDate localDate) {
        return localDate.getMonthValue();
    }

    /**
     * 获取本月号数
     *
     * @param date Date对象
     * @return 本月第几天
     */
    public static int getDayOfMonth(Date date) {
        return Integer.valueOf(getTime(date, "dd"));
    }

    public static int getDayOfMonth(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getDayOfMonth(LocalDateTime localDateTime) {
        return localDateTime.getDayOfMonth();
    }

    public static int getDayOfMonth(LocalDate localDate) {
        return localDate.getDayOfMonth();
    }

    /**
     * 获取指定日期字符串是星期数
     *
     * @param date 日期字符串
     * @return 星期
     */
    public static int getDayOfWeek(String date) {
        return getDayOfWeek(toCalendar(date));
    }

    public static int getDayOfWeek(Date date) {
        Calendar calendar = dateToCalendar(date);
        return getDayOfWeek(calendar);
    }

    public static int getDayOfWeek(Calendar calendar) {
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        return i - 1 == 0 ? 7 : i - 1;
    }

    public static int getDayOfWeek(LocalDateTime localDateTime) {
        return Integer.parseInt(getDayOfWeek(localDateTime, 0));
    }

    public static String getDayOfWeekCN(String date) {
        return getDayOfWeek(getDayOfWeek(date), Constant.ONE);
    }

    public static String getDayOfWeekEN(String date) {
        return getDayOfWeek(getDayOfWeek(date), Constant.TWO);
    }

    public static String getDayOfWeekCN(Date date) {
        return getDayOfWeek(getDayOfWeek(date), Constant.ONE);
    }

    public static String getDayOfWeekEN(Date date) {
        return getDayOfWeek(getDayOfWeek(date), Constant.TWO);
    }

    public static String getDayOfWeekCN(Calendar date) {
        return getDayOfWeek(getDayOfWeek(date), Constant.ONE);
    }

    public static String getDayOfWeekEN(Calendar date) {
        return getDayOfWeek(getDayOfWeek(date), Constant.TWO);
    }

    public static String getDayOfWeekCN(LocalDateTime date) {
        return getDayOfWeek(getDayOfWeek(date), Constant.ONE);
    }

    public static String getDayOfWeekEN(LocalDateTime date) {
        return getDayOfWeek(getDayOfWeek(date), Constant.TWO);
    }

    /**
     * 数字星期转中英文星期
     *
     * @param i    数字星期数
     * @param type 1中文 2数字 3英文
     * @return 字符串星期数
     */
    private static String getDayOfWeek(int i, int type) {
        if (i == Constant.NEG_ONE) {
            return Constant.EMPTY;
        }
        switch (type) {
            case 1:
                return Constant.WEEK_CN[i - 1];
            case 2:
                return Constant.WEEK_EN[i - 1];
            default:
                return Constant.WEEK_CN[i - 1];
        }
    }

    /**
     * 获取星期
     *
     * @param localDateTime LocalDateTime对象
     * @param type          星期类型
     *                      默认->英文【Monday-Sunday】
     *                      1->中文【星期一~星期日】
     *                      2->数字【1-7】
     * @return 星期
     */
    public static String getDayOfWeek(LocalDateTime localDateTime, int type) {
        String week = localDateTime.getDayOfWeek().toString();
        int i = ArrayUtil.indexOf(Constant.WEEK_EN, week);
        switch (type) {
            case 1:
                return Constant.WEEK_CN[i];
            case 2:
                return week;
            default:
                return Constant.WEEK_NUM[i];
        }
    }

    /**
     * 获取一年中的天数
     *
     * @param date 指定日期
     * @return 天数
     */
    public static int getDayOfYear(String date) {
        Calendar calendar = toCalendar(date);
        return calendar == null ? Constant.NEG_ONE : calendar.get(Calendar.DAY_OF_YEAR);
    }

    public static int getDayOfYear(Date date) {
        Calendar calendar = dateToCalendar(date);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public static int getDayOfYear(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    public static int getDayOfYear(LocalDateTime localDateTime) {
        return localDateTime.getDayOfYear();
    }

    /**
     * 获取季度
     *
     * @param date 指定日期
     * @return 季度或-1 【-1表示时间错误或不能为空】
     */
    public static int getQuarter(String date) {
        if (StrUtil.isEmpty(date)) {
            return Constant.NEG_ONE;
        }
        Calendar calendar = toCalendar(date);
        return getQuarter(calendar);
    }

    public static int getQuarter(Date date) {
        Calendar calendar = dateToCalendar(date);
        return getQuarter(calendar);
    }

    public static int getQuarter(Calendar calendar) {
        return getQuarter(calendar.get(Calendar.MONTH) + 1);
    }

    public static int getQuarter(LocalDateTime localDateTime) {
        return getQuarter(localDateTime.getMonthValue());
    }

    /**
     * 获取季度
     *
     * @param month 月份
     * @return 返回季度 1【1月-3月】 2【4月-6月】 3【7月-9月】 4【10月-12月】
     */
    private static int getQuarter(int month) {
        int quarter = month / 3;
        return month % 3 == 0 ? quarter : quarter + 1;
    }

    /**
     * 获取指定日期的月份天数
     *
     * @param date 指定日期
     * @return 1-31 或 -1
     */
    public static int getMonthLength(String date) {
        if (StrUtil.isEmpty(date)) {
            return Constant.NEG_ONE;
        }
        Calendar calendar = toCalendar(date);
        return getMonthLength(calendar);
    }

    public static int getMonthLength(Date date) {
        Calendar calendar = dateToCalendar(date);
        return getMonthLength(calendar);
    }

    public static int getMonthLength(Calendar c) {
        return getMonthLength(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1);
    }

    public static int getMonthLength(LocalDateTime localDateTime) {
        return getMonthLength(localDateTime.getYear(), localDateTime.getMonthValue());
    }

    public static int getMonthLength(int year, int month) {
        if (year <= 0 || month < 1 || month > 12) {
            return Constant.NEG_ONE;
        }
        return isLeapYear(year) ? Constant.LEAP_MONTH_LENGTH[month - 1] : Constant.MONTH_LENGTH[month - 1];
    }

    /**
     * 获取指定日期 在其月份所在的周数
     *
     * @param date 指定日期
     * @return 周数
     */
    public static int getWeekOfMonth(String date) {
        if (StrUtil.isEmpty(date)) {
            return Constant.NEG_ONE;
        }
        Calendar calendar = toCalendar(date);
        return getWeekOfMonth(calendar);
    }

    public static int getWeekOfMonth(LocalDateTime localDateTime) {
        int dayOfMonth = localDateTime.getDayOfMonth();
        return dayOfMonth % 7 == 0 ? dayOfMonth / 7 : dayOfMonth / 7 + 1;
    }

    public static int getWeekOfMonth(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
    }

    /**
     * 获取指定时间在其年份所在的周数
     *
     * @param date 指定时间
     * @return 周数
     */
    public static int getWeekOfYear(String date) {
        return getWeekOfYear(getDayOfYear(date));
    }

    public static int getWeekOfYear(Date date) {
        return getWeekOfYear(getDayOfYear(date));
    }

    public static int getWeekOfYear(Calendar calendar) {
        return getWeekOfYear(getDayOfYear(calendar));
    }

    public static int getWeekOfYear(LocalDateTime localDateTime) {
        return getWeekOfYear(getDayOfYear(localDateTime));
    }

    private static int getWeekOfYear(int days) {
        if (days > 366 || days < 0) {
            return Constant.NEG_ONE;
        }
        return days % 7 == 0 ? days / 7 : days / 7 + 1;
    }

    /**
     * 获取指定时间的小时数
     *
     * @param date 指定时间
     * @return 小时数
     */
    public static int getHour(String date) {
        if (StrUtil.isEmpty(date)) {
            return Constant.ZERO;
        }
        Date d = toDate(date);
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        return Integer.valueOf(sdf.format(d));
    }

    public static int getHour(Date date) {
        Calendar calendar = dateToCalendar(date);
        return calendar.get(Calendar.HOUR);
    }

    public static int getHour(Calendar calendar) {
        return calendar.get(Calendar.HOUR);
    }

    public static int getHour(LocalDateTime localDateTime) {
        return localDateTime.getHour();
    }

    /**
     * 获取秒数
     *
     * @param date 指定时间
     * @return 秒数
     */
    public static int getMinute(String date) {
        if (StrUtil.isEmpty(date)) {
            return Constant.ZERO;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        return Integer.valueOf(sdf.format(toDate(date)));
    }

    public static int getMinute(Date date) {
        Calendar calendar = dateToCalendar(date);
        return calendar.get(Calendar.MINUTE);
    }

    public static int getMinute(Calendar calendar) {
        return calendar.get(Calendar.MINUTE);
    }

    public static int getMinute(LocalDateTime localDateTime) {
        return localDateTime.getMinute();
    }

    /**
     * 获取秒数
     *
     * @param date 指定时间
     * @return 秒
     */
    public static int getSecond(String date) {
        if (StrUtil.isEmpty(date)) {
            return Constant.ZERO;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("ss");
        return Integer.valueOf(sdf.format(toDate(date)));
    }

    public static int getSecond(Date date) {
        Calendar calendar = dateToCalendar(date);
        return calendar.get(Calendar.SECOND);
    }

    public static int getSecond(Calendar calendar) {
        return calendar.get(Calendar.SECOND);
    }

    public static int getSecond(LocalDateTime localDateTime) {
        return localDateTime.getSecond();
    }

    /**
     * 判断是否为早上
     *
     * @param date 指定时间
     * @return boolean
     */
    public static boolean isAM(String date) {
        return getHour(date) < 12;
    }

    public static boolean isAM(Date date) {
        return getHour(date) < 12;
    }

    /**
     * 判断是否为下午
     *
     * @param date 指定时间
     * @return boolean
     */
    public static boolean isPM(String date) {
        return !isAM(date);
    }

    public static boolean isPM(Date date) {
        return !isAM(date);
    }

    /**
     * 获取一组时间中最小时间
     *
     * @param date 时间字符串数组
     * @return 最小时间
     */
    public static String getMinTime(String... date) {
        if (ArrayUtil.isEmpty(date)) {
            return Constant.EMPTY;
        }
        if (date.length == 1) {
            return date[0];
        }
        String minTime = date[0];
        for (String s : date) {
            if (!ComUtil.isDate(s)) {
                throw new UtilException("存在不合法的时间");
            }
            if (timeToTimestamp(toNormalDate(minTime).get("date")) > timeToTimestamp(toNormalDate(s).get("date"))) {
                minTime = s;
            }
        }
        return minTime;
    }

    /**
     * 获取最大时间
     *
     * @param date 时间数组
     * @return 最大时间
     */
    public static String getMaxTime(String... date) {
        if (ArrayUtil.isEmpty(date)) {
            return Constant.EMPTY;
        }
        if (date.length == 1) {
            return date[0];
        }
        String maxTime = date[0];
        for (String s : date) {
            if (!ComUtil.isDate(s)) {
                throw new UtilException("存在不合法的时间");
            }
            if (timeToTimestamp(toNormalDate(maxTime).get("date")) < timeToTimestamp(toNormalDate(s).get("date"))) {
                maxTime = s;
            }
        }
        return maxTime;
    }

    /**
     * 相差时间
     *
     * @param start 第一个时间点
     * @param end   第二个时间点
     * @return 相差时间的map
     */
    public static Map<String, Integer> getDifferTime(String start, String end) {
        if (!ComUtil.isDate(start) || !ComUtil.isDate(end)) {
            throw new UtilException("存在时间不合法");
        }
        Map<String, String> startMap = toNormalDate(start);
        Map<String, String> endMap = toNormalDate(end);
        Map<String, Integer> map = new HashMap<>();
        long startStamp = timeToTimestamp(startMap.get("date"));
        long endStamp = timeToTimestamp(endMap.get("date"));
        if (startStamp == endStamp) {
            map.put("day", 0);
            map.put("hour", 0);
            map.put("minute", 0);
            map.put("second", 0);
        } else {
            int diff = (int) Math.abs(startStamp - endStamp) / 1000;
            map = getDHms(diff);
        }
        return map;
    }

    public static String getHms(int secondStamp) {
        Map<String, Integer> map = getDHms(secondStamp);
        StringBuilder sb = new StringBuilder();
        String hour = map.get("hour") > 10 ? map.get("hour").toString() : "0" + map.get("hour") + ":";
        sb.append(hour);
        String min = map.get("min") > 10 ? map.get("min").toString() : "0" + map.get("min") + ":";
        sb.append(min);
        String second = map.get("second") > 10 ? map.get("second").toString() : "0" + map.get("second");
        sb.append(second);
        return sb.toString();
    }


    /**
     * 秒时间戳获取天，时，分，秒Map
     *
     * @param seconds 秒时间戳
     * @return map
     */
    public static Map<String, Integer> getDHms(int seconds) {
        // 一天 / 60*60*24
        int days = seconds / 86400;
        // 一天还剩下的小时数 / (60*60) % 24
        int hour = (seconds / 3600) % 24;
        // 一天还剩下的分钟数 % (60*60) / 60；
        int min = (seconds % (3600)) / 60;
        // 秒数
        int second = (seconds % 3600) % 60;

        Map<String, Integer> map = new HashMap<>();
        map.put("day", days);
        map.put("hour", hour);
        map.put("min", min);
        map.put("second", second);
        return map;
    }
    //时间戳操作=======================================================

    /**
     * 毫秒时间戳转LocalDateTime对象
     *
     * @param timestamp 毫秒时间戳
     * @return LocalDateTime对象
     */
    public static LocalDateTime timestampToLocalDateTime(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        return LocalDateTime.ofInstant(instant, ZONE_ID);
    }

    /**
     * 秒时间戳转LocalDateTime
     *
     * @param secondStamp 秒时间戳
     * @return LocalDateTime对象
     */
    public static LocalDateTime secondStampToLocalDateTime(long secondStamp) {
        Instant instant = Instant.ofEpochSecond(secondStamp);
        return LocalDateTime.ofInstant(instant, ZONE_ID);
    }

    /**
     * 获取当前时间戳，含毫秒
     *
     * @return 时间戳
     */
    public static long getTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * 获取时间戳，秒数
     *
     * @return 时间戳
     */
    public static long getSecondStamp() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 毫秒时间戳转标准时间格式
     * yyyy-MM-dd HH:mm:ss
     *
     * @param timestamp 时间戳
     * @return 标准时间形式
     */
    public static String timestampToTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_NORMAL);
        return sdf.format(timestamp);
    }

    /**
     * 毫秒时间戳转指定时间格式
     *
     * @param timestamp 时间戳
     * @return 标准时间形式
     */
    public static String timestampToTime(long timestamp, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(timestamp);
    }

    /**
     * 秒时间戳转标准时间格式
     * yyyy-MM-dd HH:mm:ss
     *
     * @param timestamps 时间戳
     * @return 标准时间形式
     */
    public static String secondStampToTime(long timestamps) {
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_NORMAL);
        return sdf.format(timestamps * 1000);
    }

    /**
     * 秒时间戳转指定时间格式
     *
     * @param timestamps 时间戳
     * @return 指定时间形式
     */
    public static String secondStampToTime(long timestamps, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(timestamps * 1000);
    }

    /**
     * 时间戳转Date格式
     *
     * @param timestamp 毫秒时间戳
     * @return Date格式
     */
    public static Date timestampToDate(long timestamp) {
        return new Date(timestamp);
    }

    /**
     * 指定时间字符串 转 毫秒时间戳
     *
     * @param date 指定时间
     * @return 时间戳
     */
    public static long timeToTimestamp(String date) {
        if (StrUtil.isEmpty(date)) {
            return Constant.ZERO;
        }
        Date d = toDate(date);
        return d.getTime();
    }

    /**
     * 指定时间转秒时间戳
     *
     * @param date 指定时间
     * @return 秒时间戳
     */
    public static long timeToSecondStamp(String date) {
        return timeToTimestamp(date) / 1000;
    }

    /**
     * @param timestamp
     * @return
     */
    public static Date secondStampToDate(long timestamp) {
        return new Date(timestamp * 1000);
    }


    //时间格式转换===========================================================

    /**
     * 日期转Date类型
     *
     * @param date 当前日期
     * @return Date类型日期
     */
    public static Date toDate(String date) {
        if (StrUtil.isEmpty(date)) {
            return null;
        }
        Map<String, String> map = toNormalDate(date);
        if (map == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(map.get("format"));
        try {
            return sdf.parse(map.get("date"));
        } catch (Exception e) {
            throw new UtilException("日期转换出错");
        }
    }

    /**
     * 当前日期转为LocalDateTime对象
     *
     * @param date 当前日期
     * @return LocalDateTime对象
     */
    public static LocalDateTime toLocalDateTime(String date) {
        Map<String, String> map = toNormalDate(date);
        if (map == null) {
            return null;
        }
        String time = map.get("date");
        if (time.length() <= 10) {
            time += " 00:00:00";
        }
        return LocalDateTime.parse(time, strFormat2DTF(Constant.DATE_NORMAL));
    }

    /**
     * 日期转Calendar对象
     *
     * @param date 日期字符串
     * @return Calendar对象
     */
    public static Calendar toCalendar(String date) {
        Date d = toDate(date);
        return d == null ? null : dateToCalendar(d);
    }

    /**
     * 日期转为标准格式的时间
     * 支持格式：yyyy-MM-dd  yyyy/MM/dd yyyyMMdd yyyy.MM.dd yyyy年MM月dd日
     * HH:mm:ss               ~                     HH时mm分ss秒
     * 转为格式
     * yyyy-MM-dd HH:mm:ss
     * yyyy-MM-dd
     *
     * @param date 日期
     * @return 标准格式日期
     */
    public static Map<String, String> toNormalDate(String date) {
        if (StrUtil.isEmpty(date)) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>(2);
        Pattern regDate = Pattern.compile(Constant.REG_DATE);
        Matcher matcher = regDate.matcher(date);
        if (matcher.find()) {
            String day = matcher.group(5);
            String month = matcher.group(3);
            String year = matcher.group(1);
            if (!ComUtil.isDay(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day))) {
                throw new UtilException("日期不合法");
            }
            String normalDate = year + "-" + month + "-" + day;
            String format = "yyyy-MM-dd";
            if (matcher.group(6) != null) {
                String second = matcher.group(13);
                String min = matcher.group(10);
                String hour = matcher.group(8);
                if (!ComUtil.isTime(Integer.parseInt(hour), Integer.parseInt(min), Integer.parseInt(second))) {
                    throw new UtilException("日期不合法");
                }
                normalDate += " " + hour + ":" + min + ":" + second;
                format += " HH:mm:ss";
            }
            map.put("date", normalDate);
            map.put("format", format);
            return map;
        } else {
            throw new UtilException("日期格式不正确");
        }
    }

    /**
     * 时间格式转换
     *
     * @param date      时间格式字符串
     * @param nowFormat 当前时间格式
     * @param format    转换后的字符串
     * @return 转换完的时间格式
     */
    public static String changeFormat(String date, String nowFormat, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(nowFormat);
        try {
            Date d = sdf.parse(date);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.format(d);
        } catch (Exception e) {
            return date;
        }
    }

    /**
     * 字符串时间格式 转DateTimeFormatter 格式
     *
     * @param format 时间格式
     * @return DateTimeFormatter时间格式
     */
    public static DateTimeFormatter strFormat2DTF(String format) {
        return DateTimeFormatter.ofPattern(format);
    }

    /**
     * 判断是否为闰年
     *
     * @param year 年
     * @return boolean
     */
    public static boolean isLeapYear(int year) {
        return new GregorianCalendar().isLeapYear(year);
    }
}
