package com.lyf.mapper;

import com.lyf.entity.Admin;

/**
 * @author 喜闻乐见i
 */
public interface AdminMapper {
    /**
     * 根据账号密码查询有几条记录
     * @param admin
     * @return
     */
    int selectAdminByUserNameAndPassword(Admin admin);
}
