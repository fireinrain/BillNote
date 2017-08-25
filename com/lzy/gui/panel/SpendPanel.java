package com.lzy.gui.panel;

import com.lzy.gui.page.SpendPage;
import com.lzy.gui.util.CircleProgressBar;
import com.lzy.gui.util.ColorUtil;
import com.lzy.gui.util.GUIUtil;
import com.lzy.service.SpendService;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2017/8/21.
 */
public class SpendPanel extends AbstractWorkingPanel{

    //单例
    public static SpendPanel instance = new SpendPanel();

    public JLabel lMonthSpend = new JLabel("本月消费");
    public JLabel lTodaySpend = new JLabel("今日消费");
    public JLabel lAvgSpendPerDay = new JLabel("日均消费");
    public JLabel lMonthAvailable = new JLabel("本月剩余");
    public JLabel lDayAvgAvailable = new JLabel("日均可用");
    public JLabel lMonthLeftDay = new JLabel("距离月末");

    public JLabel vMonthSpend = new JLabel("￥2300");
    public JLabel vTodaySpend = new JLabel("￥25");
    public JLabel vAvgSpendPerDay = new JLabel("￥120");
    public JLabel vMonthAvailable = new JLabel("￥2084");
    public JLabel vDayAvgAvailable = new JLabel("￥389");
    public JLabel vMonthLeftDay = new JLabel("15天");


    //环形进度条
    public CircleProgressBar circleProgressBar;

    //构造器私有，防止在外调用new实例
    private SpendPanel(){
        //设置布局为边界布局
        this.setLayout(new BorderLayout());
        this.circleProgressBar = new CircleProgressBar();
        this.circleProgressBar.setBackgroundColor(ColorUtil.blueColor);

        //设置所有组件的前景色
        GUIUtil.setColor(ColorUtil.grayColor,lAvgSpendPerDay,lDayAvgAvailable,
                lMonthAvailable,lMonthLeftDay,lMonthSpend,lTodaySpend,vAvgSpendPerDay,vDayAvgAvailable,vMonthAvailable,vMonthLeftDay);
        GUIUtil.setColor(ColorUtil.blueColor,vMonthSpend,vTodaySpend);
        //设置组件的文字字体
        vMonthSpend.setFont(new Font("微软雅黑",Font.BOLD,23));
        vTodaySpend.setFont(new Font("微软雅黑",Font.BOLD,23));

        //添加组件到父容器
        this.add(this.center(),BorderLayout.CENTER);
        this.add(this.south(),BorderLayout.SOUTH);
    }


    /*
    以下几个是布局的方法
    现将组件在小范围内布局，然后在添加入父容器
     */
    private JPanel center(){
        //上布局
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(this.west(),BorderLayout.WEST);
        p.add(this.center2(),BorderLayout.CENTER);
        return p;
    }

    private Component center2(){
        return this.circleProgressBar;
    }

    //左布局
    private Component west(){
        JPanel p = new JPanel();
        //进行网格布局
        p.setLayout(new GridLayout(4,1));
        p.add(this.lMonthSpend);
        p.add(this.vMonthSpend);

        p.add(this.lTodaySpend);
        p.add(this.vTodaySpend);
        return p;
    }

    //下布局
    private JPanel south(){
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,4));

        //栏目
        p.add(this.lAvgSpendPerDay);
        p.add(this.lMonthAvailable);
        p.add(this.lDayAvgAvailable);
        p.add(this.lMonthLeftDay);
        //栏目的值
        p.add(this.vAvgSpendPerDay);
        p.add(this.vMonthAvailable);
        p.add(this.vDayAvgAvailable);
        p.add(this.vMonthLeftDay);

        return p;

    }

    public static void main(String[] args){
        GUIUtil.showPanel(SpendPanel.instance);
    }

    @Override
    public void updateData() {
        SpendPage spendPage = new SpendService().getSpendPage();
        vMonthSpend.setText(spendPage.monthSpend);
        vMonthSpend.setText(spendPage.monthSpend);
        vTodaySpend.setText(spendPage.todaySpend);
        vAvgSpendPerDay.setText(spendPage.avgSpendPerDay);
        vMonthAvailable.setText(spendPage.monthAvailable);
        vDayAvgAvailable.setText(spendPage.dayAvgAvailable);
        vMonthLeftDay.setText(spendPage.monthLeftDay);

        circleProgressBar.setProgress(spendPage.usePercentage);

        //如果超支
        if (spendPage.isOverSpend){
            vMonthAvailable.setForeground(ColorUtil.warningColor);
            vMonthSpend.setForeground(ColorUtil.warningColor);
            vTodaySpend.setForeground(ColorUtil.warningColor);

        }else {
            vMonthAvailable.setForeground(ColorUtil.grayColor);
            vMonthSpend.setForeground(ColorUtil.blueColor);
            vTodaySpend.setForeground(ColorUtil.blueColor);
        }
        circleProgressBar.setForegroundColor(ColorUtil.getByPercentage(spendPage.usePercentage));
        addListener();
    }

    @Override
    public void addListener() {

    }
}
