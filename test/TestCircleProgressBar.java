package test;

import com.lzy.gui.util.CircleProgressBar;
import com.lzy.gui.util.ColorUtil;
import com.lzy.gui.util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2017/8/22.
 */

//测试圆弧进度条
public class TestCircleProgressBar {
    public static void main(String[] args){
        GUIUtil.useLiquidSkin();

        //面板
        JPanel jPanel = new JPanel();
        //进度组件
        CircleProgressBar circleProgressBar = new CircleProgressBar();
        circleProgressBar.setBackgroundColor(ColorUtil.blueColor);
        circleProgressBar.setProgress(0);

        //按钮
        JButton jButton = new JButton("点击");
        //添加组件
        jPanel.setLayout(new BorderLayout());
        jPanel.add(circleProgressBar,BorderLayout.CENTER);
        jPanel.add(jButton,BorderLayout.SOUTH);

        //显示面板
        GUIUtil.showPanel(jPanel);

        //给按钮添加事件监听
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                SwingWorker执行耗时任务
                SwingWorker 设计用于需要在后台线程中运行长时间运行任务的情况，
                并可在完成后或者在处理过程中向 UI 提供更新。
                SwingWorker 的子类必须实现 doInBackground() 方法，以执行后台计算。
                 */
                new SwingWorker(){

                    @Override
                    protected Object doInBackground() throws Exception {
                        for (int i = 0; i <100 ; i++) {
                            circleProgressBar.setProgress(i+1);
                            circleProgressBar.setForegroundColor(ColorUtil.getByPercentage(i+1));
                            try {
                                Thread.sleep(100);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                        return null;
                    }
                }.execute();
            }
        });
    }
}



