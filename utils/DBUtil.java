package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/8/24.
 */
public class DBUtil {
    //静态变量
    public static String ip = "127.0.0.1";
    public static int port = 3306;
    public static String database = "hutubill";
    public static String encoding = "UTF-8";
    public static String loginName = "root";
    public static String password = "root";

    //静态块，只加载一次
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //返回数据库连接对象
    public static Connection getConnection() throws SQLException{
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s",ip,
                                        port,database,encoding);
        return DriverManager.getConnection(url,loginName,password);

    }



}
