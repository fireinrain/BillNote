package com.lzy.gui.panel;

import com.lzy.gui.listener.ConfigListener;
import com.lzy.gui.util.ColorUtil;
import com.lzy.gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2017/8/24.
 */
public class ConfigPanel extends JPanel{
    static {
        GUIUtil.useLiquidSkin();

    }

    public static ConfigPanel instance = new ConfigPanel();

    JLabel lBudget = new JLabel("本月预算￥");
    public JTextField textFieldBudget = new JTextField("0");

    JLabel lMysql = new JLabel("Mysql安装目录");
    public JTextField textFieldMysql = new JTextField("");

    JButton bSubmit = new JButton("更新");

    //无参构造函数
    public ConfigPanel(){
        GUIUtil.setColor(ColorUtil.grayColor,lBudget,lMysql);
        GUIUtil.setColor(ColorUtil.blueColor,bSubmit);

        //用JPAnel把组件包起来
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;
        //4行一列布局
        pInput.setLayout(new GridLayout(4,1,gap,gap));

        pInput.add(lBudget);
        pInput.add(textFieldBudget);
        pInput.add(lMysql);
        pInput.add(textFieldMysql);
        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);

        pSubmit.add(bSubmit);
        this.add(pSubmit,BorderLayout.CENTER);

        //添加事件监听器
        this.addListener();



    }

    //时间监听器
    public void addListener(){
        ConfigListener configListener = new ConfigListener();
        bSubmit.addActionListener(configListener);
    }

    //测试
    public static void main(String[] args){
        GUIUtil.showPanel(ConfigPanel.instance);
    }

}
