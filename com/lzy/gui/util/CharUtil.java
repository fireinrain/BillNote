package com.lzy.gui.util;


import com.lzy.entity.Record;
import com.objectplanet.chart.BarChart;
import com.objectplanet.chart.Chart;

import java.awt.*;
import java.util.List;


/**
 * Created by Administrator on 2017/8/22.
 * 图表工具类
 */
public class CharUtil {

    //遍历数组，选出最大的
    public static int max(double[] sampleValues){
        int max = 0;
        for (double v:sampleValues
             ) {
            if (v>max)
                max = (int)v;
        }
        return max;
    }

    //给定默认数据使用
    private static double[] sampleValues() {

        double[] result = new double[30];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (Math.random() * 300);
        }
        return result;

    }
    //给定默认数据使用
    private static String[] sampleLabels() {
        String[] sampleLabels = new String[30];

        for (int i = 0; i < sampleLabels.length; i++) {
            if (0 == i % 5)
                sampleLabels[i] = String.valueOf(i + 1 + "日");
        }
        return sampleLabels;
    }

    //获取数据标签(私有)
    private static String[] sampleLabels(List<Record> recordList){
        String[] sampleLabels = new String[recordList.size()];

        for (int i = 0; i <sampleLabels.length ; i++) {
            if (0==i%5)
               sampleLabels[i] = String.valueOf(i+1);
        }
        return sampleLabels;
    }

    //获取样本数据（私有）
    private static double[] sampleValues(List<Record> recordList){

        double[] result = new double[recordList.size()];
        for (int i = 0; i <result.length ; i++) {
            result[i] = recordList.get(i).spend;
        }
        return result;
    }

    //获取样本生成的图片
    public static Image getImage(List<Record> recordList,int width,int height){
        //模拟样本数据
        double[] sampleValues = sampleValues(recordList);
        //下方显示的文字
        String[] sampleLabels = sampleLabels(recordList);

        //样本中的最大值
        int max = max(sampleValues);

        //数据颜色
        Color[] sampleColors = new Color[]{ColorUtil.blueColor};    //暂时为一个蓝色对象

        //柱状图
        BarChart chart = new BarChart();

        //设置样本个数
        chart.setSampleCount(sampleValues.length);
        //设置样本数据
        chart.setSampleValues(0,sampleValues);
        //设置文字

        chart.setSampleLabels(sampleLabels);
        //设置样本颜色
        chart.setSampleColors(sampleColors);
        //设置取值范围
        chart.setRange(0,max*1.2);
        //设置背景横线
        chart.setValueLabelsOn(true);
        //显示文字
        chart.setSampleLabelsOn(true);
        //把文字显示在下方
        chart.setSampleLabelStyle(Chart.BELOW);

        //样本值的字体
        chart.setFont("rangeLabelFont",new Font("Arial", Font.BOLD,12));
        //显示图例说明
        chart.setLegendOn(true);
        //把图例说明放在左侧
        chart.setLegendPosition(Chart.LEFT);
        //图例中的说明文字
        chart.setLegendLabels(new String[]{"月消费报表"});
        //图例说明的字体
        chart.setFont("legendFont",new Font("Dialog",Font.BOLD,13));
        //下方文字的字体
        chart.setFont("sampleLabelFont",new Font("Dialog",Font.BOLD,8));
        //图表中间的背景色
        chart.setChartBackground(Color.WHITE);
        //图表整体的背景色
        chart.setBackground(ColorUtil.backgroundColor);
        //把图标转换为Image类型
        Image image = chart.getImage(width, height);
        return image;
    }

    //主类测试
    public static void main(String[] args){
        /*
         JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel();

        Image image = CharUtil.getImage(400,300);
        Icon icon = new ImageIcon(image);
        jLabel.setIcon(icon);
        jPanel.add(jLabel);
        GUIUtil.showPanel(jPanel);
         */

    }


}
