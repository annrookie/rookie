package com.rookie.common.resource;

import com.sun.xml.internal.ws.util.UtilException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 加载区域行政编码
 *
 * @author This
 * @version 1.0
 * @date 2019/4/18 11:10
 */
public class AreaCode {
    public static Properties pro;

    static {
        //加载区域代码配置文件
        InputStream is = AreaCode.class.getClassLoader().getResourceAsStream("areaCode.properties");
        pro = new Properties();
        try {
            pro.load(is);
        } catch (IOException e) {
            throw new UtilException("区域代码文件加载失败");
        }
    }
}
