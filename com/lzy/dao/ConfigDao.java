package com.lzy.dao;

import com.lzy.entity.Config;
import utils.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/24.
 */
public class ConfigDao {

    //添加
    public void add(Config config){
        String sql = "insert into config values(null,?,?)";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,config.key);
            ps.setString(2,config.value);

            ps.execute();

            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                config.id = id;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //更新
    public void update(Config config){
        String sql = "update  config set key_=?,value=? where id = ?";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,config.key);
            ps.setString(2,config.value);
            ps.setInt(3,config.id);

            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //删除
    public void delete(int id){
        String sql = "delete from config where id="+id;
        try(Connection connection = DBUtil.getConnection(); Statement s = connection.createStatement()){
           s.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //获取
    public Config get(int id){
        Config config = null;
        try(Connection connection = DBUtil.getConnection(); Statement s = connection.createStatement()){
            String sql = "select * from config where id="+id;

            ResultSet resultSet = s.executeQuery(sql);
            if (resultSet.next()){
                config = new Config();

                String key = resultSet.getString("key_");
                String value = resultSet.getString("value");
                config.key = key;
                config.value = value;
                config.id = id;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return config;
    }

    //查询所有
    public List<Config> list(){
        /*
         List<Config> configList = new ArrayList <>();
        try(Connection connection = DBUtil.getConnection(); Statement s = connection.createStatement()){
           String sql = "select * from config";

           ResultSet resultSet = s.executeQuery(sql);
           if (resultSet.next()){

               Config c = new Config();

               int id = resultSet.getInt("id");
               String key = resultSet.getString("key_");
               String value = resultSet.getString("value");

               c.id = id;
               c.key = key;
               c.value = value;

               configList.add(c);

           }
        }catch (SQLException e){
            e.printStackTrace();
        }
         */
        return list(0,Integer.MAX_VALUE);
    }

    //分页查询
    public List<Config> list(int start,int count){
        List<Config> configList = new ArrayList <>();
        String sql = "select * from config order by id desc limit ?,?";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,start);
            ps.setInt(2,count);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){

                Config c = new Config();

                int id = resultSet.getInt("id");
                String key = resultSet.getString("key_");
                String value = resultSet.getString("value");

                c.id = id;
                c.key = key;
                c.value = value;

                configList.add(c);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return configList;
    }

    //获取总记录
    public int getTotal(){
        int total = 0;
        try (Connection connection = DBUtil.getConnection();Statement statement = connection.createStatement()){
            String sql = "select count(*) from config";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                total = resultSet.getInt(1);
            }
            System.out.println("总记录："+total);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    public Config getByKey(String key){
        Config config = null;
        String sql = "select * from config where key_=?";
        try (Connection connection = DBUtil.getConnection();PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1,key);


            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
               config = new Config();
                int id = resultSet.getInt("id");

                String value = resultSet.getString("value");

                config.id = id;
                config.key = key;
                config.value = value;

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return config;
    }

    public static void main(String[] args) {
        Config config = new Config();
        config.key = "dir";
        config.value = "src//c";
        ConfigDao configDao = new ConfigDao();

        //configDao.add(config);
        //config.value = "hehe";
        //configDao.update(config);
        //configDao.delete(3);
        //System.out.println(configDao.get(2));
        //System.out.println(configDao.list());
        //configDao.getTotal();
        //System.out.println(configDao.getByKey("dir"));

    }
}
