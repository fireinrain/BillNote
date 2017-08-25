package com.lzy.gui.util;

import com.lzy.gui.panel.AbstractWorkingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2017/8/21.
 *
 * 实现panel组件居中显示的工具了
 */



public class CenterPanel extends JPanel {

    private double rate;//拉伸比例
    private JComponent component; //显示的组件
    private boolean strech; //是否拉伸

    public CenterPanel(double rate,boolean strech) {
        this.setLayout(null);
        this.rate = rate;
        this.strech = strech;
    }

    public CenterPanel(double rate) {
        this(rate,true);
    }

    public void repaint() {
        if (null != component) {
            Dimension containerSize = this.getSize();
            Dimension componentSize= component.getPreferredSize();

            if(strech)
                component.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
            else
                component.setSize(componentSize);

            component.setLocation(containerSize.width / 2 - component.getSize().width / 2, containerSize.height / 2 - component.getSize().height / 2);
        }
        super.repaint();
    }

    public void show(JComponent p) {
        this.component = p;
        Component[] cs = this.getComponents();
        for (Component c : cs) {
            this.remove(c);
        }
        this.add(p);

        //判断显示的组件是否是工作功能panel
        if(p instanceof AbstractWorkingPanel){
            ((AbstractWorkingPanel) p).updateData();
        }
        this.updateUI();
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(200, 200);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(0.85,true);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        JButton b  =new JButton("abc");
        cp.show(b);

    }

}



