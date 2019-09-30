package com.lyf.service;

/**
 * @author 喜闻乐见i
 */
public interface AdminService {

    /**
     * 验证登录
     * @param username String类型 用户名
     * @param password String类型 密码
     * @return 成功返回true，失败返回false
     */
    boolean login(String username, String password);
}
