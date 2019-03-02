package com.welljoint.service;

/**
 * @author hbd(modify)
 * Serivice接口
 */
public interface LoginService {
    /**
     * 登录信息的校验
     * @param userName
     * @param password
     * @return
     */
    public int login(String userName, String password);
}
