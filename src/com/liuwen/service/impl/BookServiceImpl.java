package com.liuwen.service.impl;

import com.liuwen.entity.Book;
import com.liuwen.repository.BookRepository;
import com.liuwen.repository.impl.BookRepositoryImpl;
import com.liuwen.service.BookService;

import java.util.List;

/**
 * @author: Liu Wen
 * @create: 2020-02-18 16:28
 * @description: Good good study,day day up!
 **/
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository = new BookRepositoryImpl();
    private final int LIMIT = 10;  //每页十个数据

    /**
     * @Description: 由传参 page  实现分页（每页LIMIT=10条记录）
     *          page：第一页      0   到  9
     *                第二页     10   到 19
     *                第三页     20   到 29
     *              第page页  （page-1）*LIMIT  到 page-1）*LIMIT +9
      * @param page
     * @return java.util.List<com.liuwen.entity.Book>
     * @date 20.2.18 18:09
     */
    @Override
    public List<Book> findAll(int page) {   // page转化为index和LIMIT传入到数据访问层
        int index = (page-1)*LIMIT;
        return bookRepository.findAll(index,LIMIT);
    }

    /**
     * @Description:  获取总页数
      * @param
     * @return int
     * @date 20.2.18 18:37
     */
    @Override
    public int getPages() {
        int count = bookRepository.count();
        int page = 0;
        if(count % LIMIT == 0){
            page = count/LIMIT;
        }else{
            page = count/LIMIT+1;
        }
        return page;
    }
}
