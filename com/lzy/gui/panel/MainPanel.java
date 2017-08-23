package com.lzy.gui.panel;

import com.lzy.gui.util.CenterPanel;
import com.lzy.gui.util.GUIUtil;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2017/8/22.
 */
public class MainPanel extends JPanel{
    static {
        GUIUtil.useLiquidSkin();

    }

    public static MainPanel mainPanel = new MainPanel();

    //一系列功能按钮
    public JToolBar toolBar = new JToolBar();
    public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();

    //工作面板（对应功能的操作区域）
    public CenterPanel workingPanel;

    private MainPanel(){
        GUIUtil.setImageIconTextWord(bSpend,"home.png","消费一览");
        GUIUtil.setImageIconTextWord(bRecord,"record.png","记一笔");
        GUIUtil.setImageIconTextWord(bCategory,"category2.png","消费分类");
        GUIUtil.setImageIconTextWord(bReport,"report.png","月消费报表");
        GUIUtil.setImageIconTextWord(bConfig,"config.png","设置");
        GUIUtil.setImageIconTextWord(bBackup,"backup.png","备份");
        GUIUtil.setImageIconTextWord(bRecover,"restore.png","恢复");

        toolBar.add(bSpend);
        toolBar.add(bRecord);
        toolBar.add(bCategory);
        toolBar.add(bReport);
        toolBar.add(bConfig);
        toolBar.add(bBackup);
        toolBar.add(bRecover);

        this.workingPanel = new CenterPanel(0.8);

        this.setLayout(new BorderLayout());
        this.add(toolBar,BorderLayout.NORTH);
        //添加操作的工作面板
        this.add(workingPanel,BorderLayout.CENTER);


    }


    //测试
    public static void main(String[] args){
        GUIUtil.showPanel(MainPanel.mainPanel,1);
    }

}
