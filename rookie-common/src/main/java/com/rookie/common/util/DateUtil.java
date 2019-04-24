package com.rookie.common.util;


import com.rookie.common.exception.UtilException;
import com.rookie.common.resource.Constant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author This
 * @version 1.0
 * @date 2019/4/17 17:36
 */
public class DateUtil {

    /**
     * 获取当前日期
     *
     * @return 当前日期Date形式
     */
    public static Date getDate() {
        return new Date();
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
    public static long getTimestamps() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 获取当前时间：
     * 标准格式 yyyy-MM-dd HH:mm:ss
     *
     * @return 返回当前时间字符串
     */
    public static String nowTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_NORMAL);
        return sdf.format(getDate());
    }

    /**
     * 获取当天时间
     * yyyy-MM-dd
     * @return 返回当天日期
     */
    public static String nowDay(){
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_DAY);
        return sdf.format(getDate());
    }

    /**
     * 获取当前时间，以指定日期格式
     *
     * @param format 指定日期格式
     * @return 当前时间字符串
     */
    public static String nowDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(getDate());
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
     * 秒时间戳转标准时间格式
     * yyyy-MM-dd HH:mm:ss
     *
     * @param timestamps 时间戳
     * @return 标准时间形式
     */
    public static String timestampsToTime(long timestamps) {
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_NORMAL);
        return sdf.format(timestamps * 1000);
    }

    /**
     * 日期转Date类型
     * @param nowTime 当前日期
     * @return Date类型日期
     */
    public static Date timeToDate(String nowTime){
        if (!ArrayUtil.contains(Constant.DATE_FORMAT,nowTime)){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.DATE_DAY);
        try {
            return sdf.parse(nowTime);
        } catch (Exception e) {
            return null;
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
}
