package com.lzy.gui.util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Administrator on 2017/8/21.
 * 在开发图形界面的过程中，有很多功能在各个地方都会用到，
 * 并且重复使用的概率比较高。 比如判断一个输入框是否是数字，
 * 是否是空，是否为0等等类似的，所以把这些使用比较普遍的功能，
 * 抽象到一个工具类里。 这样以后再用的时候，就直接调用就可以了，
 * 而不需要每次都单独再写一遍。
 */
public class GUIUtil {
    //设置图标 图片放置的路径
    private static String imageFolder = "src/imgresource";

    //判断输入框内容是否为空
    public static boolean checkEmpty(JTextField textField,String input){
        String text = textField.getText().trim();   //获取文本域中的文本
        if (0==text.length()){
            JOptionPane.showMessageDialog(null,input+"不能为空");
            textField.grabFocus();
            return false;
        }
        return true;
    }

    //判断文本域内是否是数字内容
    public static boolean checkNumber(JTextField textField,String input){
        if (!checkEmpty(textField,input)){
            return false;
        }
        String text = textField.getText().trim();

        try{
            //转换成功说明文本含有数字格式
            Integer.parseInt(text);
            return true;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,input+"需要整数");
            //获得焦点
            textField.grabFocus();
            return false;
        }
    }

    //判断数字是否为0
    public static boolean checkZero(JTextField textField,String input){
        if (!checkNumber(textField,input))
            return false;
        String text =  textField.getText().trim();

        if (0==Integer.parseInt(text)){
            JOptionPane.showMessageDialog(null,input+"不能为0");
            textField.grabFocus();
            return false;
        }
        return true;
    }

    //给多个组件设置颜色
    public static void setColor(Color color,JComponent...components){
        for (Component c:components
             ) {
            c.setForeground(color);
        }
    }

    //给组件设置图片 文本 提示文字
    public static void setImageIconTextWord(JButton b,String fileName,String tip){
        //System.out.println(new File(imageFolder,fileName).getAbsolutePath());

        ImageIcon imageIcon = new ImageIcon(new File(imageFolder,fileName).getAbsolutePath());
        b.setIcon(imageIcon);
        b.setPreferredSize(new Dimension(61,81));
        b.setToolTipText(tip);      //光标在该组件上时，显示该文本
        //设置文本相对于图片在z轴上的位置
        b.setVerticalTextPosition(JButton.BOTTOM);
        //设置文本相对于图片在x轴上的位置(水平)
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }

    //java swing的水晶皮肤
    public static void useLiquidSkin(){
        try{
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //显示panel 将组件显示出来
    public static void showPanel(JPanel panel,double strech){
        //使用swing的水晶皮肤要在加载JFrame之前
        GUIUtil.useLiquidSkin();
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);

        CenterPanel centerPanel = new CenterPanel(strech);
        //为窗口指定内容容器
        frame.setContentPane(centerPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        centerPanel.show(panel);

    }

    public static void showPanel(JPanel panel){
        showPanel(panel,0.85);
    }
}
