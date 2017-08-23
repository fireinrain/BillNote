package com.lzy.gui.panel;

import com.lzy.gui.util.CharUtil;
import com.lzy.gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2017/8/23.
 *
 * 条形图统计页面
 */
public class ReportPanel extends JPanel{
    static {
        GUIUtil.useLiquidSkin();
    }

    public static ReportPanel instance = new ReportPanel();
    public JLabel label = new JLabel();

    public ReportPanel(){
        this.setLayout(new BorderLayout());
        Image i = CharUtil.getImage(400,300);
        ImageIcon icon = new ImageIcon(i);
        label.setIcon(icon);
        this.add(label);
    }

    public static void main(String[] args){
        GUIUtil.showPanel(ReportPanel.instance);
    }
}
