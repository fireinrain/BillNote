package com.lzy.gui.util;

import utils.DBUtil;

import java.io.*;

/**
 * Created by Administrator on 2017/8/25.
 */
public class MysqlUtil {

    public static void backup(String mysqlPath,String backupfile) throws IOException{
        String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p%s   -hlocalhost   -P%d %s -r \"%s\"";

        String command = String.format(commandFormat, mysqlPath, DBUtil.loginName, DBUtil.password, DBUtil.port,
                DBUtil.database, backupfile);
        Runtime.getRuntime().exec(command);
        System.out.println("备份成功");
    }

    public static void recover(String mysqlPath,String recoverfile){
        try {
            String commandFormat = "\"%s/bin/mysql.exe\" -u%s -p%s   %s ";
            String command = String.format(commandFormat, mysqlPath, DBUtil.loginName, DBUtil.password,
                    DBUtil.database);

            Process p = Runtime.getRuntime().exec(command);
            OutputStream out = p.getOutputStream();
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(recoverfile), "utf8"));
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();

            OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
            writer.write(outStr);
            writer.flush();
            out.close();
            br.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //测试
    public static void main(String[] args) throws IOException{
        String mysqlPath = "C:\\Program Files\\MySQL\\MySQL Server 5.6";
        String file = "C:\\Users\\Administrator\\Desktop\\tools\\BillNote\\src\\sql\\easy.sql";

        //backup(mysqlPath,file);
        recover(mysqlPath,file);
    }

}
