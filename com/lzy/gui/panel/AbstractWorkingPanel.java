package com.lzy.gui.panel;

import javax.swing.*;

/**
 * Created by Administrator on 2017/8/25.
 */
public abstract class AbstractWorkingPanel extends JPanel{
    public abstract void updateData();
    public abstract void addListener();
}
