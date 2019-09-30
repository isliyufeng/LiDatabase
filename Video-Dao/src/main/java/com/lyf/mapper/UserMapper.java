package com.lyf.mapper;

import com.lyf.entity.User;

/**
 * @author 喜闻乐见i
 */
public interface UserMapper {
    /**
     * 验证登录
     *
     * @param user User类型
     * @return 返回查询到的数据数量
     */
    int verifyLogin(User user);

    /**
     * 邮箱验证是否重复
     *
     * @param email String类型 邮箱
     * @return 返回查询到的数据数量
     */
    int validateEmail(String email);

    /**
     * 注册或添加用户
     *
     * @param user User类型
     * @return 返回添加数量
     */
    int insertUser(User user);

    /**
     * 查询对应User数据，并进入个人中心
     *
     * @param userAccount String类型的账户（邮箱）
     * @return 返回查询到的User数据
     */
    User getUserByEmail(String userAccount);

    /**
     * 修改User信息
     *
     * @param user User类型的数据
     */
    void updateUser(User user);

    /**
     * 修改User图片
     *
     * @param user User类型的数据
     */
    void updateUserImgUrl(User user);
}
