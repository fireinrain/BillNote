package com.lzy.dao;

import com.lzy.entity.Record;
import utils.DBUtil;
import utils.DateUtil;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by Administrator on 2017/8/24.
 */
public class RecordDao {
    //添加
    public void add(Record record){

        String sql = "insert into record values(null,?,?,?,?)";

        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,record.spend);
            ps.setInt(2,record.cid);
            ps.setString(3,record.comment);
            ps.setDate(4, DateUtil.util2sql(record.date));

            ps.execute();

            ResultSet resultSet = ps.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                record.id = id;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //更新
    public void update(Record record){
        String sql = "update  record set spend=?,cid=?,comment=?,date=? where id = ?";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1,record.spend);
            ps.setInt(2,record.cid);
            ps.setString(3,record.comment);
            ps.setDate(4, DateUtil.util2sql(record.date));
            ps.setInt(5,record.id);
            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //删除
    public void delete(int id){
        String sql = "delete from record where id="+id;
        try(Connection connection = DBUtil.getConnection(); Statement s = connection.createStatement()){
            s.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //获取
    public Record get(int id){
        Record record = null;
        try(Connection connection = DBUtil.getConnection(); Statement s = connection.createStatement()){
            String sql = "select * from record where id="+id;

            ResultSet resultSet = s.executeQuery(sql);
            if (resultSet.next()){
                record = new Record();

                int spend = resultSet.getInt("spend");
                int cid = resultSet.getInt("cid");
                String comment = resultSet.getString("comment");
                Date date = resultSet.getDate("date");  //注意这里的时间格式 为sql中的Date类
                record.id = id;
                record.spend = spend;
                record.cid = cid;
                record.comment = comment;
                record.date = date;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return record;
    }

    //查询所有
    public List<Record> list(){

        return list(0,Integer.MAX_VALUE);
    }

    //分页查询
    public List<Record> list(int start,int count){
        List<Record> recordList = new ArrayList<>();
        String sql = "select * from record order by id desc limit ?,?";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1,start);
            ps.setInt(2,count);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){

                Record record = new Record();
                int id = resultSet.getInt("id");
                int spend = resultSet.getInt("spend");
                int cid = resultSet.getInt("cid");
                String comment = resultSet.getString("comment");
                Date date = resultSet.getDate("date");  //注意这里的时间格式 为sql中的Date类
                record.spend = spend;
                record.cid = cid;
                record.comment = comment;
                record.date = date;


                recordList.add(record);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return recordList;
    }

    //获取总记录
    public int getTotal(){
        int total = 0;
        try (Connection connection = DBUtil.getConnection();Statement statement = connection.createStatement()){
            String sql = "select count(*) from record";

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

    //查询某种目录下的所有记录
    public List<Record> list(int cid){
        List<Record> recordList = new ArrayList<>();
        String sql = "select * from record where cid = ?";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1,cid);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){

                Record record = new Record();
                int id = resultSet.getInt("id");
                int spend = resultSet.getInt("spend");

                String comment = resultSet.getString("comment");
                Date date = resultSet.getDate("date");  //注意这里的时间格式 为sql中的Date类

                record.id = id;
                record.spend = spend;
                record.cid = cid;
                record.comment = comment;
                record.date = date;


                recordList.add(record);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return recordList;
    }

    //某一天的消费记录
    //这里的Date 是 util下的date
    public List<Record> list(java.util.Date day){
        List<Record> recordList = new ArrayList<>();
        String sql = "select * from record where date = ?";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setDate(1,DateUtil.util2sql(day));

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){

                Record record = new Record();
                int id = resultSet.getInt("id");
                int spend = resultSet.getInt("spend");
                int cid = resultSet.getInt("cid");

                String comment = resultSet.getString("comment");
                Date date = resultSet.getDate("date");  //注意这里的时间格式 为sql中的Date类

                record.id = id;
                record.spend = spend;
                record.cid = cid;
                record.comment = comment;
                record.date = date;


                recordList.add(record);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return recordList;
    }

    //整个月的消费记录
    public List<Record> listThisMonth(){
        return list(DateUtil.monthBegin(),DateUtil.monthEnd());
    }

    //某个时间区间的消费记录
    public List<Record>list(java.util.Date start,java.util.Date end){
        List<Record> recordList = new ArrayList<>();
        String sql = "select * from record where date >=? and date<=?";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setDate(1,DateUtil.util2sql(start));
            ps.setDate(2,DateUtil.util2sql(end));

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){

                Record record = new Record();
                int id = resultSet.getInt("id");
                int spend = resultSet.getInt("spend");
                int cid = resultSet.getInt("cid");

                String comment = resultSet.getString("comment");
                Date date = resultSet.getDate("date");  //注意这里的时间格式 为sql中的Date类

                record.cid = cid;
                record.comment = comment;
                record.id = id;
                record.spend = spend;
                record.date = date;

                recordList.add(record);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return recordList;
    }




    //测试
    public static void main(String[] args) {
        Record record = new Record();
        record.spend = 100;
        record.cid = 2;
        record.comment = "fuck you";
        record.date = new java.util.Date();

        RecordDao recordDao = new RecordDao();
        //recordDao.add(record);
        //record.comment = "one night in beijing";
        //recordDao.update(record);
        //recordDao.delete(3);
        //System.out.println(recordDao.get(2));
        //System.out.println(recordDao.list());
        //System.out.println(recordDao.list(2));
        //System.out.println(recordDao.listThisMonth());
        //System.out.println(recordDao.list(new java.util.Date()));
    }
}
