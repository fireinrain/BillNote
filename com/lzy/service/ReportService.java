package com.lzy.service;

import com.lzy.dao.RecordDao;
import com.lzy.entity.Record;
import utils.DateUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */
public class ReportService {

    public int getDaySpend(Date date, List<Record>monthRawData){
        /**
        * @Description:获取
        * TODO
        * @param:[date, monthRawData]
        * @return:int
        * @date:2017/8/25-21:09
        */
        int daySpend = 0;
        for (Record r:monthRawData
             ) {
            if (r.getDate().equals(date))
                daySpend+=r.getSpend();
        }
        return daySpend;
    }

    public List<Record> listThisMonthRecords(){
        /**
        * @Description:获取一个月的消费记录集合
        * TODO
        * @param:[]
        * @return:java.util.List<com.lzy.entity.Record>
        * @date:2017/8/25-21:19
        */
        RecordDao recordDao = new RecordDao();
        //获得这个月的所有消费记录
        List<Record> monthRawData = recordDao.listThisMonth();
        //一个包含每天消费总数的集合
        List<Record> result = new ArrayList <>();

        //获取这个月的起始时间
        Date monthBegin = DateUtil.monthBegin();
        //获取这个有的总天数
        int monthTotalDay = DateUtil.thisMonthTotalDay();
        //获取一个日历对象
        Calendar c = Calendar.getInstance();
        /*
        遍历这个月的所有日期 ，将每个日期的消费记录，都计算出来，
        放入到新定义的result集合中
         */
        for (int i = 0; i <monthTotalDay ; i++) {
            Record r = new Record();
            c.setTime(monthBegin);
            c.add(Calendar.DATE,i);
            Date eachDayOfThisMonth = c.getTime();
            int daySpend = getDaySpend(eachDayOfThisMonth,monthRawData);
            //if (daySpend==0){
            //    continue;
            //}
            r.spend = daySpend;
            result.add(r);
        }
        //返回的包含每一天消费金额总数的消费记录
        return result;
    }
}
