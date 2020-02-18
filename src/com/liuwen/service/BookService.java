package com.liuwen.service;

import com.liuwen.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAll(int page);
    public int getPages();
}
