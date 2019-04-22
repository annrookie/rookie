package com.rookie.common.util;

import org.junit.Test;

/**
 * @author This
 * @version 1.0
 * @date 2019/4/22 16:16
 */
public class DateTest {
    @Test
    public void getDateTest(){
        System.out.println(DateUtil.getDate());
    }

    @Test
    public void getTimeTest(){
        System.out.println(DateUtil.getTime());
    }
}
