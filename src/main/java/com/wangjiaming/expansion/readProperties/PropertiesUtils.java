package com.wangjiaming.expansion.readProperties;

import java.util.ResourceBundle;

/**
 * @projectName:expansion-utils
 * @packageName:com.wangjiaming.expansion.readProperties
 * @authorName:wangjiaming
 * @createDate:2019-05-08
 * @editor:IntelliJ IDEA
 * @other:
 **/
public class PropertiesUtils {

    public static String getProperties(String propertiesName,String key) {
        ResourceBundle rb = ResourceBundle.getBundle(propertiesName);
        return rb.getString(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertiesUtils.getProperties("application","logging.level.com.wonders.external"));
    }


}
