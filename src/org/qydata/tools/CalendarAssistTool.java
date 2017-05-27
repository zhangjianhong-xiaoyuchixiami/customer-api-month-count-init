package org.qydata.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by jonhn on 2017/3/8.
 */
public class CalendarAssistTool {


    /**
     * 取得当前时间的上一个月份第一天
     * @return
     */
    public static String getCurrentDateLastMonthFirstDay(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        String firstDay = sdf.format(calendar.getTime());
        return firstDay;
    }

    /**
     * 取得当前时间的上一个月份最后一天
     * @return
     */
    public static String getCurrentDateLastMonthEndDay(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,0);
        String lastDay  = sdf.format(calendar.getTime());
        return lastDay ;
    }

    /**
     * 取得当前时间的上一个月份是某年某月
     * @return
     */
    public static String getCurrentDateLastMonth() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        return year +"-"+ month;
    }

    /**
     * 取得当前时间的上一个月份的年份
     * @return
     */
    public static int getCurrentDateLastMonthYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        return year ;
    }

    /**
     * 取得当前时间的上一个月份的月份
     * @return
     */
    public static int getCurrentDateLastMonthMonth() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        return month;
    }

    public static void main(String[] args) {
        System.out.println(getCurrentDateLastMonthYear());
        System.out.println(getCurrentDateLastMonthMonth());
    }

}
