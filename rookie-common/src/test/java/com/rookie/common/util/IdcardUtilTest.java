package com.rookie.common.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author This
 * @version 1.0
 * @className IdcardUtilTest
 * @description TODO
 * @date 2019/4/17 16:03
 */
public class IdcardUtilTest {
    @Test
    public void convert18Test(){
        String s = IdcardUtil.convert18("330719196804253671");
        System.out.println(s);
    }
    @Test
    public void isValidCardTest(){
        Assert.assertTrue(IdcardUtil.isValidCard("330719196804253671"));
    }

    @Test
    public void getBirthdayTest(){
        String birthday = IdcardUtil.getBirthday("330719196804253671","yyyy年MM月dd日");
        System.out.println(birthday);
    }


    @Test
    public void getBirthYearTest(){
        String birthday = IdcardUtil.getBirthYear("330719196804253671");
        System.out.println(birthday);
    }

    @Test
    public void getBirthMonthTest(){
        String birthday = IdcardUtil.getBirthDate("330719196804253671");
        System.out.println(birthday);
    }

    @Test
    public void getAgeTest(){
        int birthday = IdcardUtil.getAge("330719196804253671");
        System.out.println(birthday);
    }

    @Test
    public void getGenderTest(){
        int i = IdcardUtil.getGender("330719196804253671");
        System.out.println(i);
    }
}
