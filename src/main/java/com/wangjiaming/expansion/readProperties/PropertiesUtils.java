package com.wangjiaming.expansion.readProperties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PropertyResourceBundle;
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

    public static String getProperties(String propertiesName, String key) {
        ResourceBundle rb = ResourceBundle.getBundle(propertiesName);
        try {
            return rb.getString(key);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getPropertiesByPath(String path, String key) {
        String proFilePath = path;
        String value=null;
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(proFilePath));
            ResourceBundle rb = new PropertyResourceBundle(inputStream);
            value= rb.getString(key);
            inputStream.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return value;

    }

}
