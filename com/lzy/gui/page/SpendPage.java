package com.lzy.gui.page;

/**
 * Created by Administrator on 2017/8/25.
 *
 * 封装消费一览所需要的数据
 */
public class SpendPage {
    //本月消费
    public String monthSpend;
    //今日消费
    public String todaySpend;
    //日均消费
    public String avgSpendPerDay;
    //本月剩余
    public String monthAvailable;
    //日均可用
    public String dayAvgAvailable;
    //距离月末
    public String monthLeftDay;
    //使用比例
    public  int usePercentage;
    //是否超支
    public  boolean isOverSpend=false;

    //无参构造方法
    public SpendPage(int monthSpend, int todaySpend, int avgSpendPerDay,
                     int monthAvailable, int dayAvgAvailable, int monthLeftDay, int usePercentage) {
        this.monthSpend = "￥"+monthSpend;
        this.todaySpend = "￥"+todaySpend;
        this.avgSpendPerDay = "￥"+avgSpendPerDay;
        if (monthAvailable<0){
            isOverSpend=true;
        }
        if (!isOverSpend){
            this.monthAvailable ="￥" +monthAvailable;
            this.dayAvgAvailable = "￥" +dayAvgAvailable;
        }else {
            this.monthAvailable ="超出" +(0-monthAvailable);
            this.dayAvgAvailable = "￥0" ;
        }


        this.monthLeftDay = monthLeftDay+"天";
        this.usePercentage = usePercentage;
    }
}
