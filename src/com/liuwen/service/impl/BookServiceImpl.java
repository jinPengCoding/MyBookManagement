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

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
