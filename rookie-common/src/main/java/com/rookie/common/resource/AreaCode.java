package com.rookie.common.resource;

import com.rookie.common.exception.UtilException;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 加载区域行政编码
 *
 * @author This
 * @version 1.0
 * @date 2019/4/18 11:10
 */
public class AreaCode {
    public static Properties pro;
    public static Set<Object> areaCode;

    static {
        //加载区域代码配置文件
        InputStream is = AreaCode.class.getClassLoader().getResourceAsStream("areaCode.properties");
        pro = new Properties();
        try {
            pro.load(is);
            areaCode = pro.keySet();
        } catch (IOException e) {
            throw new UtilException("区域代码文件加载失败");
        }
    }

    /**
     * 获取所有省份，行政代码为key，省份名称为val
     *
     * @return 省份map
     */
    public static Map<String, String> getProvince() {
        Map<String, String> provinceMap = new HashMap<String, String>();
        for (Object o : areaCode) {
            String s = o.toString();

            if (s.endsWith("0000") && !"830000".equals(s)) {
                provinceMap.put(s, pro.getProperty(s));
            }
        }
        return provinceMap;
    }

    /**
     * 获取省市区域信息
     *
     * @return 省市List
     */
    public static List<Map<String, Object>> getCity() {
        List<Map<String, Object>> list = new ArrayList<>();
        //获取所有省份map
        Map<String, String> province = getProvince();
        //省份的key
        Set<String> code = province.keySet();
        //声明一个map用来存储省市
        Map<String, Object> map;
        //声明一个List，用来存放市的Map
        List<Map<String, Object>> cityList;
        //市
        Map<String, Object> cityMap;
        for (String s : code) {
            map = new HashMap<>(34);
            cityList = new ArrayList<>();
            map.put("code", s);
            map.put("name", province.get(s));
            if ("110000".equals(s) || "120000".equals(s) || "500000".equals(s) || "310000".equals(s)) {
                cityMap = new HashMap<>();
                cityMap.put("code", s);
                cityMap.put("name", pro.getProperty(s));
                cityMap.put("pcode", s);
                cityList.add(cityMap);
            } else {
                for (Object o : areaCode) {
                    String codes = o.toString();
                    if (codes.startsWith(s.substring(0, 2)) && codes.endsWith("00") && !s.equals(codes) && !pro.getProperty(codes).contains("直辖")) {
                        cityMap = new HashMap<>();
                        cityMap.put("code", codes);
                        cityMap.put("name", pro.getProperty(codes));
                        cityMap.put("pcode", s);
                        cityList.add(cityMap);
                    }
                }
            }

            map.put("city", cityList);
            list.add(map);
        }
        return list;
    }

    /**
     * 获取省市县区域信息
     * @return 省市县区域信息
     */
    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> getArea() {
        List<Map<String, Object>> provinces = getCity();

        // 遍历省市list
        for (Map<String, Object> map : provinces) {
            List citys = (List) map.get("city");
            //声明一个List，用来存放县市的Map
            List<Map<String, Object>> countryList;
            //县市
            Map<String, Object> countryMap;
            if (citys != null && citys.size() > 0) {
                for (Object o : citys) {
                    Map<String, Object> city = (Map<String, Object>) o;
                    countryList = new ArrayList<>();
                    String cityCode = (String) city.get("code");
                    for (Object code : areaCode) {
                        String s = code.toString();
                        if (s.startsWith(cityCode.substring(0, 4)) && !cityCode.equals(s) && !s.endsWith("01") &&!"330719".equals(s)) {
                            countryMap = new HashMap<>();
                            countryMap.put("code", s);
                            countryMap.put("name", pro.getProperty(s));
                            countryMap.put("pcode", cityCode);
                            countryList.add(countryMap);
                        }
                    }
                    ((Map<String, Object>) o).put("country", countryList);
                }
            }
        }
        return provinces;
    }
}
