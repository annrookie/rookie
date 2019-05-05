package com.rookie.common.util;

import com.rookie.common.resource.Constant;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author This
 * @version 1.0
 * @date 2019/4/29 10:12
 */
public class CharsetUtil {

    /**
     * 将字符串字符格式转charset
     *
     * @param charsetName 字符串
     * @return charset
     * @throws java.nio.charset.UnsupportedCharsetException 不支持编码异常
     */
    public static Charset toCharset(String charsetName) {
        if (StrUtil.isBlank(charsetName) || StrUtil.isEmpty(charsetName)) {
            return defaultCharset();
        }
        return Charset.forName(charsetName);
    }

    /**
     * 将字符串转换为指定编码
     *
     * @param source      字符串
     * @param srcCharset  源编码 默认 ISO_8859_1
     * @param destCharset 转换目标编码 默认UTF-8
     * @return 转换完的字符串
     */
    public static String convert(String source, Charset srcCharset, Charset destCharset) {
        if (null == srcCharset) {
            srcCharset = StandardCharsets.ISO_8859_1;
        }

        if (null == destCharset) {
            destCharset = StandardCharsets.UTF_8;
        }

        if (StrUtil.isBlank(source) || srcCharset.equals(destCharset)) {
            return source;
        }
        return new String(source.getBytes(srcCharset), destCharset);
    }

    /**
     * 将字符串转换为指定编码
     *
     * @param source      字符串
     * @param srcCharset  源编码 默认 ISO_8859_1
     * @param destCharset 转换目标编码 默认UTF-8
     * @return 转换完的字符串
     */
    public static String convert(String source, String srcCharset, String destCharset) {
        return convert(source, toCharset(srcCharset), toCharset(destCharset));
    }

    /**
     * 获取系统字符集
     *
     * @return win返回GBK 否则返回默认字符集
     */
    public static Charset sysCharset() {
        return ComUtil.isWindows() ? toCharset(Constant.GBK) : defaultCharset();
    }

    /**
     * 默认字符编码 名字
     *
     * @return String
     */
    public static String sysDefaultCharset() {
        return defaultCharset().name();
    }

    /**
     * 默认字符编码
     *
     * @return 默认字符编码
     */
    public static Charset defaultCharset() {
        return Charset.defaultCharset();
    }
}
