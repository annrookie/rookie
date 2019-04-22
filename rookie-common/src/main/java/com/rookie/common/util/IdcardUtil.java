package com.rookie.common.util;

import com.rookie.common.resource.AreaCode;
import com.rookie.common.resource.Constant;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * 身份证工具类[支持中国15位/18位身份证]
 *
 * @author This
 * @version 1.0
 * @date 2019/4/12 9:36
 */
public class IdcardUtil {

    /**
     * 判断身份证的合法性
     *
     * @param idCard 待验证的身份证
     * @return 是否有效的18位身份证
     */
    public static boolean isValidCard(String idCard) {
        if ((idCard == null || !idCard.matches(Constant.REG_IDCARD))) {
            return false;
        }
        if (idCard.length() == Constant.IDCARD_LENGTH_15) {
            idCard = convert18(idCard);
        }
        if (idCard == null || idCard.length() != Constant.IDCARD_LENGTH_18) {
            return false;
        }

        // 判断省份是否存在
        if (!AreaCode.pro.keySet().contains(idCard.substring(0, 6))) {
            return false;
        }
        // 判断日期格式是否正确
        if (!ComUtil.isDate(idCard.substring(6, 14))) {
            return false;
        }
        return getCheckNumber(idCard.substring(0, 17)).equals(idCard.substring(17));
    }

    /**
     * 获取15或18位身份证出生日期
     *
     * @param idCard 身份证
     * @return [yyyyMMdd 日期格式 ,错误返回null]
     */
    public static String getBirthday(String idCard) {
        String birthday = null;
        if (Constant.IDCARD_LENGTH_15 == idCard.length()) {
            birthday = "19" + idCard.substring(6, 12);
        }
        if (Constant.IDCARD_LENGTH_18 == idCard.length()) {
            birthday = idCard.substring(6, 14);
        }
        if (ComUtil.isDate(birthday)) {
            return birthday;
        } else {
            return null;
        }
    }

    /**
     * 获取生日日期，已固定格式
     *
     * @param idCard 身份证号码
     * @param format 格式支持 yyyyMMdd | yyyy.MM.DD | yyyy-MM-dd | yyyy/MM/dd | yyyy年MM月dd日 | yyyy MM dd
     * @return 时间字符串
     */
    public static String getBirthday(String idCard, String format) {
        String birthday = getBirthday(idCard);
        int i = ArrayUtil.indexOf(Constant.DATE_FORMAT, format);
        if (i > -1) {
            return DateUtil.changeFormat(birthday, "yyyyMMdd", Constant.DATE_FORMAT[i]);
        } else {
            return birthday;
        }
    }

    /**
     * 获取出生年份
     *
     * @param idCard 身份证
     * @return 出生年份字符串
     */
    public static String getBirthYear(String idCard) {
        String birthday = getBirthday(idCard);
        return birthday != null ? birthday.substring(0, 4) : null;
    }

    /**
     * 获取出生月份
     *
     * @param idCard 身份证
     * @return 月份字符串
     */
    public static String getBirthMonth(String idCard) {
        String birthday = getBirthday(idCard);
        return birthday != null ? birthday.substring(4, 6) : null;
    }

    /**
     * 获取出生 日期 天
     *
     * @param idCard 身份证
     * @return 天数字符串
     */
    public static String getBirthDate(String idCard) {
        String birthday = getBirthday(idCard);
        return birthday != null ? birthday.substring(6) : null;
    }

    /**
     * 获取年龄
     *
     * @param idCard 身份证
     * @return 年龄
     */
    public static int getAge(String idCard) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowDate = sdf.format(date);
        int nowYear = Integer.parseInt(nowDate.substring(0, 4));
        int nowMonth = Integer.parseInt(nowDate.substring(4, 6));
        int nowDay = Integer.parseInt(nowDate.substring(6));
        String birthday = getBirthday(idCard);
        if (birthday == null) {
            return -1;
        }
        int birthYear = Integer.parseInt(birthday.substring(0, 4));
        int birthMonth = Integer.parseInt(birthday.substring(4, 6));
        int birthDay = Integer.parseInt(birthday.substring(6));

        int age = nowYear - birthYear;
        if (nowMonth - birthMonth > 0) {
            return age;
        }
        if (nowMonth - birthMonth == 0 && nowDay - birthDay >= 0) {
            return age;
        }
        return age - 1;
    }

    /**
     * 获取身份证性别 【1：男 ， 0：女 ， -1：身份证有误】
     *
     * @param idCard 身份证号码
     * @return int性别
     */
    public static int getGender(String idCard) {
        if (idCard.length() == Constant.IDCARD_LENGTH_15) {
            idCard = convert18(idCard);
        }
        int gender = -1;
        if (!isValidCard(idCard)) {
            return gender;
        }
        char sCardChar = idCard.charAt(16);
        if ((sCardChar - '0') % 2 != 0) {
            gender = 1;
        } else {
            gender = 0;
        }
        return gender;
    }

    /**
     * 15位身份证号码转18位身份证号码
     *
     * @param idCard 15位身份证
     * @return 18位身份证号码
     */
    public static String convert18(String idCard) {
        // 判断身份证长度是否为15
        if (idCard.length() != Constant.IDCARD_LENGTH_15) {
            return null;
        }
        // 获取省市集合
        Set<Object> provinceSet = AreaCode.pro.keySet();
        String idPro = idCard.substring(0, 6);
        // 判断省份是否正确
        if (!provinceSet.contains(idPro)) {
            return null;
        }
        // 判断日期格式是否正确
        String birthday = "19" + idCard.substring(6, 12);
        if (!ComUtil.isDate(birthday)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(idCard.substring(0, 6));
        sb.append(birthday);
        sb.append(idCard.substring(12));
        return sb.toString() + getCheckNumber(sb.toString());
    }

    /**
     * 获取身份证校验位【第18位】 返回字符串 x为大写
     *
     * @param code 长度17的身份证号码
     * @return 校验位
     */
    public static String getCheckNumber(String code) {
        int sum = 0;
        if (code.length() == Constant.POWER.length) {
            for (int i = 0; i < code.length(); i++) {
                sum += (code.charAt(i) - '0') * Constant.POWER[i];
            }
        }
        switch (sum % 11) {
            case 0:
                return "1";
            case 1:
                return "0";
            case 2:
                return "X";
            case 3:
                return "9";
            case 4:
                return "8";
            case 5:
                return "7";
            case 6:
                return "6";
            case 7:
                return "5";
            case 8:
                return "4";
            case 9:
                return "3";
            case 10:
                return "2";
            default:
                return "";
        }
    }

    /**
     * 获取身份证省份城市
     *
     * @param idCard 身份证
     * @return 省份城市|不存在为空
     */
    public static String getArea(String idCard) {
        if (!isValidCard(idCard)) {
            return Constant.EMPTY;
        }
        String code = idCard.substring(0, 6);
        Set<Object> areaCode = AreaCode.pro.keySet();
        if (areaCode.contains(code)) {
            return AreaCode.pro.getProperty(code);
        }
        return Constant.EMPTY;
    }
}
