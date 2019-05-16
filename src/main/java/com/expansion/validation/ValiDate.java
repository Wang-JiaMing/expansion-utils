package com.expansion.validation;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @projectName:expansion-utils
 * @packageName:com.wangjiaming.expansion.validation
 * @authorName:wangjiaming
 * @createDate:2019-05-08
 * @editor:IntelliJ IDEA
 * @other:
 **/
public class ValiDate {
    /**
     * yyyyMMdd日期格式验证
     * @param str 需校验的日期字符串
     * @return 验证成功为true，其他为false
     * @throws Exception
     */
    public static boolean dateFormat(String str,String formatStr){
        SimpleDateFormat format=new SimpleDateFormat(formatStr);
        try{
            Date date=(Date) format.parse(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
