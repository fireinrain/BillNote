package com.lzy.service;

import com.lzy.dao.RecordDao;
import com.lzy.entity.Record;
import com.lzy.gui.page.SpendPage;
import utils.DateUtil;

import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 *
 * 消费一览的服务类
 * 消费一览的数据从这里加工出来
 */
public class SpendService {

    public SpendPage getSpendPage(){
        RecordDao recordDao = new RecordDao();
        //本月数据
        List<Record> thisMonthRecords = recordDao.listThisMonth();
        //今日数据
        List<Record> todayRecords = recordDao.listToday();
        //本月总天数
        int thisMonthTotalDay = DateUtil.thisMonthTotalDay();

        //变量
        int monthSpend=0;
        //今日消费
        int todaySpend=0;
        //日均消费
        int avgSpendPerDay=0;
        //本月剩余
        int monthAvailable=0;
        //日均可用
        int dayAvgAvailable=0;
        //距离月末
        int monthLeftDay=0;
        //使用比例
        int usePercentage=0;

        //预算
        int monthBudget = new ConfigService().getIntBudget();

        //统计本月消费
        for (Record r:thisMonthRecords
             ) {
            monthSpend+=r.getSpend();
        }

        //统计今日消费
        for (Record r:todayRecords
             ) {
            todaySpend+=r.getSpend();
        }

        //计算日均消费
        avgSpendPerDay = monthSpend/thisMonthTotalDay;

        //计算本月剩余
        monthAvailable = monthBudget-monthSpend;

        //距离月末
        monthLeftDay = DateUtil.thisMonthLeftDay();

        //计算日均可用
        avgSpendPerDay = monthAvailable/monthLeftDay;

        //计算使用比例
        usePercentage = monthSpend*100/monthBudget;

        //根据计算结果 生成spendpage对象
        return new SpendPage(
                monthSpend,todaySpend,avgSpendPerDay,
                monthAvailable,dayAvgAvailable,monthLeftDay,
                usePercentage
        );
    }

}
