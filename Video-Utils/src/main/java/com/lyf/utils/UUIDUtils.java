package com.lyf.utils;

import java.util.UUID;

/**
 * @author 喜闻乐见i
 */
public class UUIDUtils {
    public static String getUUID() {
        String str = UUID.randomUUID().toString().replace("-", "");
        return str;
    }
}
