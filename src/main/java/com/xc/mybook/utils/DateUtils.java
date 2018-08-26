package com.xc.mybook.utils;

import org.apache.commons.lang.time.DateFormatUtils;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 日期格式工具类
 *
 */
public class DateUtils {

    private static Date date = new Date();

    public static Timestamp getSqlTimeStamp(){
        return new Timestamp(date.getTime());
    }

    public static String getYear(){
        return DateFormatUtils.format(date,"yyyy");
//        return String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
    }

    public static String getMonth(){
        String monthStr = DateFormatUtils.format(date,"MM");
        if(monthStr.startsWith("0")){
            return monthStr.substring(1);
        }else{
            return monthStr;
        }
//        return DateFormatUtils.format(date,"MM");
    }

    public static String getDay(){
        return DateFormatUtils.format(date,"dd");
    }

    public static String getYYYYMMDD(){
        return DateFormatUtils.format(date, "yyyyMMdd");

    }


    public static String getYYYYDOTMMDOTDD(){
        StringBuilder sb = new StringBuilder();
        sb.append(getYear());
        sb.append(".");
        sb.append(getMonth());
        sb.append(".");
        sb.append(getDay());
        return sb.toString();
    }
}
