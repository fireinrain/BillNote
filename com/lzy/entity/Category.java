package com.lzy.entity;

/**
 * Created by Administrator on 2017/8/24.
 * 消费分类实体类
 */
public class Category {
    public int id;
    public String name;

    //查询出来的
    public int recordNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
