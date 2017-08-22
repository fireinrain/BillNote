package com.lzy.gui.util;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
/**
 * Created by Administrator on 2017/8/22.
 * 环形进度条（不同的进度，条的颜色不一样）
 */
public class CircleProgressBar extends JPanel{
    //最小进度
    private int minimumProgress;
    //最大进度
    private int maximumProgress;
    //当前进度
    private int progress;
    //进度文本
    private String progressText;
    //背景色
    private Color backgroundColor;
    //前景色
    private Color foregroundColor;

    //无参构造方法
    public CircleProgressBar() {
        minimumProgress = 0;
        maximumProgress = 100;
        progressText = "0%";
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2d = (Graphics2D) g;
        // 开启抗锯齿
        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;
        int fontSize = 0;
        if (getWidth() >= getHeight()) {
            x = (getWidth() - getHeight()) / 2 + 25;
            y = 25;
            width = getHeight() - 50;
            height = getHeight() - 50;
            fontSize = getWidth() / 8;
        } else {
            x = 25;
            y = (getHeight() - getWidth()) / 2 + 25;
            width = getWidth() - 50;
            height = getWidth() - 50;
            fontSize = getHeight() / 8;
        }
         /*
        BasicStroke 类定义针对图形图元轮廓呈现属性的一个基本集合，
        这些图元使用 Graphics2D 对象呈现，而该对象的 Stroke 属性设置为此 BasicStroke。
         */
        //为 Graphics2D 上下文设置 Stroke
        graphics2d.setStroke(new BasicStroke(20.0f));
        //设置背景色
        graphics2d.setColor(backgroundColor);
        //画圆弧
        graphics2d.drawArc(x, y, width, height, 0, 360);
        //设置前景色
        graphics2d.setColor(foregroundColor);
        //画另一个圆弧来覆盖此前的圆弧(正值表示顺时针旋转)
        graphics2d.drawArc(x, y, width, height, 90,
                -(int) (360 * ((progress * 1.0) / (maximumProgress - minimumProgress))));

        //设置字体
        graphics2d.setFont(new Font("黑体", Font.BOLD, fontSize));
        //获取字体参数
        FontMetrics fontMetrics = graphics2d.getFontMetrics();

        int digitalWidth = fontMetrics.stringWidth(progressText);   //获取文本的额宽度
        int digitalAscent = fontMetrics.getAscent();        //获取文本的高度
        graphics2d.setColor(foregroundColor);
        //指定文本显示位置
        graphics2d.drawString(progressText, getWidth() / 2 - digitalWidth / 2, getHeight() / 2 + digitalAscent / 2);
    }

    /*
    控件的相关getter setter
    注：但凡组件的相关属性变化，都要调用组件的repaint方法来重写绘制gui
     */
    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        if (progress >= minimumProgress && progress <= maximumProgress)
            this.progress = progress;
        if (progress > maximumProgress)
            this.progress = maximumProgress;

        this.progressText = String.valueOf(progress + "%");

        this.repaint();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.repaint();
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        this.repaint();
    }
}
