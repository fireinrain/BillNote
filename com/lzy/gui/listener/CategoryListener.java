package com.lzy.gui.listener;

import com.lzy.entity.Category;
import com.lzy.gui.panel.CategoryPanel;
import com.lzy.service.CategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2017/8/25.
 */
public class CategoryListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryPanel categoryPanel = CategoryPanel.instance;

        //获取发生事件的按钮
        JButton b = (JButton)e.getSource();
        //如果是添加按钮
        if (b==categoryPanel.bAdd){
            String name = JOptionPane.showInputDialog(null);
            if (0==name.length()){
                JOptionPane.showMessageDialog(categoryPanel,"分类名称不能为空");
                return;
            }
            //添加入数据库
            new CategoryService().add(name);
        }
        //如果是编辑按钮
        if (b==categoryPanel.bEdit){
            Category category = categoryPanel.getSelectedCategory();
            int id = category.id;
            String name = JOptionPane.showInputDialog("修改分类名称",category.name);
            if (0==name.length()){
                JOptionPane.showMessageDialog(categoryPanel,"分类名不能为空");
                return;
            }

            new CategoryService().update(id,name);
        }

        //如果是删除按钮
        if (b==categoryPanel.bDelete) {
            Category category = categoryPanel.getSelectedCategory();
            if (0 != category.recordNumber) {
                JOptionPane.showMessageDialog(categoryPanel, "本分类下有消费记录存在，不存在");
                return;
            }
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(categoryPanel, "确定删除?"))
                return;

            int id = category.id;
            new CategoryService().delete(id);


        }
        //更新数据
        categoryPanel.updateData();
    }
}
