package com.lzy.gui.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillNoteMain {

    public static void main(String[] args) {
	// write your code here
        JFrame frame = new JFrame();
        //设置界面大小
        frame.setSize(500,450);
        //设置标题
        frame.setTitle("简单记账本");
        //设置窗口相对于指定组件的位置。
        //如果组件当前未显示或者 c 为 null，
        // 则此窗口将置于屏幕的中央。
        frame.setLocationRelativeTo(null);
        //设置不可以调整大小
        frame.setResizable(false);
        //设置默认的关闭方式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /*
        添加窗口中的标签
         */
        //JToolBar 提供了一个用来显示常用的 Action 或控件的组件
        JToolBar toolBar = new JToolBar();

        //设置一组按钮，然后加入到这个jtoolbar容器中
        JButton buttonSpend = new JButton("消费一览");
        JButton buttonRecord = new JButton("记一笔");
        JButton buttonCategory = new JButton("消费分类");
        JButton buttonReport = new JButton("月消费报表");
        JButton buttonConfig = new JButton("设置");
        JButton buttonBackup = new JButton("备份");
        JButton buttonRecover = new JButton("还原");

        //加入JToolBar容器，然后设置容器的相关属性
        toolBar.add(buttonSpend);
        toolBar.add(buttonRecord);
        toolBar.add(buttonCategory);
        toolBar.add(buttonReport);
        toolBar.add(buttonConfig);
        toolBar.add(buttonBackup);
        toolBar.add(buttonRecover);






        //frame添加了两个组件
        /*
        1.JFrame用来做主页面框架也可以用来做顶级窗体，要想把控件放在该界面中，
        必须把控件放在JPanel中，然后再把JPanel放在JFrame中，JPanel作为一个容器使用。

        2.JPanel是一个静态控制组件，可以用来显示一行静态信息，不能接受用户的输入。
        它必须放在象JFrame这样的顶级窗口上才能输出。

        3.JFrame是最底层，JPanel是置于其面上，同一个界面只有一个JFrame，
        一个JFrame可以放多个JPanel。如果你直接在JFrame上放也可以，
        但是首先不规范，然后过于复杂的界面中处理多控件是非常难的
        JPanel只是普通页面
         */

        frame.setLayout(new BorderLayout());
        frame.add(toolBar,BorderLayout.NORTH);          //将按键组件加入jPanel管理
        frame.add(new JPanel(),BorderLayout.CENTER);    //添加另外一个JPanel，用于显示每个按钮激活后的内容

        //显示窗口
        frame.setVisible(true);

        /*
        为各个按钮添加事件监听器
         */
        //备份按钮
        buttonBackup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了备份");
            }
        });

        //消费分类按钮
        buttonCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了消费分类");
            }
        });

        //设置按钮
        buttonConfig.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了设置");
            }
        });

        //记一笔按钮
        buttonRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了记一笔");
            }
        });

        //恢复按钮
        buttonRecover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了恢复");
            }
        });

        //月消费报表按钮
        buttonReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了月消费报表");
            }
        });

        //消费一览按钮
        buttonSpend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("点击了消费一览");
            }
        });

    }
}
