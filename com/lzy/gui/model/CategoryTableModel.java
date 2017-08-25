package com.lzy.gui.model;


import com.lzy.entity.Category;
import com.lzy.service.CategoryService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */
public class CategoryTableModel implements TableModel{
    public String[] columNames = new String[]{"分类名称","消费次数"};
    public List<Category> cs = new CategoryService().list();



    @Override
    public int getRowCount() {
        return cs.size();
    }

    @Override
    public int getColumnCount() {
        return columNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columNames[columnIndex];
    }

    @Override
    public Class <?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category h = cs.get(rowIndex);
        if (0==columnIndex){
            return h.name;
        }
        if (1==columnIndex){
            return h.recordNumber;
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
