package com.lzy.dao;

import com.lzy.entity.Category;

import utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */
public class CategoryDao {

    //添加
    public void add(Category category){
        //String sql = "insert into category (name) values(?)";
        String sql = "insert into category values(null,?)";

        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,category.name);
            

            ps.execute();

            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                category.id = id;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //更新
    public void update(Category category){
        String sql = "update  category set name=? where id = ?";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,category.name);
            ps.setInt(2,category.id);

            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //删除
    public void delete(int id){
        String sql = "delete from category where id="+id;
        try(Connection connection = DBUtil.getConnection(); Statement s = connection.createStatement()){
            s.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //获取
    public Category get(int id){
        Category category = null;
        try(Connection connection = DBUtil.getConnection(); Statement s = connection.createStatement()){
            String sql = "select * from category where id="+id;

            ResultSet resultSet = s.executeQuery(sql);
            if (resultSet.next()){
                category = new Category();

                String name = resultSet.getString("name");
                category.name = name;
                category.id = id;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return category;
    }

    //查询所有
    public List<Category> list(){
        
        return list(0,Integer.MAX_VALUE);
    }

    //分页查询
    public List<Category> list(int start,int count){
        List<Category> categoryList = new ArrayList<>();
        String sql = "select * from category order by id desc limit ?,?";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){

                Category c = new Category();

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                c.id = id;
                c.name = name;


                categoryList.add(c);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return categoryList;
    }

    //获取总记录
    public int getTotal(){
        int total = 0;
        try (Connection connection = DBUtil.getConnection();Statement statement = connection.createStatement()){
            String sql = "select count(*) from category";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                resultSet.getInt(1);
            }
            System.out.println("总记录："+total);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    public Category getByName(String key){
        Category category = null;
        String sql = "select * from category where name=?";
        try (Connection connection = DBUtil.getConnection();PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,key);


            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                category = new Category();
                int id = resultSet.getInt("id");

                String name = resultSet.getString("name");

                category.id = id;
                category.name = name;


            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return category;
    }

    //测试
    public static void main(String[] args) {
        Category category = new Category();
        category.name = "手办";

        CategoryDao categoryDao = new CategoryDao();
        //categoryDao.add(category);
        //category.name = "游戏";
        //System.out.println(category.id);
        //category.id = 2;
        //categoryDao.update(category);

        //Category c= categoryDao.get(2);
        //System.out.println(c.name);

        //categoryDao.delete(4);

        //System.out.println(categoryDao.list());

        System.out.println(categoryDao.getByName("手办"));

    }
}
