package com.lyf.utils;

import java.util.Properties;

/**
 * 用来读取 info.properties 文件
 *
 * @author 喜闻乐见i
 */
public class InfoUtils {

    static Properties properties = null;

    static {
        try {
            properties = new Properties();
            properties.load(InfoUtils.class.getClassLoader().getResourceAsStream("info.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String name) {
        return properties.getProperty(name);
    }
}
