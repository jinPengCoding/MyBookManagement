package com.liuwen.service;

import com.liuwen.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAll(int page);
    public int getPages();
    public void addBorrow(Integer bookid,Integer readerid);
}
