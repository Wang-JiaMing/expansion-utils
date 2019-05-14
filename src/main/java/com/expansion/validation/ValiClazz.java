package com.expansion.validation;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @projectName:expansion-utils
 * @packageName:com.wangjiaming.expansion.validation
 * @authorName:wangjiaming
 * @createDate:2018-12-27
 * @editor:IntelliJ IDEA
 * @other:wangjiaming
 **/
public class ValiClazz {

    /**
     * 判断对象属性值是否存在为空
     * @param o                    对象
     * @param notValidationMethods 排除不校验的get方法名
     * @return 全满足非空返回true,否者false
     */
    public static boolean ClazzNotEmtry(Object o, List<String> notValidationMethods) throws Exception {
        Class<?> clazz = o.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().indexOf("get") != -1 && !notValidationMethods.contains(methods[i].getName())) {
                String value = String.valueOf(methods[i].invoke(o));
                if (value.equals("null") || "".equals(value)) {
                    System.out.println(methods[i].getName() + "方法存在空值，校验失败");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 遍历对象所有入参去两边空格
     * @param o
     * @return
     */
    public static Object trimMethods(Object o) throws Exception{
        Class<?> clazz=o.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for(int i=0;i<methods.length;i++){
            if(methods[i].getName().indexOf("get")!=-1){
                String methodsName=methods[i].getName().split("get")[1];
                String value = String.valueOf(methods[i].invoke(o)).trim();
                for(int j=0;j<methods.length;j++){
                    if(methods[j].getName().indexOf("set"+methodsName)!=-1){
                        methods[j].setAccessible(true);
                        methods[j].invoke(o,value);
                        break;
                    }
                }
            }
        }
        return o;
    }

    /**
     * 值域判断
     * @param o 需校验的对象
     * @param method 传入等等校验的get方法
     * @param range 值域判断范围
     * @return 存在返回true，不存在范围false
     * @throws Exception
     */
    public static boolean ClazzMethodRange(Object o, String method, List<String> range) throws Exception {
        Class<?> clazz = o.getClass();
        Method method1 = clazz.getMethod(method);
        String value=String.valueOf(method1.invoke(o));
        return range.contains(value);
    }



}
