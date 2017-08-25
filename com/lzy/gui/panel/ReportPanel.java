package com.lzy.gui.panel;

import com.lzy.entity.Record;
import com.lzy.gui.util.CharUtil;
import com.lzy.gui.util.GUIUtil;
import com.lzy.service.ReportService;

import javax.swing.*;
import java.awt.*;
import java.util.List;



/**
 * Created by Administrator on 2017/8/23.
 *
 * 条形图统计页面
 */
public class ReportPanel extends AbstractWorkingPanel{
    static {
        GUIUtil.useLiquidSkin();
    }

    public static ReportPanel instance = new ReportPanel();
    public JLabel label = new JLabel();

    public ReportPanel(){
        this.setLayout(new BorderLayout());
        List<Record> recordList = new ReportService().listThisMonthRecords();
        Image i = CharUtil.getImage(recordList,400,300);
        ImageIcon icon = new ImageIcon(i);
        label.setIcon(icon);
        this.add(label);
        addListener();
    }

    public static void main(String[] args){
        GUIUtil.showPanel(ReportPanel.instance);
    }

    @Override
    public void updateData() {
        List<Record> recordList = new ReportService().listThisMonthRecords();
        Image i = CharUtil.getImage(recordList,350,250);
        ImageIcon icon = new ImageIcon(i);
        label.setIcon(icon);
    }

    @Override
    public void addListener() {

    }
}
