package com.lzy.service;

import com.lzy.dao.CategoryDao;
import com.lzy.dao.RecordDao;
import com.lzy.entity.Category;
import com.lzy.entity.Record;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/8/25.
 */
public class CategoryService {
    public static CategoryDao categoryDao = new CategoryDao();
    public static RecordDao recordDao = new RecordDao();

    //查询所有记录，并依据相关分类的记录数量排序
    public List<Category> list(){
        /**
        * @Description:将所有的分类查询出来
         *  再讲分类中的记录查询出来，统计记录数量，用来做排序的一句
        * TODO
        * @param:[]
        * @return:java.util.List<com.lzy.entity.Category>
        * @date:2017/8/25-9:29
        */
        List<Category> categoryList = categoryDao.list();
        for (Category c:categoryList
             ) {
            //查询出分类的相关记录条数
            List<Record> recordList = recordDao.list(c.id);
            //将获取的记录条数大小传给单个分类的recordNumber属性
            c.recordNumber = recordList.size();
        }
        //对记录较多的分类进行排序（更靠前）
        Collections.sort(categoryList,(c1,c2)->c2.recordNumber-c1.recordNumber);    //lambda表达式
        return categoryList;
    }

    //添加
    public void add(String name){
        Category c = new Category();
        c.setName(name);
        categoryDao.add(c);
    }

    //更新
    public void update(int id,String name){
        Category c = new Category();
        c.setId(id);
        c.setName(name);
        categoryDao.update(c);
    }

    //删除
    public void delete(int id){
        categoryDao.delete(id);
    }

}
