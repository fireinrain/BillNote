package com.lzy.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/24.
 * 消费记录实体类
 */

public class Record {
    public int id;
    public int spend;
    public int cid;
    public String comment;
    public Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpend() {
        return spend;
    }

    public void setSpend(int spend) {
        this.spend = spend;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", spend=" + spend +
                ", cid=" + cid +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
