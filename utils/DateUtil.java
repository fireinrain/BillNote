package utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/24.
 */
public class DateUtil {
    static long milliSecondsOfOneDay = 1000*60*24*60;
    
    public static java.sql.Date util2sql(java.util.Date date){
        /**
        * @Description:将util中的Date对象转化为sql中的Date
        * TODO
        * @param:[date]
        * @return:java.sql.Date
        * @author:liuzhaoyang
        * @date:2017/8/24-13:49
        */
        return new java.sql.Date(date.getTime());
    }

    public static Date today(){
        /**
        * @Description:获取今天，并且把时，分，秒和毫秒都置0.
         * * 因为通过日期控件获取到的日期，就是没有时分秒和毫秒的。
        * TODO
        * @param:[]
        * @return:Date
        * @author:liuzhaoyang
        * @date:2017/8/24-13:51
        */
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return calendar.getTime();

    }

    public static Date monthBegin(){
        /**
        * @Description:获取本月的第一天
        * TODO
        * @param:[]
        * @return:java.util.Date
        * @date:2017/8/24-13:56
        */
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DATE,1);


        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);

        return calendar.getTime();
    }

    public static Date monthEnd(){
        /**
        * @Description:获取月末的一天的UNIX时间戳
        * TODO
        * @param:[]
        * @return:java.util.Date
        * @date:2017/8/24-13:59
        */
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);

        calendar.set(Calendar.DATE,1);
        /*
        这里我们不能直接获取一个月的月末
        可以先获得这个月的一号，然后在增加一个月的时间
        这样就到了下一个月的一号，然后我们在调回上一天，就是我们
        需要的上个月的月末了
         */
        calendar.add(Calendar.MONTH,1);
        calendar.add(Calendar.DATE,-1);

        return calendar.getTime();
    }

    public static int thisMonthTotalDay(){
        //计算这个月有多少天
        long lastDayMilliSeconds = monthEnd().getTime();
        long firstDayMilliSeconds= monthBegin().getTime();

        return (int)((lastDayMilliSeconds-firstDayMilliSeconds)/milliSecondsOfOneDay)+1;
    }

    //当前月还剩多少天
    public static int thisMonthLeftDay(){
        long lastDayMilliSeconds = monthEnd().getTime();
        long todayMilliSeconds = today().getTime();

        return (int)((lastDayMilliSeconds-todayMilliSeconds)/milliSecondsOfOneDay)+1;
    }

    //测试
    public static void main(String[] args) {
        /*
        Thu Aug 24 12:00:00 CST 2017
        Tue Aug 01 00:00:00 CST 2017
        Thu Aug 31 12:00:00 CST 2017
        8(31-24)=7  但是这一天还没结束所以是8
        31

         */
        System.out.println(DateUtil.today());
        System.out.println(DateUtil.monthBegin());
        System.out.println(DateUtil.monthEnd());
        System.out.println(DateUtil.thisMonthLeftDay());
        System.out.println(DateUtil.thisMonthTotalDay());
    }


    
}
