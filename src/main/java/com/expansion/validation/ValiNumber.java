package com.expansion.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @projectName:expansion-utils
 * @packageName:com.expansion.validation
 * @authorName:wangjiaming
 * @createDate:2019-07-06
 * @editor:IntelliJ IDEA
 * @other:
 **/
public class ValiNumber {

    public static Boolean isNumber(String str){
        Pattern pattern = Pattern.compile("^-?\\d+\\.?\\d*$");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

}
