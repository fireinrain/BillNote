package com.lzy.gui.listener;

import com.lzy.gui.panel.BackupPanel;
import com.lzy.gui.panel.ConfigPanel;
import com.lzy.gui.panel.MainPanel;
import com.lzy.gui.util.MysqlUtil;
import com.lzy.service.ConfigService;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Administrator on 2017/8/26.
 */
public class BackupListener implements ActionListener{



    @Override
    public void actionPerformed(ActionEvent e) {
        BackupPanel backupPanel = BackupPanel.instance;
        String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
        if (0==mysqlPath.length()){
            JOptionPane.showMessageDialog(backupPanel,"备份前请先设置好mysql路径");
            MainPanel.instance.workingPanel.show(ConfigPanel.instance);
            ConfigPanel.instance.textFieldMysql.grabFocus();
            return;
        }
        //文件选择器
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File("easy.sql"));
        fileChooser.setFileFilter(new FileFilter() {

            public boolean accept(File f) {
                return f.getName().toUpperCase().endsWith(".sql");
            }

            @Override
            public String getDescription() {
                return ".sql";
            }
        });

        int returnVal = fileChooser.showSaveDialog(backupPanel);
        File file = fileChooser.getSelectedFile();
        System.out.println(file);
        if (returnVal==JFileChooser.APPROVE_OPTION){
            //如果保存的文件名没有以.sql结尾，自动加上.sql
            System.out.println(file);
            if (!file.getName().toLowerCase().endsWith(".sql")){
                file = new File(file.getParent(),file.getName()+".sql");
            }
            System.out.println(file);

            try{
                MysqlUtil.backup(mysqlPath,file.getAbsolutePath());
                JOptionPane.showMessageDialog(backupPanel,"备份成功，备份文件位于:\r\n"+file.getAbsolutePath());
            }catch (Exception e2){
                e2.printStackTrace();
                JOptionPane.showMessageDialog(backupPanel,"备份失败\r\n,错误：\r\n"+e2.getMessage());
            }
        }
    }
}
