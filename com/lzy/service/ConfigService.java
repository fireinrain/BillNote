package com.lzy.service;

import com.lzy.dao.ConfigDao;
import com.lzy.entity.Config;

/**
 * Created by Administrator on 2017/8/25.
 *
 * config的业务类
 */
public class ConfigService {
    public static final String budget = "budget";
    public static final String mysqlPath = "mysqlPath";
    public static final String default_budget = "500";

    public static ConfigDao configDao = new ConfigDao();
    //静态块
    static {
        init();
    }

    public static void init(){
        init(budget,default_budget);
        init(mysqlPath,"");
    }

    private static void init(String key,String value){
        Config cfg = configDao.getByKey(key);
        if (null==cfg){
            Config c = new Config();
            c.setKey(key);
            c.setValue(value);
            configDao.add(c);
        }
    }

    public String get(String key){
        Config config = configDao.getByKey(key);
        return config.getValue();
    }

    public void update(String key,String value){
        Config config = configDao.getByKey(key);
        config.setValue(value);
        configDao.update(config);
    }

    public int getIntBudget(){
        return Integer.parseInt(this.get(budget));
    }

}
