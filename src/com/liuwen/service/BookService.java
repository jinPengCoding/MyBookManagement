package com.liuwen.service;

import com.liuwen.entity.Book;
import com.liuwen.entity.Borrow;

import java.util.List;

public interface BookService {
    public List<Book> findAll(int page);
    public int getPages();
    public void addBorrow(Integer bookid,Integer readerid);
    public List<Borrow> findAllBorrowByReaderId(Integer readerid, Integer page);
    public int getBorrowPages(Integer readerid);
    public  List<Borrow> findAllBorrow(Integer state,Integer page);
    public int getBorrowPagesByState(Integer state);
    public List<Borrow> findAllBorrowByState(Integer state,Integer page);
    public void handleBorrow(Integer borrowId,Integer state,Integer adminId);
}
