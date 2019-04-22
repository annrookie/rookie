package com.rookie.common.util;

import com.rookie.common.filter.Accept;
import com.rookie.common.filter.Filter;
import com.rookie.common.resource.Constant;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组工具类
 * 注：基本数据类型使用泛型方法，需先进行装箱操作【 warp() 】,方可使用，判空访问除外
 *
 * @author This
 * @version 1.0
 * @date 2019/4/3 17:39
 */
public class ArrayUtil {

    /**
     * 判断是否为数组
     *
     * @param obj 进行判断的参数
     * @return 是返回true
     */
    public static boolean isArray(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.getClass().isArray();
    }

    /**
     * 判断不是为数组
     *
     * @param obj 进行判断的对象
     * @return 不是数组返回true
     */
    public static boolean isNotArray(Object obj) {
        return !isArray(obj);
    }

    /**
     * 判断数组为空
     * 空定义 "" 或 null
     *
     * @param array 进行判断的数组
     * @param <T>   数组泛型
     * @return 为空返回true
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断int[]是否为空
     *
     * @param array 判断的int[]数组
     * @return 为空返回true
     */
    public static boolean isEmpty(int[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断short[]是否为空
     *
     * @param array 判断的short[]数组
     * @return 为空返回true
     */
    public static boolean isEmpty(short[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断long[]是否为空
     *
     * @param array 判断的long[]数组
     * @return 为空返回true
     */
    public static boolean isEmpty(long[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断byte[]是否为空
     *
     * @param array 判断的byte[]数组
     * @return 为空返回true
     */
    public static boolean isEmpty(byte[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断boolean[]是否为空
     *
     * @param array 判断的boolean[]数组
     * @return 为空返回true
     */
    public static boolean isEmpty(boolean[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断float[]是否为空
     *
     * @param array 判断的float[]数组
     * @return 为空返回true
     */
    public static boolean isEmpty(float[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断double[]是否为空
     *
     * @param array 判断的double[]数组
     * @return 为空返回true
     */
    public static boolean isEmpty(double[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断char[]是否为空
     *
     * @param array 判断的char[]数组
     * @return 为空返回true
     */
    public static boolean isEmpty(char[] array) {
        return array == null || array.length == 0;
    }

    /**
     * 判断int[]是否为空
     *
     * @param array 判断的int[]数组
     * @return 为空返回true
     */
    public static boolean isNotEmpty(int[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断short[]是否为空
     *
     * @param array 判断的short[]数组
     * @return 为空返回true
     */
    public static boolean isNotEmpty(short[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断long[]是否为空
     *
     * @param array 判断的long[]数组
     * @return 为空返回true
     */
    public static boolean isNotEmpty(long[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断byte[]是否为空
     *
     * @param array 判断的byte[]数组
     * @return 为空返回true
     */
    public static boolean isNotEmpty(byte[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断boolean[]是否为空
     *
     * @param array 判断的boolean[]数组
     * @return 为空返回true
     */
    public static boolean isNotEmpty(boolean[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断float[]是否为空
     *
     * @param array 判断的float[]数组
     * @return 为空返回true
     */
    public static boolean isNotEmpty(float[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断double[]是否为空
     *
     * @param array 判断的double[]数组
     * @return 为空返回true
     */
    public static boolean isNotEmpty(double[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断char[]是否为空
     *
     * @param array 判断的char[]数组
     * @return 为空返回true
     */
    public static boolean isNotEmpty(char[] array) {
        return !isEmpty(array);
    }

    /**
     * 判断数组不为空
     * 不为null
     *
     * @param arr 进行判断的数组
     * @return 为空返回false
     */
    public static <T> boolean isNotEmpty(T[] arr) {
        return !isEmpty(arr);
    }

    /**
     * 获取数组对象的元素类型
     *
     * @param array 数组
     * @return 元素类型
     */
    public static String getArrType(Object array) {
        String type = null;
        if (array != null) {
            type = array.getClass().getComponentType().toString();
            if (type.startsWith("class")) {
                type = type.substring(type.lastIndexOf(".") + 1);
            }
        }
        return type;
    }

    /**
     * 获取数组对象的元素类型
     *
     * @param array 数组
     * @return 元素类型
     */
    public static Class<?> getComponentType(Object array) {
        return null == array ? null : array.getClass().getComponentType();
    }

    /**
     * 获取数组对象的元素类型
     *
     * @param arrayClass 数组Class
     * @return 元素类型
     */
    public static Class<?> getComponentType(Class<?> arrayClass) {
        return null == arrayClass ? null : arrayClass.getComponentType();
    }

    /**
     * 创建指定泛型，指定长度的数组
     *
     * @param arr  数组
     * @param size 长度
     * @param <T>  泛型
     * @return 创建指定泛型，指定长度的数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(T[] arr, int size) {
        return (T[]) Array.newInstance(getComponentType(arr), size);
    }

    /**
     * 创建指定泛型，指定长度的数组
     *
     * @param arrClass
     * @param size
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(Class<T> arrClass, int size) {
        return (T[]) Array.newInstance(getComponentType(arrClass), size);
    }

    /**
     * 创建指定泛型，数组
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> T[] newArray(T[] arr) {
        return newArray(arr, 0);
    }

    /**
     * 创建指定泛型，数组
     *
     * @param arrClass
     * @param <T>
     * @return
     */
    public static <T> T[] newArray(Class<T> arrClass) {
        return newArray(arrClass, 0);
    }

    //----------------------------带泛型方法start，需先进行装箱

    /**
     * 数组根据索引进行分割
     *
     * @param obj   分割数组
     * @param index 索引
     * @return Object[]
     */
    public static <T> Object[] splitArr(T[] obj, int index) {
        // 判断是否为数组并且是否为空
        if (isEmpty(obj)) {
            return obj;
        }
        if (index <= 0 || index >= obj.length - 1) {
            return obj;
        } else {
            T[] o1 = Arrays.copyOfRange(obj, 0, index);
            T[] o2 = Arrays.copyOfRange(obj, index, obj.length);
            List<T[]> list = new ArrayList<T[]>();
            list.add(o1);
            list.add(o2);
            return list.toArray();
        }
    }

    /**
     * 平均拆分数组
     *
     * @param obj 需要进行拆分的数组
     * @param num 拆分个数
     * @return 数组对象
     */
    public static <T> Object[] equalArr(T[] obj, int num) {
        if (isEmpty(obj) || num < 1 || num >= obj.length) {
            return obj;
        }

        // 根据等分个数，计算循环次数
        int count = (obj.length % num == 0) ? (obj.length / num) : (obj.length / num) + 1;
        List<T[]> list = new ArrayList<T[]>();
        int start = 0;
        int end = num;
        for (int i = 0; i < count; i++) {
            T[] o = Arrays.copyOfRange(obj, start, end);
            start = end;
            end = (end + num >= obj.length) ? obj.length : (end + num);
            list.add(o);
        }
        return list.toArray();
    }

    /**
     * 在一个数组某个位置添加第二个数组
     * 若只有一个元素 为 null 或空字符串""，则插入的数组为空，
     *
     * @param o       第一个数组
     * @param index   需要添加数据的索引位置
     * @param element 第二个数组
     * @param <T>     泛型
     * @return 新数组
     */
    @SuppressWarnings("unchecked")
    public static <T> Object[] insert(T[] o, int index, T... element) {
        if (isEmpty(o)) {
            return element;
        }
        if (isEmpty(element)) {
            return o;
        }

        if (element.length == 1 && "".equals(element[0])) {
            return o;
        }

        Object[] objects = new Object[o.length + element.length];
        if (index <= 0) {
            // 在第一个数组前方添加第二个数组
            System.arraycopy(element, 0, objects, 0, element.length);
            System.arraycopy(o, 0, objects, element.length, o.length);
        } else if (index >= o.length) {
            // 在第一个数组后追加第二个数组
            System.arraycopy(o, 0, objects, 0, o.length);
            System.arraycopy(element, 0, objects, o.length, element.length);
        } else {
            // 在第一个数组中间添加第二个数组
            System.arraycopy(o, 0, objects, 0, index);
            System.arraycopy(element, 0, objects, index, element.length);
            System.arraycopy(o, index, objects, index + element.length, o.length - index);
        }
        return objects;
    }

    /**
     * 在第一个数组后追加参数
     * 若两个为空则返回空
     *
     * @param obj     第一个数组
     * @param element 参数
     * @param <T>     泛型
     * @return 新数组
     */
    @SuppressWarnings("unchecked")
    public static <T> Object[] rAdd(T[] obj, T... element) {
        return insert(obj, obj.length, element);
    }

    /**
     * 在第一个数组前添加参数
     *
     * @param obj     第一个数组
     * @param element 参数
     * @param <T>     泛型
     * @return 添加完的新数组
     */
    @SuppressWarnings("unchecked")
    public static <T> Object[] lAdd(T[] obj, T... element) {
        return insert(obj, 0, element);
    }

    /**
     * 数组进行过滤操作
     *
     * @param arr    过滤的数组
     * @param accept 接收过滤的条件
     * @param <T>    泛型
     * @return 返回新的数组
     */
    public static <T> T[] filter(T[] arr, Accept<T> accept) {
        if (isEmpty(arr)) {
            return arr;
        }
        List<T> list = new ArrayList<T>();
        for (T t : arr) {
            if (accept.filter(t)) {
                list.add(t);
            }
        }
        T[] o = newArray(arr, list.size());
        return list.toArray(o);
    }

    /**
     * 数组过滤替换
     *
     * @param arr    过滤的数组
     * @param accept 接收过滤的条件
     * @param str    替换成的字符串
     * @param <T>    泛型
     * @return 返回新数组
     */
    public static <T> Object[] filter(T[] arr, String str, Accept<T> accept) {
        if (isEmpty(arr)) {
            return arr;
        }
        List<Object> list = new ArrayList<Object>();
        for (T t : arr) {
            if (str != null) {
                if (accept.filter(t)) {
                    list.add(str);
                } else {
                    list.add(t);
                }
            } else {
                return arr;
            }
        }
        Object[] o = newArray(arr, list.size());
        return list.toArray(o);
    }

    /**
     * 数组过滤
     *
     * @param arr    需过滤的数组
     * @param filter 实现过滤接口
     * @param <T>    泛型
     * @return 新数组
     */
    public static <T> T[] filter(T[] arr, Filter<T> filter) {
        if (isEmpty(arr)) {
            return arr;
        }
        List<T> list = new ArrayList<T>();
        for (T t : arr) {
            T param = filter.filter(t);
            if (null != param) {
                list.add(param);
            }
        }
        return list.toArray(Arrays.copyOf(arr, list.size()));
    }

    /**
     * 过滤null和null字符串
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> T[] filterNulls(T[] arr) {
        return filter(arr, (Filter<T>) t -> Constant.NULL.equals(t) ? null : t);
    }

    /**
     * 过滤null关键字
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> T[] filterNull(T[] arr) {
        return filter(arr, (Filter<T>) t -> t);
    }

    /**
     * 过滤空和null
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> T[] filterEmpty(T[] arr) {
        return filter(arr, (Filter<T>) t -> (Constant.EMPTY.equals(t) ? null : t));
    }

    /**
     * 过滤空、null和"null"字符串
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> T[] filterEmptys(T[] arr) {
        return filter(arr, (Filter<T>) t -> (Constant.EMPTY.equals(t) || Constant.NULL.equals(t)) ? null : t);
    }

    /**
     * 数组toString以[元素,元素]包装
     *
     * @param arr
     * @param <T>
     * @return
     */
    public static <T> String toString(T[] arr) {
        if (isEmpty(arr)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T t : arr) {
            sb.append(t);
            sb.append(",");
        }
        String s = sb.toString();
        return s.substring(0, s.length() - 1) + "]";
    }

    /**
     * 转为String[]
     *
     * @param arr 需要进行转换的数组
     * @param <T> 泛型
     * @return 输出String[]
     */
    public static <T> String[] toStringArray(T[] arr) {
        if (isEmpty(arr)) {
            return new String[0];
        }
        List<String> list = new ArrayList<String>();
        for (T t : arr) {
            if (t != null) {
                list.add(t + "");
            } else {
                list.add(null);
            }
        }
        String[] strArr = new String[list.size()];
        return list.toArray(strArr);
    }

    /**
     * 判断数组是否包含某个元素
     *
     * @param arr   数组
     * @param param 包含元素
     * @param <T>   泛型
     * @return boolean
     */
    public static <T> boolean contains(T[] arr, T param) {
        if (isEmpty(arr)) {
            return false;
        }

        for (T t : arr) {
            if (t == param) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断数组是否存在一个元素，存在返回该值的索引，否则-1
     *
     * @param arr   数组
     * @param param 存在元素
     * @param <T>   泛型
     * @return int
     */
    public static <T> int indexOf(T[] arr, T param) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i = 0; i < arr.length; i++) {
            if (param == arr[i]) {
                return i;
            }
        }
        return Constant.NEG_ONE;
    }

    /**
     * 获取最后一个出现的元素，若不存在返回-1
     *
     * @param arr   数组
     * @param param 元素
     * @param <T>   泛型
     * @return 返回索引或-1
     */
    public static <T> int lastIndexOf(T[] arr, T param) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (param == arr[i]) {
                return i;
            }
        }
        return Constant.NEG_ONE;
    }

    /**
     * 截取数组
     *
     * @param arr    被截取的数组
     * @param start  开始截取的索引
     * @param length 截取个数，超过剩余个数，截取剩余个数
     * @param <T>    泛型
     * @return 新数组
     */
    public static <T> T[] subArray(T[] arr, int start, int length) {
        if (isEmpty(arr) || start >= arr.length || length <= 0) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        int endIndex = (start + length) >= arr.length ? arr.length : start + length;
        return Arrays.copyOfRange(arr, start, endIndex);
    }

    /**
     * 截取数组，从开始位置到结束
     *
     * @param arr   被截取的数组
     * @param start 开始截取位置
     * @param <T>   泛型
     * @return 新数组
     */
    public static <T> T[] subArray(T[] arr, int start) {
        return subArray(arr, start, arr.length - start);
    }
    //------------------------------带泛型方法end

    //------------------------------部分常用带泛型方法转基本数据类型 start
    //#code

    /**
     * toStringArray[]
     *
     * @param arr
     * @return
     */
    public static String[] toStringArray(int[] arr) {
        if (isEmpty(arr)) {
            return new String[0];
        }
        List<String> list = new ArrayList<String>();
        for (int i : arr) {
            list.add(String.valueOf(i));
        }
        String[] str = new String[list.size()];
        return list.toArray(str);
    }

    public static String[] toStringArray(char[] arr) {
        if (isEmpty(arr)) {
            return new String[0];
        }
        List<String> list = new ArrayList<String>();
        for (char i : arr) {
            list.add(String.valueOf(i));
        }
        String[] str = new String[list.size()];
        return list.toArray(str);
    }

    public static String[] toStringArray(byte[] arr) {
        if (isEmpty(arr)) {
            return new String[0];
        }
        List<String> list = new ArrayList<String>();
        for (byte i : arr) {
            list.add(String.valueOf(i));
        }
        String[] str = new String[list.size()];
        return list.toArray(str);
    }

    public static String[] toStringArray(long[] arr) {
        if (isEmpty(arr)) {
            return new String[0];
        }
        List<String> list = new ArrayList<String>();
        for (long i : arr) {
            list.add(String.valueOf(i));
        }
        String[] str = new String[list.size()];
        return list.toArray(str);
    }

    public static String[] toStringArray(short[] arr) {
        if (isEmpty(arr)) {
            return new String[0];
        }
        List<String> list = new ArrayList<String>();
        for (short i : arr) {
            list.add(String.valueOf(i));
        }
        String[] str = new String[list.size()];
        return list.toArray(str);
    }

    public static String[] toStringArray(double[] arr) {
        if (isEmpty(arr)) {
            return new String[0];
        }
        List<String> list = new ArrayList<String>();
        for (double i : arr) {
            list.add(String.valueOf(i));
        }
        String[] str = new String[list.size()];
        return list.toArray(str);
    }

    public static String[] toStringArray(float[] arr) {
        if (isEmpty(arr)) {
            return new String[0];
        }
        List<String> list = new ArrayList<String>();
        for (float i : arr) {
            list.add(String.valueOf(i));
        }
        String[] str = new String[list.size()];
        return list.toArray(str);
    }

    public static String[] toStringArray(boolean[] arr) {
        if (isEmpty(arr)) {
            return new String[0];
        }
        List<String> list = new ArrayList<String>();
        for (boolean i : arr) {
            list.add(String.valueOf(i));
        }
        String[] str = new String[list.size()];
        return list.toArray(str);
    }

    /**
     * 基本数据类型数组toString
     *
     * @param arr 基本数据类型数组
     * @return toString以, 分割
     */
    public static String toString(int[] arr) {
        return toString(wrap(arr));
    }

    public static String toString(short[] arr) {
        return toString(wrap(arr));
    }

    public static String toString(byte[] arr) {
        return toString(wrap(arr));
    }

    public static String toString(long[] arr) {
        return toString(wrap(arr));
    }

    public static String toString(double[] arr) {
        return toString(wrap(arr));
    }

    public static String toString(float[] arr) {
        return toString(wrap(arr));
    }

    public static String toString(char[] arr) {
        return toString(wrap(arr));
    }

    public static String toString(boolean[] arr) {
        return toString(wrap(arr));
    }

    /**
     * 基本类型数组添加
     *
     * @param arr     基本类型数组
     * @param element 添加参数
     * @return 新数组
     */
    public static int[] add(int[] arr, int... element) {
        return insert(arr, arr.length, element);
    }

    public static short[] add(short[] arr, short... element) {
        return insert(arr, arr.length, element);
    }

    public static long[] add(long[] arr, long... element) {
        return insert(arr, arr.length, element);
    }

    public static byte[] add(byte[] arr, byte... element) {
        return insert(arr, arr.length, element);
    }

    public static char[] add(char[] arr, char... element) {
        return insert(arr, arr.length, element);
    }

    public static double[] add(double[] arr, double... element) {
        return insert(arr, arr.length, element);
    }

    public static float[] add(float[] arr, float... element) {
        return insert(arr, arr.length, element);
    }


    /**
     * 基本数据类型 判断是否包含一个元素
     *
     * @param arr 基本数据类型数组
     * @param i   被包含的元素
     * @return boolean
     */
    public static boolean contains(int[] arr, int i) {
        if (isEmpty(arr)) {
            return false;
        }
        for (int a : arr) {
            if (a == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(short[] arr, short i) {
        if (isEmpty(arr)) {
            return false;
        }
        for (short a : arr) {
            if (a == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(long[] arr, long i) {
        if (isEmpty(arr)) {
            return false;
        }
        for (long a : arr) {
            if (a == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(byte[] arr, byte i) {
        if (isEmpty(arr)) {
            return false;
        }
        for (byte a : arr) {
            if (a == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(char[] arr, char i) {
        if (isEmpty(arr)) {
            return false;
        }
        for (char a : arr) {
            if (a == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(double[] arr, double i) {
        if (isEmpty(arr)) {
            return false;
        }
        for (double a : arr) {
            if (a == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(float[] arr, float i) {
        if (isEmpty(arr)) {
            return false;
        }
        for (float a : arr) {
            if (a == i) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据数组进行判断是否元素存在，存在返回该值所在索引
     *
     * @param arr 数组
     * @param i   是否存在该值
     * @return
     */
    public static int indexOf(int[] arr, int i) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i1 = 0; i1 < arr.length; i1++) {
            if (arr[i1] == i) {
                return i1;
            }
        }
        return Constant.NEG_ONE;
    }

    public static int indexOf(short[] arr, short i) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i1 = 0; i1 < arr.length; i1++) {
            if (arr[i1] == i) {
                return i1;
            }
        }
        return Constant.NEG_ONE;
    }

    public static int indexOf(long[] arr, long i) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i1 = 0; i1 < arr.length; i1++) {
            if (arr[i1] == i) {
                return i1;
            }
        }
        return Constant.NEG_ONE;
    }

    public static int indexOf(char[] arr, char i) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i1 = 0; i1 < arr.length; i1++) {
            if (arr[i1] == i) {
                return i1;
            }
        }
        return Constant.NEG_ONE;
    }

    public static int indexOf(byte[] arr, byte i) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i1 = 0; i1 < arr.length; i1++) {
            if (arr[i1] == i) {
                return i1;
            }
        }
        return Constant.NEG_ONE;
    }

    public static int indexOf(double[] arr, double i) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i1 = 0; i1 < arr.length; i1++) {
            if (arr[i1] == i) {
                return i1;
            }
        }
        return Constant.NEG_ONE;
    }

    public static int indexOf(float[] arr, float i) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i1 = 0; i1 < arr.length; i1++) {
            if (arr[i1] == i) {
                return i1;
            }
        }
        return Constant.NEG_ONE;
    }

    /**
     * 获取最后一个出现的元素，若不存在返回-1
     *
     * @param arr   数组
     * @param param 元素
     * @return 返回索引或-1
     */
    public static int lastIndexOf(int[] arr, int param) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (param == arr[i]) {
                return i;
            }
        }
        return Constant.NEG_ONE;
    }

    public static int lastIndexOf(short[] arr, short param) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (param == arr[i]) {
                return i;
            }
        }
        return Constant.NEG_ONE;
    }

    public static int lastIndexOf(byte[] arr, byte param) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (param == arr[i]) {
                return i;
            }
        }
        return Constant.NEG_ONE;
    }

    public static int lastIndexOf(long[] arr, long param) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (param == arr[i]) {
                return i;
            }
        }
        return Constant.NEG_ONE;
    }

    public static int lastIndexOf(char[] arr, char param) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (param == arr[i]) {
                return i;
            }
        }
        return Constant.NEG_ONE;
    }

    public static int lastIndexOf(double[] arr, double param) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (param == arr[i]) {
                return i;
            }
        }
        return Constant.NEG_ONE;
    }

    public static int lastIndexOf(float[] arr, float param) {
        if (isEmpty(arr)) {
            return Constant.NEG_ONE;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (param == arr[i]) {
                return i;
            }
        }
        return Constant.NEG_ONE;
    }

    /**
     * 在数组指定长度位置插入元素
     *
     * @param arr     初始数组
     * @param index   指定长度位置
     * @param element 增加的元素
     * @return 新数组
     */
    public static int[] insert(int[] arr, int index, int... element) {
        if (isEmpty(arr)) {
            return element;
        }
        if (isEmpty(element)) {
            return arr;
        }
        int[] newArr = new int[arr.length + element.length];
        if (index <= 0) {
            // 在第一个数组前方添加第二个数组
            System.arraycopy(element, 0, newArr, 0, element.length);
            System.arraycopy(arr, 0, newArr, element.length, arr.length);
        } else if (index >= arr.length) {
            // 在第一个数组后追加第二个数组
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            System.arraycopy(element, 0, newArr, arr.length, element.length);
        } else {
            // 在第一个数组中间添加第二个数组
            System.arraycopy(arr, 0, newArr, 0, index);
            System.arraycopy(element, 0, newArr, index, element.length);
            System.arraycopy(arr, index, newArr, index + element.length, arr.length - index);
        }
        return newArr;
    }

    public static short[] insert(short[] arr, int index, short... element) {
        if (isEmpty(arr)) {
            return element;
        }
        if (isEmpty(element)) {
            return arr;
        }
        short[] newArr = new short[arr.length + element.length];
        if (index <= 0) {
            // 在第一个数组前方添加第二个数组
            System.arraycopy(element, 0, newArr, 0, element.length);
            System.arraycopy(arr, 0, newArr, element.length, arr.length);
        } else if (index >= arr.length) {
            // 在第一个数组后追加第二个数组
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            System.arraycopy(element, 0, newArr, arr.length, element.length);
        } else {
            // 在第一个数组中间添加第二个数组
            System.arraycopy(arr, 0, newArr, 0, index);
            System.arraycopy(element, 0, newArr, index, element.length);
            System.arraycopy(arr, index, newArr, index + element.length, arr.length - index);
        }
        return newArr;
    }

    public static byte[] insert(byte[] arr, int index, byte... element) {
        if (isEmpty(arr)) {
            return element;
        }
        if (isEmpty(element)) {
            return arr;
        }
        byte[] newArr = new byte[arr.length + element.length];
        if (index <= 0) {
            // 在第一个数组前方添加第二个数组
            System.arraycopy(element, 0, newArr, 0, element.length);
            System.arraycopy(arr, 0, newArr, element.length, arr.length);
        } else if (index >= arr.length) {
            // 在第一个数组后追加第二个数组
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            System.arraycopy(element, 0, newArr, arr.length, element.length);
        } else {
            // 在第一个数组中间添加第二个数组
            System.arraycopy(arr, 0, newArr, 0, index);
            System.arraycopy(element, 0, newArr, index, element.length);
            System.arraycopy(arr, index, newArr, index + element.length, arr.length - index);
        }
        return newArr;
    }

    public static long[] insert(long[] arr, int index, long... element) {
        if (isEmpty(arr)) {
            return element;
        }
        if (isEmpty(element)) {
            return arr;
        }
        long[] newArr = new long[arr.length + element.length];
        if (index <= 0) {
            // 在第一个数组前方添加第二个数组
            System.arraycopy(element, 0, newArr, 0, element.length);
            System.arraycopy(arr, 0, newArr, element.length, arr.length);
        } else if (index >= arr.length) {
            // 在第一个数组后追加第二个数组
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            System.arraycopy(element, 0, newArr, arr.length, element.length);
        } else {
            // 在第一个数组中间添加第二个数组
            System.arraycopy(arr, 0, newArr, 0, index);
            System.arraycopy(element, 0, newArr, index, element.length);
            System.arraycopy(arr, index, newArr, index + element.length, arr.length - index);
        }
        return newArr;
    }

    public static double[] insert(double[] arr, int index, double... element) {
        if (isEmpty(arr)) {
            return element;
        }
        if (isEmpty(element)) {
            return arr;
        }
        double[] newArr = new double[arr.length + element.length];
        if (index <= 0) {
            // 在第一个数组前方添加第二个数组
            System.arraycopy(element, 0, newArr, 0, element.length);
            System.arraycopy(arr, 0, newArr, element.length, arr.length);
        } else if (index >= arr.length) {
            // 在第一个数组后追加第二个数组
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            System.arraycopy(element, 0, newArr, arr.length, element.length);
        } else {
            // 在第一个数组中间添加第二个数组
            System.arraycopy(arr, 0, newArr, 0, index);
            System.arraycopy(element, 0, newArr, index, element.length);
            System.arraycopy(arr, index, newArr, index + element.length, arr.length - index);
        }
        return newArr;
    }

    public static float[] insert(float[] arr, int index, float... element) {
        if (isEmpty(arr)) {
            return element;
        }
        if (isEmpty(element)) {
            return arr;
        }
        float[] newArr = new float[arr.length + element.length];
        if (index <= 0) {
            // 在第一个数组前方添加第二个数组
            System.arraycopy(element, 0, newArr, 0, element.length);
            System.arraycopy(arr, 0, newArr, element.length, arr.length);
        } else if (index >= arr.length) {
            // 在第一个数组后追加第二个数组
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            System.arraycopy(element, 0, newArr, arr.length, element.length);
        } else {
            // 在第一个数组中间添加第二个数组
            System.arraycopy(arr, 0, newArr, 0, index);
            System.arraycopy(element, 0, newArr, index, element.length);
            System.arraycopy(arr, index, newArr, index + element.length, arr.length - index);
        }
        return newArr;
    }

    public static char[] insert(char[] arr, int index, char... element) {
        if (isEmpty(arr)) {
            return element;
        }
        if (isEmpty(element)) {
            return arr;
        }
        char[] newArr = new char[arr.length + element.length];
        if (index <= 0) {
            // 在第一个数组前方添加第二个数组
            System.arraycopy(element, 0, newArr, 0, element.length);
            System.arraycopy(arr, 0, newArr, element.length, arr.length);
        } else if (index >= arr.length) {
            // 在第一个数组后追加第二个数组
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            System.arraycopy(element, 0, newArr, arr.length, element.length);
        } else {
            // 在第一个数组中间添加第二个数组
            System.arraycopy(arr, 0, newArr, 0, index);
            System.arraycopy(element, 0, newArr, index, element.length);
            System.arraycopy(arr, index, newArr, index + element.length, arr.length - index);
        }
        return newArr;
    }

    /**
     * 截取数组
     *
     * @param arr    被截取的数组
     * @param start  开始截取的索引
     * @param length 截取个数，超过剩余个数，截取剩余个数
     * @return 新数组
     */
    public static int[] subArray(int[] arr, int start, int length) {
        if (isEmpty(arr) || start >= arr.length || length <= 0) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        int endIndex = (start + length) >= arr.length ? arr.length : start + length;
        return Arrays.copyOfRange(arr, start, endIndex);
    }

    public static short[] subArray(short[] arr, int start, int length) {
        if (isEmpty(arr) || start >= arr.length || length <= 0) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        int endIndex = (start + length) >= arr.length ? arr.length : start + length;
        return Arrays.copyOfRange(arr, start, endIndex);
    }

    public static long[] subArray(long[] arr, int start, int length) {
        if (isEmpty(arr) || start >= arr.length || length <= 0) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        int endIndex = (start + length) >= arr.length ? arr.length : start + length;
        return Arrays.copyOfRange(arr, start, endIndex);
    }

    public static byte[] subArray(byte[] arr, int start, int length) {
        if (isEmpty(arr) || start >= arr.length || length <= 0) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        int endIndex = (start + length) >= arr.length ? arr.length : start + length;
        return Arrays.copyOfRange(arr, start, endIndex);
    }

    public static char[] subArray(char[] arr, int start, int length) {
        if (isEmpty(arr) || start >= arr.length || length <= 0) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        int endIndex = (start + length) >= arr.length ? arr.length : start + length;
        return Arrays.copyOfRange(arr, start, endIndex);
    }

    public static double[] subArray(double[] arr, int start, int length) {
        if (isEmpty(arr) || start >= arr.length || length <= 0) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        int endIndex = (start + length) >= arr.length ? arr.length : start + length;
        return Arrays.copyOfRange(arr, start, endIndex);
    }

    public static float[] subArray(float[] arr, int start, int length) {
        if (isEmpty(arr) || start >= arr.length || length <= 0) {
            return null;
        }
        if (start < 0) {
            start = 0;
        }
        int endIndex = (start + length) >= arr.length ? arr.length : start + length;
        return Arrays.copyOfRange(arr, start, endIndex);
    }

    /**
     * 截取数组，从开始位置到结束
     *
     * @param arr   被截取的数组
     * @param start 开始截取位置
     * @return 新数组
     */
    public static int[] subArray(int[] arr, int start) {
        return subArray(arr, start, arr.length - start);
    }

    public static short[] subArray(short[] arr, int start) {
        return subArray(arr, start, arr.length - start);
    }

    public static long[] subArray(long[] arr, int start) {
        return subArray(arr, start, arr.length - start);
    }

    public static byte[] subArray(byte[] arr, int start) {
        return subArray(arr, start, arr.length - start);
    }

    public static char[] subArray(char[] arr, int start) {
        return subArray(arr, start, arr.length - start);
    }

    public static double[] subArray(double[] arr, int start) {
        return subArray(arr, start, arr.length - start);
    }

    public static float[] subArray(float[] arr, int start) {
        return subArray(arr, start, arr.length - start);
    }

    //------------------------------部分常用带泛型方法转基本数据类型 end

    //---------------以下wrap为装箱操作 基本数据类型[]->对象类型[]

    /**
     * 为兼容1.8以下 采用循环进行装箱
     * 1.8+可使用stream进行装箱操作
     *
     * @param arr
     * @return
     */
    public static Integer[] wrap(int[] arr) {
        if (isEmpty(arr)) {
            return new Integer[0];
        }
        Integer[] integers = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integers[i] = arr[i];
        }
        return integers;
    }

    public static Short[] wrap(short[] arr) {
        if (isEmpty(arr)) {
            return new Short[0];
        }
        Short[] shorts = new Short[arr.length];
        for (int i = 0; i < arr.length; i++) {
            shorts[i] = arr[i];
        }
        return shorts;
    }

    public static Long[] wrap(long[] arr) {
        if (isEmpty(arr)) {
            return new Long[0];
        }
        Long[] longs = new Long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            longs[i] = arr[i];
        }
        return longs;
    }

    public static Byte[] wrap(byte[] arr) {
        if (isEmpty(arr)) {
            return new Byte[0];
        }
        Byte[] bytes = new Byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            bytes[i] = arr[i];
        }
        return bytes;
    }

    public static Double[] wrap(double[] arr) {
        if (isEmpty(arr)) {
            return new Double[0];
        }
        Double[] doubles = new Double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            doubles[i] = arr[i];
        }
        return doubles;
    }

    public static Float[] wrap(float[] arr) {
        if (isEmpty(arr)) {
            return new Float[0];
        }
        Float[] floats = new Float[arr.length];
        for (int i = 0; i < arr.length; i++) {
            floats[i] = arr[i];
        }
        return floats;
    }

    public static Character[] wrap(char[] arr) {
        if (isEmpty(arr)) {
            return new Character[0];
        }
        Character[] chars = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) {
            chars[i] = arr[i];
        }
        return chars;
    }

    public static Boolean[] wrap(boolean[] arr) {
        if (isEmpty(arr)) {
            return new Boolean[0];
        }
        Boolean[] booleans = new Boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            booleans[i] = arr[i];
        }
        return booleans;
    }

    //-----------------拆箱操作unWrap 对象类型[]->基本数据类型[]

    /**
     * jdk1.8+使用Steam进行装拆箱 为向下兼容全部使用循环
     *
     * @param arr
     * @return
     */
    public static int[] unWrap(Integer[] arr) {
        if (isEmpty(arr)) {
            return new int[0];
        }
        int[] ints = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ints[i] = arr[i];
        }
        return ints;
        //jdk1.8+使用Steam进行装拆箱
        //return Arrays.stream(arr).mapToInt(Integer::valueOf).toArray();
    }

    public static short[] unWrap(Short[] arr) {
        if (isEmpty(arr)) {
            return new short[0];
        }
        short[] shorts = new short[arr.length];
        for (int i = 0; i < arr.length; i++) {
            shorts[i] = arr[i];
        }
        return shorts;
    }

    public static long[] unWrap(Long[] arr) {
        if (isEmpty(arr)) {
            return new long[0];
        }
        long[] longs = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            longs[i] = arr[i];
        }
        return longs;
    }

    public static byte[] unWrap(Byte[] arr) {
        if (isEmpty(arr)) {
            return new byte[0];
        }
        byte[] bytes = new byte[arr.length];
        for (int i = 0; i < arr.length; i++) {
            bytes[i] = arr[i];
        }
        return bytes;
    }

    public static double[] unWrap(Double[] arr) {
        if (isEmpty(arr)) {
            return new double[0];
        }
        double[] doubles = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            doubles[i] = arr[i];
        }
        return doubles;
    }

    public static float[] unWrap(Float[] arr) {
        if (isEmpty(arr)) {
            return new float[0];
        }
        float[] floats = new float[arr.length];
        for (int i = 0; i < arr.length; i++) {
            floats[i] = arr[i];
        }
        return floats;
    }

    public static char[] unWrap(Character[] arr) {
        if (isEmpty(arr)) {
            return new char[0];
        }
        char[] chars = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            chars[i] = arr[i];
        }
        return chars;
    }

    public static boolean[] unWrap(Boolean[] arr) {
        if (isEmpty(arr)) {
            return new boolean[0];
        }
        boolean[] booleans = new boolean[arr.length];
        for (int i = 0; i < arr.length; i++) {
            booleans[i] = arr[i];
        }
        return booleans;
    }
}
