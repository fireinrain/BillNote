package com.lzy.gui.panel;

import com.lzy.entity.Category;
import com.lzy.gui.listener.CategoryListener;
import com.lzy.gui.model.CategoryTableModel;
import com.lzy.gui.util.ColorUtil;
import com.lzy.gui.util.GUIUtil;
import com.lzy.service.CategoryService;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2017/8/23.
 *
 * 分类展示页面
 */
public class CategoryPanel extends JPanel{
    static {
        GUIUtil.useLiquidSkin();
    }

    public static CategoryPanel instance = new CategoryPanel();

    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");

    String[] columNumbers = new String[]{"分类名称","消费次数"};

    public CategoryTableModel categoryTableModel = new CategoryTableModel();
    public JTable table = new JTable(categoryTableModel);

    //无参构造函数
    public CategoryPanel(){
        GUIUtil.setColor(ColorUtil.blueColor,bAdd,bEdit,bDelete);
        JScrollPane jScrollPane = new JScrollPane(table);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);

        //布局
        this.setLayout(new BorderLayout());
        this.add(jScrollPane,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH);

        //添加事件监听
        this.addListener();
    }

    public Category getSelectedCategory(){
        int index = table.getSelectedRow();
        return categoryTableModel.cs.get(index);
    }

    public void updateData(){
        categoryTableModel.cs = new CategoryService().list();
        table.updateUI();
        table.getSelectionModel().setSelectionInterval(0,0);

        if (0==categoryTableModel.cs.size()){
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        }else {
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }
    }

    //为按钮添加事件监听器
    public void addListener(){
        CategoryListener categoryListener = new CategoryListener();
        bAdd.addActionListener(categoryListener);
        bEdit.addActionListener(categoryListener);
        bDelete.addActionListener(categoryListener);
    }

    //测试
    public static void main(String[] args){
        GUIUtil.showPanel(CategoryPanel.instance);
    }


}
