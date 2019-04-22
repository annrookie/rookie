package com.rookie.common.util;

import com.rookie.common.resource.Constant;

import java.util.UUID;

/**
 * 字符串工具类
 *
 * @author This
 * @version 1.0
 * @date 2019/4/3 10:25
 */
public class StrUtil {

//    public static final String EMPTY = "";

    /**
     * 判断字符串是否为空白字符串
     *
     * @param str 需判断的字符串
     * @return 空白字符串返回true
     */
    public static boolean isBlank(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!isBlank(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符是否为空白符，空白符包括空格、制表符、全角空格和不间断空格
     *
     * @param c 字符
     * @return 是否为空
     */
    public static boolean isBlank(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c) || c == '\ufeff' || c == '\u202a';
    }

    /**
     * 字符串不为空白字符串
     *
     * @param str 判断的字符串
     * @return 不为空白字符串返回true
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 判断是否包含空白符字符串
     *
     * @param strs 字符串或字符串数组
     * @return 包含返回true
     */
    public static boolean existBlank(String... strs) {
        if (strs == null || strs.length == 0) {
            return true;
        }
        for (String str : strs) {
            if (isBlank(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断全部字符串是否为空
     *
     * @param strs 全部字符串
     * @return 全为空返回 true
     */
    public static boolean isAllBlank(String... strs) {
        if (strs == null || strs.length == 0) {
            return true;
        }
        for (String str : strs) {
            if (isNotBlank(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 空字符串转为指定字符串
     *
     * @param str    需要转换的空字符串
     * @param newStr 指定字符串
     * @return 指定字符串或本身
     */
    public static String blankToStr(String str, String newStr) {
        return isBlank(str) ? newStr : str;
    }

    /**
     * 空白字符串转为""
     *
     * @param str 需转换的空白字符串
     * @return ""或本身
     */
    public static String blankToEmpty(String str) {
        return isBlank(str) ? Constant.EMPTY : str;
    }

    //-------------------------------------------------------------------------

    /**
     * 判断字符串是否为空
     * 空字符串定义
     * null 或 ""
     *
     * @param str 判断的字符串
     * @return 为空返回true
     */
    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断多个字符串中是包含空字符串
     *
     * @param strs 多个字符串
     * @return 包含空字符串返回true
     */
    public static boolean existEmpty(String... strs) {
        if (strs == null || strs.length == 0) {
            return true;
        }
        for (String str : strs) {
            if (isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断一组字符串是否全部为空
     *
     * @param strs 需验证的字符串
     * @return 为空返回true
     */
    public static boolean isAllEmpty(String... strs) {
        if (strs == null || strs.length == 0) {
            return true;
        }
        for (String str : strs) {
            if (isNotEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将null转为""，不为空返回本身
     *
     * @param str 需要转为空的null字符串
     * @return 空或本身
     */
    public static String nullToEmpty(String str) {
        return str == null ? Constant.EMPTY : str;
    }

    /**
     * 将空字符串转换为指定字符串
     *
     * @param str    需转换的空字符串
     * @param newStr 指定字符串
     * @return 指定字符串
     */
    public static String emptyToStr(String str, String newStr) {
        return isEmpty(str) ? newStr : str;
    }

    /**
     * 空字符串转为null
     * 不为空返回本身
     *
     * @param str 需转换的空字符串
     * @return 本身或null
     */
    public static String emptyToNull(String str) {
        return Constant.EMPTY.equals(str) ? null : str;
    }

    /**
     * 判断是否为null "null" 或 "undefined"
     *
     * @param str 字符串
     * @return boolean
     */
    public static boolean isNullOrUndefined(String str) {
        return str == null || isNullOrUndefinedStr(str);
    }

    /**
     * 判断是否为空 或"null","undefined"
     *
     * @param str 需要判断的字符串
     * @return boolean
     */
    public static boolean isEmptyOrUndefined(String str) {
        return isEmpty(str) || isNullOrUndefinedStr(str);
    }

    /**
     * 判断是否为空白字符串或null ,"null","defined"
     *
     * @param str 进行判断的字符串
     * @return boolean
     */
    public static boolean isBlankOrUndefined(String str) {
        return isBlank(str) || isNullOrUndefinedStr(str);
    }

    /**
     * 判断是否为null或undefined字符串
     *
     * @param str 需校验的字符串
     * @return boolean
     */
    private static boolean isNullOrUndefinedStr(String str) {
        return "null".equals(str.trim()) || "undefined".equals(str.trim());
    }

    //------------------------------------------------------


    /**
     * 字符串左右两边去空
     *
     * @param str 去空字符串
     * @return 去完空字符串
     */
    public static String trim(String str) {
        return (str == null) ? null : trim(str, 0);
    }

    /**
     * 字符串数组中字符串左右去空
     *
     * @param strs 需去空的字符串数组
     * @return 左右去空的字符串数组
     */
    public static String[] trim(String[] strs) {
        if (strs == null) {
            return null;
        }
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] != null) {
                strs[i] = strs[i].trim();
            }
        }
        return strs;
    }

    /**
     * 字符串去空，分左去空，两边去空，右去空
     *
     * @param str  需要去空的字符串
     * @param type <code>0</code> 去左右两边空格 <code>-1</code> 去左边空格 <code>1</code> 去右边空格
     * @return 去空完字符串 null = null
     */
    public static String trim(String str, int type) {
        if (str == null) {
            return null;
        }

        int length = str.length();
        int start = 0;
        int end = length;

        // 扫描字符串左边
        if (type <= 0) {
            while ((start < end) && (isBlank(str.charAt(start)))) {
                start++;
            }
        }
        // 扫描字符串右边
        if (type >= 0) {
            while ((start < end) && (isBlank(str.charAt(end - 1)))) {
                end--;
            }
        }
        //去空左右两边空格
        if (start > 0 || end < length) {
            return str.substring(start, end);
        }
        return str;
    }

    /**
     * 字符串左去空
     *
     * @param str
     * @return
     */
    public static String trimLeft(String str) {
        return trim(str, -1);
    }

    /**
     * 字符串右去空
     *
     * @param str 须去空格字符串
     * @return 去空字符串
     */
    public static String trimRight(String str) {
        return trim(str, 1);
    }

    //--------------------------------------------------------

    /**
     * 首字母转大写
     *
     * @param str 需转换的字符串
     * @return 首字母大写字符串或本身
     */
    public static String firstToUpper(String str) {
        if (isEmpty(str)) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!isBlank(str.charAt(i))) {
                if (str.charAt(i) < 'a' || str.charAt(i) > 'z') {
                    return str;
                }
                return trimLeft(str.substring(0, i + 1)).toUpperCase() + str.substring(i + 1);
            }
        }
        return str;
    }

    /**
     * 字符串首字母转小写
     *
     * @param str 字符串
     * @return 首字母小写字符或本身
     */
    public static String firstToLower(String str) {
        if (isEmpty(str)) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!isBlank(str.charAt(i))) {
                if (str.charAt(i) < 'A' || str.charAt(i) > 'Z') {
                    return str;
                }
                return trimLeft(str.substring(0, i + 1)).toLowerCase() + str.substring(i + 1);
            }
        }
        return str;
    }

    /**
     * 去掉字符串空白字符
     *
     * @param str 目标字符串
     * @return 去空字符串
     */
    public static String removeBlank(String str) {
        if (isEmpty(str.trim())) {
            return Constant.EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!isBlank(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 在字符串中查找一个字符串出现的次数
     * null 或 "" 返回0
     *
     * @param text      被查找的字符串
     * @param searchStr 需要查找的字符串
     * @return 出现次数
     */
    public static int count(String text, String searchStr) {
        if (existEmpty(text, searchStr) || searchStr.length() > text.length()) {
            return 0;
        }
        int num = 0;
        int index = 0;
        while ((index = text.indexOf(searchStr, index)) > -1) {
            num++;
            index += searchStr.length();
        }
        return num;
    }

    /**
     * 统计指定内容中包含指定字符的数量
     *
     * @param content       内容
     * @param charForSearch 被统计的字符
     * @return 包含数量
     */
    public static int count(String content, char charForSearch) {
        int count = 0;
        if (isEmpty(content)) {
            return 0;
        }
        int contentLength = content.length();
        for (int i = 0; i < contentLength; i++) {
            if (charForSearch == content.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 生成uuid
     *
     * @return uuid
     */
    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        String s = uuid.toString();
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }

    public static String hide(String str,int start,int end){
        if (isEmpty(str)){
            return Constant.EMPTY;
        }
        return null;
    }
}
