package com.expansion.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @projectName:expansion-utils
 * @packageName:com.expansion.change.date
 * @authorName:wangjiaming
 * @createDate:2019-05-20
 * @editor:IntelliJ IDEA
 * @other:日期转换类
 **/
public class DateUtils {

    public static Date strChangeDate(String strDate, String formatStr) {
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        try {
            Date date = (Date) format.parse(strDate);
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    public static String getFormateDate(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }

    public static void main(String[] args) {
       Date test= DateUtils.strChangeDate("2019-08-29 9:30:00","yyyy-MM-dd HH:mm:ss");
        System.out.println(System.currentTimeMillis()-test.getTime()%(1000 * 24 * 60 * 60)/(1000 * 60 * 60));
    }

}
