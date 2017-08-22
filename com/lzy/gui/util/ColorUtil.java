package com.lzy.gui.util;

import java.awt.*;

/**
 * Created by Administrator on 2017/8/22.
 * 用于设置颜色的工具类
 */

public class ColorUtil {
    public static Color blueColor = Color.decode("#3399FF");
    public static Color grayColor = Color.decode("#999999");
    public static Color backgroundColor = Color.decode("#EEEEEE");
    public static Color warningColor = Color.decode("#FF3333");

    //颜色根据进度从绿色到红色过度
    public static Color getByPercentage(int per){
        if (per>100)
            per = 100;
        int r = 51;
        int g = 255;
        int b = 51;
        float rate = per/100f;
        r = (int)((255-51)*rate+51);
        g = 255-r+51;
        Color color = new Color(r,g,b);
        return color;
    }


}
