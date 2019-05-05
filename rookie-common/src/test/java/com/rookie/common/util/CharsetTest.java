package com.rookie.common.util;

import org.junit.Test;

import java.nio.charset.Charset;

/**
 * @author This
 * @version 1.0
 * @date 2019/5/5 15:04
 */
public class CharsetTest {
    @Test
    public void toCharsetTest(){
        System.out.println(CharsetUtil.toCharset("GB2312"));
    }

    @Test
    public void convertTest(){
        System.out.println(CharsetUtil.convert("读取为","gbk","utf-8"));
    }

    @Test
    public void sysDefaultCharsetTest(){
        System.out.println(CharsetUtil.sysDefaultCharset());
    }
}
