package com.lzy.service;

import com.lzy.dao.RecordDao;
import com.lzy.entity.Category;
import com.lzy.entity.Record;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/25.
 */
public class RecordService {
    public RecordDao recordDao = new RecordDao();
    public void add(int spend, Category c, String comment, Date date){
        Record r= new Record();
        r.spend = spend;
        r.cid = c.id;
        r.comment = comment;
        r.date = date;

        recordDao.add(r);
    }
}
