package com.lzy.entity;

/**
 * Created by Administrator on 2017/8/24.
 *
 * 配置信息实体类
 */
public class Config {
    public int id;
    public String key;
    public String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
