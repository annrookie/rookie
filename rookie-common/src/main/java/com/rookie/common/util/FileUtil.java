package com.rookie.common.util;

import com.rookie.common.exception.UtilException;

import java.io.File;

/**
 * @author This
 * @version 1.0
 * @date 2019/4/29 9:43
 */
public class FileUtil {
    /**
     * 创建File对象
     * @param path 对象路径
     * @return File
     */
    public static File newFile(String path) {
        if (StrUtil.isEmpty(path) || StrUtil.isBlank(path)){
            throw new UtilException("路径不能为空");
        }
        return new File(path);
    }
}
