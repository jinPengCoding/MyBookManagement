package com.liuwen.service;

import com.liuwen.entity.Reader;

public interface LoginService {
    /**
     * @Description:
      * @param username
     * @param password
     * @param type
     * @return java.lang.Object   返回一个Object类，多态的使用。（admin/reader）
     * @date 20.2.17 22:56
     */
    public Object login(String username,String password,String type);
}
