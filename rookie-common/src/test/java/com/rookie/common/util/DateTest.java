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
        System.out.println(DateUtil.getTimestamps());
    }

    @Test
    public void nowTimeTest(){
        System.out.println(DateUtil.nowTime());
    }
    @Test
    public void timestampToTimeTest(){
        System.out.println(DateUtil.timestampToTime(DateUtil.getTimestamp()));
    }

    @Test
    public void timestampsToTimeTest(){
        System.out.println(DateUtil.timestampsToTime(DateUtil.getTimestamps()));
    }

    @Test
    public void timeToDateTest(){
        System.out.println(DateUtil.timeToDate("2019-03-13"));
    }
}
