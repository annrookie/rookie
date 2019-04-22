package com.rookie.common.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author This
 * @version 1.0
 * @date 2019/4/3 10:38
 */
public class StrUtilTest {
    @Test
    public void blankTest(){
        String str = "      ";
        Assert.assertTrue(StrUtil.isBlank(str));
    }
    @Test
    public void existBlankTest(){
        Assert.assertFalse(StrUtil.existBlank("ada qwe"));
    }
    @Test
    public void emptyToStrTest(){
        Assert.assertEquals("a",StrUtil.emptyToStr("","a"));
    }
    @Test
    public void nullToEmptyTest(){
        Assert.assertEquals("",StrUtil.nullToEmpty(null));
    }
    @Test
    public void emptyToNullTest(){
        Assert.assertEquals(null,StrUtil.emptyToNull(""));
    }

    @Test
    public void blankToEmptyTest(){
        Assert.assertEquals("",StrUtil.blankToEmpty("   "));
    }
    @Test
    public void existEmptyTest(){
        Assert.assertTrue(StrUtil.existEmpty("123","3123",null));
    }
    @Test
    public void isAllEmptyTest(){
        Assert.assertTrue(StrUtil.isAllEmpty("",null));
    }
    @Test
    public void isNullOrUndefinedTest(){
        Assert.assertTrue(StrUtil.isNullOrUndefined("undefined"));
    }
    @Test
    public void isEmptyOrUndefinedTest(){
        Assert.assertTrue(StrUtil.isEmptyOrUndefined("null"));
    }
    @Test
    public void isBlankOrUndefinedTest(){
        Assert.assertTrue(StrUtil.isBlankOrUndefined(null));
    }
    @Test
    public void trimTest(){
        Assert.assertEquals("1",StrUtil.trim("      1      "));
    }
    @Test
    public void trimTestArr(){
        String[] arr = {"",null,"12321 ","   3 21   "};
        String[] arr1 = StrUtil.trim(arr);
        for (String s : arr1) {
            System.out.println(s);
        }
    }
    @Test
    public void trimLeftTest(){
        Assert.assertEquals("asd   ",StrUtil.trimLeft("   asd   "));
    }
    @Test
    public void firstToLower(){
        Assert.assertEquals("aNv",StrUtil.firstToLower("aNv"));
    }
    @Test
    public void removeBlankTest(){
        String s = "  哈       哈 哈 ";
//        System.out.println(StrUtil.removeBlank(s));
        Assert.assertEquals("哈哈哈",StrUtil.removeBlank(s));
    }
    @Test
    public void countTest(){
//        System.out.println(StrUtil.count("asdferqwiofdsfkmkcds","d"));
        Assert.assertEquals(3,StrUtil.count("asdferqwiodfsfkmkcdfs",'d'));
    }
}
