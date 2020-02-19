package com.liuwen.service.impl;

import com.liuwen.entity.Book;
import com.liuwen.entity.Borrow;
import com.liuwen.repository.BookRepository;
import com.liuwen.repository.BorrowRepository;
import com.liuwen.repository.impl.BorrowRepositoryImpl;
import com.liuwen.repository.impl.BookRepositoryImpl;
import com.liuwen.service.BookService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: Liu Wen
 * @create: 2020-02-18 16:28
 * @description: Good good study,day day up!
 **/
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository = new BookRepositoryImpl();
    private BorrowRepository borrowRepository = new BorrowRepositoryImpl();
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

    /**
     * @Description: 图书借阅功能  （往borrow表中添加数据的过程）
      * @param bookid
 * @param readerid
     * @return void
     * @date 20.2.19 13:49
     */
    @Override
    public void addBorrow(Integer bookid, Integer readerid) {
        //借书时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String borrowTime = simpleDateFormat.format(date);
        //还书时间，借书时间+14天
        Calendar calendar = Calendar.getInstance();
        int dates = calendar.get(Calendar.DAY_OF_YEAR) + 14;
        calendar.set(Calendar.DAY_OF_YEAR, dates);
        Date date2 = calendar.getTime();
        String returnTime = simpleDateFormat.format(date2);
        borrowRepository.addBorrow(bookid,readerid,borrowTime,returnTime,null,0);
    }
    /**
     * @Description:  图书借阅显示
      * @param readerid
 * @param page
     * @return java.util.List<com.liuwen.entity.Borrow>
     * @date 20.2.19 14:35
     */
    @Override
    public List<Borrow> findAllBorrowByReaderId(Integer readerid, Integer page) {
        //业务：将 page 换算成 index,limit
        int index = (page-1)*LIMIT;
        return borrowRepository.findAllBorrowByReaderId(readerid,index,LIMIT);
    }

    /**
     * @Description:   获取借阅总页数
      * @param readerid
     * @return int
     * @date 20.2.19 14:35
     */
    @Override
    public int getBorrowPages(Integer readerid) {
        int count = borrowRepository.count(readerid);
        int page = 0;
        if(count % LIMIT == 0){
            page = count/LIMIT;
        }else{
            page = count/LIMIT+1;
        }
        return page;
    }

    @Override
    public List<Borrow> findAllBorrow(Integer state, Integer page) {
        int index = (page-1)*LIMIT;
        return borrowRepository.findAllBorrow(state,index,LIMIT);
    }

    @Override
    public int getBorrowPagesByState(Integer state) {
        int count = borrowRepository.countByState(state);
        int page = 0;
        if(count % LIMIT == 0){
            page = count/LIMIT;
        }else{
            page = count/LIMIT+1;
        }
        return page;
    }

    @Override
    public List<Borrow> findAllBorrowByState(Integer state, Integer page) {
        int index = (page-1)*LIMIT;
        return borrowRepository.findAllBorrowByState(state,index,LIMIT);
    }

    @Override
    public void handleBorrow(Integer borrowId, Integer state, Integer adminId) {
        borrowRepository.handle(borrowId,state,adminId);
    }
}
