package com.liuwen.service.impl;

import com.liuwen.repository.AdminRepository;
import com.liuwen.repository.ReaderRepository;
import com.liuwen.repository.impl.AdminRepositoryImpl;
import com.liuwen.repository.impl.ReaderRepositoryImpl;
import com.liuwen.service.LoginService;

/**
 * @author: Liu Wen
 * @create: 2020-02-17 22:52
 * @description: Good good study,day day up!
 **/
public class LoginServiceImpl implements LoginService {
    //多态
    private ReaderRepository readerRepository = new ReaderRepositoryImpl();
    private AdminRepository adminRepository = new AdminRepositoryImpl();
    @Override
    public Object login(String username, String password, String type) {
        Object object = null;
        switch (type){
             case "reader":
                 object = readerRepository.login(username,password);
             break;
             case "admin":
                 object = adminRepository.login(username,password);
             break;
        }

        return object;
    }
}
