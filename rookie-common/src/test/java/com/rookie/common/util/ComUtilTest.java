package com.rookie.common.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author This
 * @version 1.0
 * @date 2019/4/12 10:08
 */
public class ComUtilTest {
    @Test
    public void isEmptyTest(){
        String str = "";
        Assert.assertTrue(ComUtil.isEmpty(new String[0]));
    }

    @Test
    public void isCommonTest(){
        Assert.assertTrue(ComUtil.isCommon("_12"));
    }
    @Test
    public void isChineseTest(){
        Assert.assertTrue(ComUtil.isChinese("安抚"));
    }
    @Test
    public void isLetter(){
        Assert.assertTrue(ComUtil.isLetter("qe"));
    }

    @Test
    public void isNumberTest(){
        Assert.assertTrue(ComUtil.isNumber("0"));
    }

    @Test
    public void isEmailTest(){
        Assert.assertTrue(ComUtil.isEmail("1.2+2133@qq.com.cn"));
    }

    @Test
    public void isMobileTest(){
        Assert.assertTrue(ComUtil.isMobile("16690843241"));
    }

    @Test
    public void isIdcardTest(){
        Assert.assertTrue(ComUtil.isIdcard("330719196804253671"));
    }

    @Test
    public void isDateTest(){
        Assert.assertTrue(ComUtil.isDate("2016/02/29"));
    }

    @Test
    public void isIpv4Test(){
        Assert.assertTrue(ComUtil.isIp("132.13.21.0"));
    }

    @Test
    public void isPlateTest(){
        Assert.assertTrue(ComUtil.isPlate("京A06088"));
    }
}
