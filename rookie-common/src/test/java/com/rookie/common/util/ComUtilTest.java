package com.rookie.common.util;

import com.rookie.common.resource.AreaCode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

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
        Assert.assertTrue(ComUtil.isDate("2018 02 27 23:13:60"));
    }

    @Test
    public void isIpv4Test(){
        Assert.assertTrue(ComUtil.isIp("132.13.21.0"));
    }

    @Test
    public void isPlateTest(){
        Assert.assertTrue(ComUtil.isPlate("京A06088"));
    }

    @Test
    public void getProvinceTest(){
        Map<String, String> province = AreaCode.getProvince();
        System.out.println(province.size());
        for (String s : province.keySet()) {
            System.out.println(province.get(s));
        }
    }
    @Test
    public void getCityTest(){
        List<Map<String, Object>> city = AreaCode.getCity();
        System.out.println(city.size());
        System.out.println(city);
    }

    @Test
    public void getAllProvincesTest(){
        List<Map<String, Object>> city = AreaCode.getArea();
        System.out.println(city.size());
        System.out.println(city);
    }

}
