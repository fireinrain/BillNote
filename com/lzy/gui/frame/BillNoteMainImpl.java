package com.lzy.gui.frame;

import com.lzy.gui.panel.MainPanel;

import javax.swing.*;

/**
 * Created by Administrator on 2017/8/24.
 */
public class BillNoteMainImpl extends JFrame{
    public static BillNoteMainImpl instance = new BillNoteMainImpl();

    private BillNoteMainImpl(){
        //相关设置
        this.setSize(500,450);
        this.setTitle("简单记账");
        //设置内容panel
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //测试
    public static void main(String[] args){
        //设置可见（渲染出来）
        BillNoteMainImpl.instance.setVisible(true);
    }
}
