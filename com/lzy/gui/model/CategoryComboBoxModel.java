package com.lzy.gui.model;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 *  用于组合框的数据模型。此接口扩展了 ListDataModel 并添加了选择项 的概念。
 *  选择项通常是组合框显示区域内可见的项。
 *  选择项可能不必通过底层 ListModel 进行管理。
 *  这种分离行为是为模型中选择项的临时存储和检索所做的考虑。
 */

//category的数据控件模型
public class CategoryComboBoxModel implements ComboBoxModel<String>{

    public List<String> cs = new ArrayList <>();

    public String c;

    public CategoryComboBoxModel(){
        cs.add("餐饮");
        cs.add("交通");
        cs.add("住宿");
        cs.add("花费");
        c = cs.get(0);
    }
    @Override
    public void setSelectedItem(Object anItem) {
        c = (String)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return c;
    }

    @Override
    public int getSize() {
        return cs.size();
    }

    @Override
    public String getElementAt(int index) {
        return cs.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
