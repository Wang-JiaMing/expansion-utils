package com.expansion.change.date;

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

    public static void main(String[] args) {
        System.out.println(DateUtils.strChangeDate("2019-09-01","yyyy-MM-dd"));
    }

}
