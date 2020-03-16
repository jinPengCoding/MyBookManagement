package com.liuwen.entity;

/**
 * @author: Liu Wen
 * @create: 2020-02-18 16:19
 * @description:                 对应书的类型
 * 对应于外表BookCase
 **/
public class BookCase {
    private Integer id;
    private String name;

    public BookCase(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
