package com.lzy.gui.listener;

import com.lzy.gui.panel.ConfigPanel;
import com.lzy.gui.util.GUIUtil;
import com.lzy.service.ConfigService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Administrator on 2017/8/25.
 *
 * config中的button的监听器
 */
public class ConfigListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel configPanel = ConfigPanel.instance;

        //检查预算文本域是不是数字
        if (!GUIUtil.checkNumber(configPanel.textFieldBudget,"本月预算"))
            return;
        //检查mysql路径文本域是否为空
        if (!GUIUtil.checkEmpty(configPanel.textFieldMysql,"Mysql路径"))
            return;

        //获取mysql文本域
        String mysqlPath = configPanel.textFieldMysql.getText();
        //System.out.println(mysqlPath);

        //判断文本域有内容
        if (0!=mysqlPath.length()){
            File commandFile = new File(mysqlPath,"bin/mysql.exe");
            //判断是否在该文件夹下是否存在mysql的启动文件
            if (!commandFile.exists()){
                JOptionPane.showMessageDialog(configPanel,"Mysql路径不正确");
                configPanel.textFieldMysql.grabFocus();
                return;
            }
        }

        //configService 从界面获取的合理的值，更新到数据库中
        ConfigService configService = new ConfigService();
        configService.update(ConfigService.budget,configPanel.textFieldBudget.getText());
        configService.update(ConfigService.mysqlPath,configPanel.textFieldMysql.getText());

        JOptionPane.showMessageDialog(configPanel,"设置修改成功");
    }
}
