package com.lzy.gui.panel;

import com.lzy.entity.Category;
import com.lzy.gui.listener.RecordListener;
import com.lzy.gui.model.CategoryComboBoxModel;
import com.lzy.gui.util.ColorUtil;
import com.lzy.gui.util.GUIUtil;
import com.lzy.service.CategoryService;
import org.jdesktop.swingx.JXDatePicker;


import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/23.
 */
public class RecordPanel extends AbstractWorkingPanel{
    //使用皮肤
    static {
        GUIUtil.useLiquidSkin();
    }

    public static RecordPanel instance = new RecordPanel();

    JLabel lSpend = new JLabel("花费(￥)");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    JLabel lDate = new JLabel("日期");

    //花费文本域
    public JTextField textFieldSpend = new JTextField("0");
    //分类数据模型
    public CategoryComboBoxModel comboBoxModel = new CategoryComboBoxModel();
    //分类数据模型（下拉框）
    public JComboBox<Category> cbCategory = new JComboBox <>(comboBoxModel);
    //备注文本域
    public JTextField textFieldComment = new JTextField();
    //日期控件
    public JXDatePicker datePicker = new JXDatePicker(new Date());

    JButton jButtonSub = new JButton("记一笔");

    //无参构造方法
    public RecordPanel(){
        GUIUtil.setColor(ColorUtil.grayColor,lSpend,lCategory,lComment,lDate);
        GUIUtil.setColor(ColorUtil.blueColor,jButtonSub);

        //上下布局
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;
        //布局为4行两列 行列间距为40
        pInput.setLayout(new GridLayout(4,2,gap,gap));
        //把组件加入到panel里面
        pInput.add(lSpend);
        pInput.add(textFieldSpend);

        pInput.add(lCategory);
        pInput.add(cbCategory);

        pInput.add(lComment);
        pInput.add(textFieldComment);

        pInput.add(lDate);
        pInput.add(datePicker);

        //添加按钮
        pSubmit.add(jButtonSub);

        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.CENTER);
        //添加事件监听器
        this.addListener();

    }

    //测试入口
    public static void main(String[] args){
        GUIUtil.showPanel(RecordPanel.instance);
    }

    public Category getSelectedCategory(){
        return (Category)cbCategory.getSelectedItem();
    }
    @Override
    public void updateData() {
        comboBoxModel.cs = new CategoryService().list();
        cbCategory.updateUI();
        resetInput();
        textFieldSpend.grabFocus();
    }

    public void resetInput(){
        textFieldSpend.setText("0");
        textFieldComment.setText("");
        if (0!=comboBoxModel.cs.size()){
            cbCategory.setSelectedIndex(0);
        }
        datePicker.setDate(new Date());
    }

    @Override
    public void addListener() {
        RecordListener listener = new RecordListener();
        jButtonSub.addActionListener(listener);
    }
}
