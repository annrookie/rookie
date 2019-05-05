package com.rookie.common.util;

import com.rookie.common.resource.Constant;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 校验工具类
 *
 * @author This
 * @version 1.0
 * @date 2019/4/12 9:50
 */
public class ComUtil {

    /**
     * 判断参数是否为空
     *
     * @param obj 参数
     * @return boolean
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 判断参数是否不为空
     *
     * @param obj 参数
     * @return boolean
     */
    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    /**
     * 判断是否为"" 或null
     *
     * @param obj 指定值
     * @return boolean
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        // 判断字符串长度是否为0
        if (obj instanceof String) {
            return 0 == ((String) obj).length();
        }
        if (obj.getClass().isArray()) {
            return 0 == Array.getLength(obj);
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size() == 0;
        }
        if (obj instanceof Dictionary) {
            return ((Dictionary) obj).size() == 0;
        }
        if (obj instanceof Map) {
            return ((Map) obj).size() == 0;
        }
        return false;
    }

    /**
     * 判断是否不为"" 或null
     *
     * @param obj 指定值
     * @return boolean
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 判断两个值是否相等
     *
     * @param o 第一个
     * @param t 第二个
     * @return boolean
     */
    public static boolean isEqual(Object o, Object t) {
        if (o == null && t == null) {
            return true;
        }
        if (o != null) {
            return o.equals(t);
        }
        return false;
    }

    /**
     * 不相等返回true
     *
     * @param o
     * @param t
     * @return
     */
    public static boolean isNotEqual(Object o, Object t) {
        return !isEqual(o, t);
    }

    /**
     * 判断是否为字母，数字，和下划线组成的字符串
     *
     * @param str 字符串
     * @return
     */
    public static boolean isCommon(String str) {
        return str != null && str.matches(Constant.REG_COMMON);
    }

    /**
     * 判断是否为中文字符串
     *
     * @param str 字符串
     * @return
     */
    public static boolean isChinese(String str) {
        return str != null && str.matches(Constant.REG_CHINESE);
    }

    /**
     * 判断是否为>=0的整数
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        return str != null && str.matches(Constant.REG_NUMBER);
    }

    /**
     * 判断是否为字母
     *
     * @param str
     * @return
     */
    public static boolean isLetter(String str) {
        return str != null && str.matches(Constant.REG_WORD);
    }

    /**
     * 邮箱是否合法
     *
     * @param str
     * @return
     */
    public static boolean isEmail(String str) {
        return str != null && str.matches(Constant.REG_EMAIL);
    }

    /**
     * 验证是否为手机号
     *
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {
        return str != null && str.matches(Constant.REG_MOBILE);
    }

    /**
     * 身份证校验及18位身份证最后一位校验
     *
     * @param str
     * @return
     */
    public static boolean isIdcard(String str) {
        if (str != null && str.matches(Constant.REG_IDCARD)) {
            if (!isDate(IdcardUtil.getBirthday(str))) {
                return false;
            }
            if (str.length() == 18) {
                // 加权因子
                int[] factor = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
                // 校验位
                int[] parity = {1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2};
                int sum = 0;
                int ai;
                int wi;
                for (int i = 0; i < 17; i++) {
                    ai = str.charAt(i) - '0';
                    wi = factor[i];
                    sum += ai * wi;
                }
                if (parity[sum % 11] == 'X') {
                    parity[sum % 11] = 'X' - '0';
                }
                if (parity[sum % 11] != (str.charAt(17) - '0')) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 校验时间格式
     * 支持格式：
     * yyyyMMdd |  yyyyMMdd HH:mm:ss
     * yyyy-MM-dd
     * yyyy/MM/dd
     * yyyy.MM.dd
     * yyyy年MM月dd日
     *
     * @param str
     * @return
     */
    public static boolean isDate(String str) {
        if (str != null) {
            Pattern regDate = Pattern.compile(Constant.REG_DATE);
            Matcher matcher = regDate.matcher(str);
            if (matcher.find()) {
                int year = Integer.parseInt(matcher.group(1));
                int month = Integer.parseInt(matcher.group(3));
                int day = Integer.parseInt(matcher.group(5));
                if (matcher.group(6) != null) {
                    int hour = Integer.parseInt(matcher.group(8));
                    int min = Integer.parseInt(matcher.group(10));
                    int second = Integer.parseInt(matcher.group(13));
                    return isDay(year, month, day) && isTime(hour, min, second);
                }
                return isDay(year, month, day);
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 判断日期是否合法
     *
     * @param year  年 从1800-2999年
     * @param month 月
     * @param day   日
     * @return boolean
     */
    public static boolean isDay(int year, int month, int day) {
        // 验证年
        if (year < 1800 || year > 2999) {
            return false;
        }
        // 验证月份
        if (month < 1 || month > 12) {
            return false;
        }
        // 验证日期
        if (day < 1 || day > 31) {
            return false;
        }
        // 判断日期是否合法
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }
        if (month == 2) {
            if (DateUtil.isLeapYear(year)) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        }
        return true;
    }

    /**
     * 判断是否为时分秒
     *
     * @param hour   时
     * @param min    分
     * @param second 秒
     * @return boolean
     */
    public static boolean isTime(int hour, int min, int second) {
        return (hour >= 0 && hour <= 24) && (min >= 0 && min <= 60) && (second >= 0 && second <= 60);
    }


    /**
     * 判断是否为ipv4
     *
     * @param ip ip地址
     * @return boolean
     */
    public static boolean isIPv4(String ip) {
        return ip != null && ip.matches(Constant.REG_IPV4);
    }

    /**
     * 判断是否为ipv6
     *
     * @param ip ip地址
     * @return boolean
     */
    public static boolean isIpv6(String ip) {
        return ip != null && ip.matches(Constant.REG_IPV6);
    }

    /**
     * 判断是否为ip地址 含[ipv4 ipv6]
     *
     * @param ip ip地址
     * @return boolean
     */
    public static boolean isIp(String ip) {
        return isIPv4(ip) || isIpv6(ip);
    }

    /**
     * 判断是否为mac地址
     *
     * @param mac mac地址
     * @return boolean
     */
    public static boolean isMac(String mac) {
        return mac != null && mac.matches(Constant.REG_MAC);
    }

    /**
     * 车牌号码
     *
     * @param plateNum 车牌号码
     * @return boolean
     */
    public static boolean isPlate(String plateNum) {
        return plateNum != null && plateNum.matches(Constant.REG_PLATE);
    }

    /**
     * url正则匹配
     *
     * @param url 是否为url
     * @return boolean
     */
    public static boolean isUrl(String url) {
        return url != null && url.matches(Constant.REG_URL);
    }

    public static boolean isWindows(){
        String sysName = System.getProperty("os.name");
        return sysName.toLowerCase().contains(Constant.WIN);
    }
}
