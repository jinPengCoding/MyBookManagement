package com.liuwen.service.impl;

import com.liuwen.entity.Reader;
import com.liuwen.service.LoginService;

/**
 * @author: Liu Wen
 * @create: 2020-02-17 22:52
 * @description: Good good study,day day up!
 **/
public class LoginServiceImpl implements LoginService {


    @Override
    public Object login(String username, String password, String type) {
        Object object = null;
        switch (type){
             case "Reader":

             break;
             case "Admin":

             break;
        }


        return object;
    }
}
