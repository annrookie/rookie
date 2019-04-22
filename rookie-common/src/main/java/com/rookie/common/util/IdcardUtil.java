package com.rookie.common.util;

import com.rookie.common.resource.Constant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author This
 * @version 1.0
 * @className IDcardUtil
 * @description TODO
 * @date 2019/4/12 9:36
 */
public class IdcardUtil {
    /**
     * 中国公民身份证号码最小长度。
     */
    private static final int IDCARD_LENGTH_15 = 15;
    /**
     * 中国公民身份证号码最大长度。
     */
    private static final int IDCARD_LENGTH_18 = 18;
    /**
     * 每位加权因子
     */
    private static final int power[] = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    /**
     * 省市代码表
     */
    private static Map<String, String> province = new HashMap<String, String>();
    /**
     * 台湾身份首字母对应数字
     */
    private static Map<String, Integer> twFirstCode = new HashMap<String, Integer>();
    /**
     * 香港身份首字母对应数字
     */
    private static Map<String, Integer> hkFirstCode = new HashMap<String, Integer>();

    static {
        province.put("11", "北京");
        province.put("12", "天津");
        province.put("13", "河北");
        province.put("14", "山西");
        province.put("15", "内蒙古");
        province.put("21", "辽宁");
        province.put("22", "吉林");
        province.put("23", "黑龙江");
        province.put("31", "上海");
        province.put("32", "江苏");
        province.put("33", "浙江");
        province.put("34", "安徽");
        province.put("35", "福建");
        province.put("36", "江西");
        province.put("37", "山东");
        province.put("41", "河南");
        province.put("42", "湖北");
        province.put("43", "湖南");
        province.put("44", "广东");
        province.put("45", "广西");
        province.put("46", "海南");
        province.put("50", "重庆");
        province.put("51", "四川");
        province.put("52", "贵州");
        province.put("53", "云南");
        province.put("54", "西藏");
        province.put("61", "陕西");
        province.put("62", "甘肃");
        province.put("63", "青海");
        province.put("64", "宁夏");
        province.put("65", "新疆");
        province.put("71", "台湾");
        province.put("81", "香港");
        province.put("82", "澳门");
        province.put("91", "国外");

        twFirstCode.put("A", 10);
        twFirstCode.put("B", 11);
        twFirstCode.put("C", 12);
        twFirstCode.put("D", 13);
        twFirstCode.put("E", 14);
        twFirstCode.put("F", 15);
        twFirstCode.put("G", 16);
        twFirstCode.put("H", 17);
        twFirstCode.put("J", 18);
        twFirstCode.put("K", 19);
        twFirstCode.put("L", 20);
        twFirstCode.put("M", 21);
        twFirstCode.put("N", 22);
        twFirstCode.put("P", 23);
        twFirstCode.put("Q", 24);
        twFirstCode.put("R", 25);
        twFirstCode.put("S", 26);
        twFirstCode.put("T", 27);
        twFirstCode.put("U", 28);
        twFirstCode.put("V", 29);
        twFirstCode.put("X", 30);
        twFirstCode.put("Y", 31);
        twFirstCode.put("W", 32);
        twFirstCode.put("Z", 33);
        twFirstCode.put("I", 34);
        twFirstCode.put("O", 35);

        // 持证人拥有香港居留权
        hkFirstCode.put("A", 1);
        // 持证人所报称的出生日期或地点自首次登记以后，曾作出更改
        hkFirstCode.put("B", 2);
        // 持证人登记领证时在香港的居留受到入境事务处处长的限制
        hkFirstCode.put("C", 3);
        // 持证人所报的姓名自首次登记以后，曾作出更改
        hkFirstCode.put("N", 14);
        // 持证人报称在香港、澳门及中国以外其他地区或国家出生
        hkFirstCode.put("O", 15);
        // 持证人拥有香港入境权
        hkFirstCode.put("R", 18);
        // 持证人登记领证时在香港的居留不受入境事务处处长的限制
        hkFirstCode.put("U", 21);
        // 持证人报称在澳门地区出生
        hkFirstCode.put("W", 23);
        // 持证人报称在中国大陆出生
        hkFirstCode.put("X", 24);
        // 持证人报称在香港出生
        hkFirstCode.put("Z", 26);
    }
    //------------ 以下方法只适用中国15/18位身份证
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
        if (idCard.length() == IDCARD_LENGTH_15) {
            idCard = convert18(idCard);
        }
        if (idCard == null || idCard.length() != IDCARD_LENGTH_18) {
            return false;
        }

        // 判断省份是否存在
        if (!province.keySet().contains(idCard.substring(0, 2))) {
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
        if (IDCARD_LENGTH_15 == idCard.length()) {
            birthday = "19" + idCard.substring(6, 12);
        }
        if (IDCARD_LENGTH_18 == idCard.length()) {
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
     * @param idCard 身份证
     * @return 出生年份字符串
     */
    public static String getBirthYear(String idCard){
        String birthday = getBirthday(idCard);
        return birthday != null ? birthday.substring(0,4) : null;
    }

    /**
     * 获取出生月份
     * @param idCard 身份证
     * @return 月份字符串
     */
    public static String getBirthMonth(String idCard){
        String birthday = getBirthday(idCard);
        return birthday != null ? birthday.substring(4,6) : null;
    }

    /**
     * 获取出生 日期 天
     * @param idCard 身份证
     * @return 天数字符串
     */
    public static String getBirthDate(String idCard){
        String birthday = getBirthday(idCard);
        return birthday != null ? birthday.substring(6) : null;
    }

    /**
     * 获取年龄
     * @param idCard 身份证
     * @return 年龄
     */
    public static int getAge(String idCard){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowDate = sdf.format(date);
        int nowYear = Integer.parseInt(nowDate.substring(0,4));
        int nowMonth = Integer.parseInt(nowDate.substring(4,6));
        int nowDay = Integer.parseInt(nowDate.substring(6));
        String birthday = getBirthday(idCard);
        if (birthday == null){
            return -1;
        }
        int birthYear = Integer.parseInt(birthday.substring(0,4));
        int birthMonth = Integer.parseInt(birthday.substring(4,6));
        int birthDay = Integer.parseInt(birthday.substring(6));

        int age = nowYear - birthYear;
        if (nowMonth - birthMonth > 0){
            return age;
        }
        if (nowMonth - birthMonth == 0 && nowDay - birthDay >= 0){
            return age;
        }
        return age - 1;
    }

    /**
     * 获取身份证性别 【1：男 ， 0：女 ， -1：身份证有误】
     * @param idCard 身份证号码
     * @return int性别
     */
    public static int getGender(String idCard){
        if (idCard.length() == IDCARD_LENGTH_15){
            idCard = convert18(idCard);
        }
        int gender = -1;
        if (!isValidCard(idCard)){
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
        if (idCard.length() != IDCARD_LENGTH_15) {
            return null;
        }
        // 获取省份集合
        Set<String> provinceSet = province.keySet();
        String idPro = idCard.substring(0, 2);
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
        if (code.length() == power.length) {
            for (int i = 0; i < code.length(); i++) {
                sum += (code.charAt(i) - '0') * power[i];
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
}
