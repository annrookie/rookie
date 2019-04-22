package com.rookie.common.util;

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
     * 时间格式转换
     * @param date 时间格式字符串
     * @param nowFormat 当前时间格式
     * @param format 转换后的字符串
     * @return 转换完的时间格式
     */
    public static String changeFormat(String date, String nowFormat, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(nowFormat);
        try {
            Date d = sdf.parse(date);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.format(d);
        } catch (Exception e) {
            return null;
        }
    }
}
