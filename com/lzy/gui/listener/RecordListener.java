package com.lzy.gui.listener;

import com.lzy.entity.Category;
import com.lzy.gui.panel.CategoryPanel;
import com.lzy.gui.panel.MainPanel;
import com.lzy.gui.panel.RecordPanel;
import com.lzy.gui.panel.SpendPanel;
import com.lzy.gui.util.GUIUtil;
import com.lzy.service.RecordService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/25.
 */
public class RecordListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        RecordPanel recordPanel = RecordPanel.instance;
        if (0==recordPanel.comboBoxModel.cs.size()){
            JOptionPane.showMessageDialog(recordPanel,"暂无消费分类,无法添加，请先添加分类");
            MainPanel.instance.workingPanel.show(CategoryPanel.instance);
            return;
        }

        if (!GUIUtil.checkZero(recordPanel.textFieldSpend,"花费金额")){
            return;
        }


        int spend = Integer.parseInt(recordPanel.textFieldSpend.getText());
        Category category = recordPanel.getSelectedCategory();
        String comment = recordPanel.textFieldComment.getText();
        Date date = recordPanel.datePicker.getDate();
        new RecordService().add(spend,category,comment,date);

        MainPanel.instance.workingPanel.show(SpendPanel.instance);
    }


}
