package com.lzy.startup;

import com.lzy.gui.frame.BillNoteMainImpl;
import com.lzy.gui.panel.MainPanel;
import com.lzy.gui.panel.SpendPanel;
import com.lzy.gui.util.GUIUtil;

import javax.swing.*;

/**
 * Created by Administrator on 2017/8/25.
 *
 * 整个应用的启动类
 */
public class BootStrap {
    public static void main(String[] args) {
        GUIUtil.useLiquidSkin();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BillNoteMainImpl.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}
