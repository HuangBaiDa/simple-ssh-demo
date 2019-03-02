package com.welljoint.dao;

import com.welljoint.entity.User;

/**
 * @author hbd(modify)
 * Dao接口
 */
public interface UserDao {
    /**
     * 根据用户名和密码查询用户
     *
     * @param userName
     * @param password
     * @return
     */
    public User find(String userName, String password);
}
