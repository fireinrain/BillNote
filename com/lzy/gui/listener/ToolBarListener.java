package com.lzy.gui.listener;

import com.lzy.gui.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2017/8/25.
 *
 * 工具栏的监听类
 */
public class ToolBarListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        //mainpanel为单例
        MainPanel p = MainPanel.instance;
        //获取触发事件的组件对象
        JButton button = (JButton)e.getSource();

        //如果对象是bReport
        if (button ==p.bReport){
            p.workingPanel.show(ReportPanel.instance);
        }
        //如果对象是bCategory
        if (button ==p.bCategory){
            p.workingPanel.show(CategoryPanel.instance);
        }
        //如果对象是bSpend
        if (button ==p.bSpend){
            p.workingPanel.show(SpendPanel.instance);
        }
        //如果对象是bRecord
        if (button ==p.bRecord){
            p.workingPanel.show(RecordPanel.instance);
        }
        //如果对象是bConfig
        if (button ==p.bConfig){
            p.workingPanel.show(ConfigPanel.instance);
        }
        //如果对象是bBackup
        if (button ==p.bBackup){
            p.workingPanel.show(BackupPanel.instance);
        }
        //如果对象是bRecover
        if (button ==p.bRecover){
            p.workingPanel.show(RecoverPanel.instance);
        }
    }
}
