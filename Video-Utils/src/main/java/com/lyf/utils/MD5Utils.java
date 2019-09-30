package com.lyf.utils;

import org.springframework.util.DigestUtils;

/**
 * @author 喜闻乐见i
 */
public class MD5Utils {

    /*
        MD5加密算法：是一种非常普遍，不可逆的算法，安全性非常高
        1、如果项目中使用了Spring框架，可以直接使用spring自带的工具类
        2、也可以去下载MD5加密的jar包
        3、如果觉得jar包太大了，可以直接复制一个md5源码
     */

    /**
     * 通过 MD5 给密码加密
     *
     * @param mingWen 明文
     * @return 密文
     */
    public static String getMd5Str(String mingWen) {
        String firstMi = DigestUtils.md5DigestAsHex(mingWen.getBytes());
        String jieStr = firstMi.substring(2, 12);
        String salt = "lyf";
        String newStr = firstMi + jieStr + salt;
        return DigestUtils.md5DigestAsHex(newStr.getBytes());
    }
}
