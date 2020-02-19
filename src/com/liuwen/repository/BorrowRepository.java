package com.liuwen.repository;

import com.liuwen.entity.Borrow;

import java.util.List;

/**
 * @Description:   借书业务的数据访问层
  * @param null
 * @return
 * @date 20.2.19 13:54
 */
public interface BorrowRepository {
    public void addBorrow(Integer bookid,Integer readerid,String borrowtime,String returntime,Integer adminid,Integer state);
    public List<Borrow> findAllBorrowByReaderId(Integer readerid, Integer index, Integer limit);
    public int count(Integer readerid);
    public List<Borrow> findAllBorrow(Integer state,Integer index,Integer LIMIT);
    public int countByState(Integer state);
    public List<Borrow> findAllBorrowByState(Integer state,Integer index,Integer limit);
    public void handle(Integer borrowId,Integer state,Integer adminId);

}
