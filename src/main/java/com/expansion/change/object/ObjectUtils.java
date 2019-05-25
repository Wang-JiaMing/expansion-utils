package com.expansion.change.object;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName:hrm-parent
 * @packageName:com.econ.hrm.utils
 * @authorName:wangjiaming
 * @createDate:2019-05-25
 * @editor:IntelliJ IDEA
 * @other:对象工具类
 **/
public class ObjectUtils {

    /**
     * 去对象化
     *
     * @param o
     * @return
     */
    public static Map<String, String> ObjectChangeMap(Object o) {
        Map<String, String> params = new HashMap<String, String>();
        Class<?> clazz = o.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            StringBuffer dataFiledName = new StringBuffer();
            String[] filedName = field.toString().split(" ")[2].split("\\.");
            char[] charFiledName = filedName[filedName.length - 1].toCharArray();
            for (int i = 0; i < charFiledName.length; i++) {
                if (!Character.isLowerCase(charFiledName[i])) {
                    dataFiledName.append("_" + (char) (charFiledName[i] + 32));
                } else {
                    dataFiledName.append(charFiledName[i]);
                }
            }
            String tmpGetName = filedName[filedName.length - 1];
            String getNameMethod = "get" + (char) (tmpGetName.substring(0, 1).toCharArray()[0] - 32) + filedName[filedName.length - 1].substring(1, tmpGetName.length());
            try {
                Method methods = clazz.getDeclaredMethod(getNameMethod, null);
                String value = String.valueOf(methods.invoke(o));
                if (value != null && !"".equals(value)) {
                    params.put(dataFiledName.toString(), value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return params;
    }

}
