package com.rookie.common.util;

import com.rookie.common.filter.Accept;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author This
 * @version 1.0
 * @date 2019/4/3 17:44
 */
public class ArrayTest {
    @Test
    public void packArr() {
        Long[] i = {1L, 32L, 2L, 41L, 5L};
        String arrType = ArrayUtil.getArrType(ArrayUtil.unWrap(i));
        System.out.println(arrType);
    }

    @Test
    public void splitArrTest() {
        Integer[] i = {1, 321, 41, 51, 6};
        Object[] objects = ArrayUtil.splitArr(i, 2);
        System.out.println(objects.length);
        for (Object o : objects) {
            if (ArrayUtil.isArray(o)) {
                Object[] os = (Object[]) o;
                for (Object o1 : os) {
                    System.out.println("--->" + o1);
                }
            }
            System.out.println("=========");
        }
    }

    @Test
    public void insertTest() {
        int[] i = {1, 2, 3, 4};
        String[] b = {"123", "234"};
        Object[] obj = ArrayUtil.rAdd(ArrayUtil.wrap(i), "null");
        for (Object o : obj) {
            System.out.println(o);
        }
    }

    @Test
    public void filterTest() {
        int[] i = {1, 23, 51, 6, 7};
        Integer[] filter = ArrayUtil.filter(ArrayUtil.wrap(i), (Accept<Integer>) t -> t > 7);
        for (Integer integer : filter) {
            System.out.println(integer);
        }
    }

    @Test
    public void filterRepTest() {
        String[] str = {"123", "hello", "134", "xxx"};
        Object[] obj = ArrayUtil.filter(str, "world", t -> t.equals("hello"));
        for (Object o : obj) {
            System.out.println(o);
        }
    }

    @Test
    public void filterNullTest() {
        String[] arr = {"123", null, "null", "fakc"};
        String[] strings = ArrayUtil.filterNulls(arr);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    @Test
    public void filterEmptyTest() {
        String[] arr = {"123", null, "", "null"};
        String[] strings = ArrayUtil.filterEmptys(arr);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    @Test
    public void toStringTest() {
        Object[] obj = {"ad13", 231, 'c', new int[]{234, 123}, new ArrayList()};
        String[] s = {"123"};
        String s1 = ArrayUtil.toString(obj);
        System.out.println(s1);
    }

    @Test
    public void addTest() {
        short[] i = {1, 3, 345, 6, 8};
        short[] is = {124, 436};
        short[] ints = ArrayUtil.add(i, is);
        System.out.println(ArrayUtil.toString(ints));
    }

    @Test
    public void containsTest() {
        int[] s = {123, 13423, 14, 0};
        Assert.assertFalse(ArrayUtil.contains(s, 1));
    }

    @Test
    public void indexOfTest() {
        String[] s = {"hello", "abc", "张三", null, ""};
        Assert.assertEquals(4, ArrayUtil.lastIndexOf(s, ""));
    }

    @Test
    public void indexOf1Test() {
        char[] i = {123, 4, 53, 361, 123};
        Assert.assertEquals(-1, ArrayUtil.indexOf(i, 'A'));
    }

    @Test
    public void subArrayTest() {
        String[] s = {"abc", "132", "21312", "caas", "12312"};
        String[] strings = ArrayUtil.subArray(s, 1);
        System.out.println(ArrayUtil.toString(strings));
    }
    @Test
    public void subArray1Test() {
        int[] i = {1, 3, 325, 563, 41};
        int[] ints = ArrayUtil.subArray(i, 1);
        System.out.println(ArrayUtil.toString(ints));
    }

}
