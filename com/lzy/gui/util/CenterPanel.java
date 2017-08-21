package com.lzy.gui.util;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2017/8/21.
 *
 * 实现panel组件居中显示的工具了
 */

public class CenterPanel extends JPanel{

    private double rate;    //拉伸比例
    private JComponent jComponent;      //现实的组件
    private boolean strech;     //是否拉伸

    //构造方法
    public CenterPanel(double rate,boolean strech) {
        this.setLayout(null);
        this.rate = rate;
        this.strech = strech;
    }

    public CenterPanel(double rate) {
        this.rate = rate;
    }


    public void repaint(){
        if (null!=jComponent){
            //获取容器的大小
            Dimension containerSize = this.getSize();
            //获取组件的大小
            Dimension componentSize = jComponent.getSize();
        }
    }
}
