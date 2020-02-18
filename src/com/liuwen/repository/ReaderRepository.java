package com.liuwen.repository;

import com.liuwen.entity.Reader;

/**
 * @author: Liu Wen
 * @create: 2020-02-18 13:14
 * @description: Good good study,day day up!
 **/
public interface ReaderRepository {

    public Reader login(String username,String password);

}
