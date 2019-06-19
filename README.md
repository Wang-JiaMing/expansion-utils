# 扩展工具类
- author:wangjiaming
- lastUpdateDate:20190528
- version:2.1
## 日期转换工具类
#### 1. 字符日期转Date类型
- com.expansion.date.DateUtils
- Date strChangeDate(String strDate, String formatStr)<br>

- 例子
> - Date d=DateUtils.strChangeDate("2019-01-01","yyyy-MM-dd");


#### 2. 根据格式获取当前时间
- com.expansion.date.DateUtils
- String getFormateDate(String format)<br>

- 例子
> - String now=DateUtils.getFormateDate("yyyy-MM-dd");



## 类工具类
#### 1. 根据对象转换成map
- com.expansion.object.ObjectUtils
- Map<String, String> ObjectChangeMap(Object o)<br>

- 例子
> - Map<String,String> objectMap=ObjectUtils.ObjectChangeMap(Object);
#### 2. 去掉类属性空格
- com.expansion.object.ObjectUtils
- Object trimMethods(Object o)<br>
- 例子
> - Student student=(Student)ObjectUtils.trimMethods(student);

## Http请求工具类
#### 1.post json到指定接口
- com.expansion.postUtils.PostUtils
- String postJsonToUrl(String url, Map<String,String> headersMap, String jsonStr) <br>

- 例子
> - String status=PostUtils.postJsonToUrl("http://xxxx/xxx",null,"{\"name\":\"test\"}");

## 读取Properties工具类
#### 1. 读取工程内部properties
- com.expansion.readProperties.PropertiesUtils
- String getProperties(String propertiesName, String key)<br>

- 例子
> - String value=PropertiesUtils.getProperties("application","post");

#### 1. 读取某路径下properties
- com.expansion.readProperties.PropertiesUtils
- String getPropertiesByPath(String propertiesName, String key)<br>

- 例子
> - String value=PropertiesUtils.getPropertiesByPath("c:/application.properties","post");



## 字符串工具类
#### 1. 生成任意长度随机字符串
- com.expansion.StringUtils.StringUtils
- String generateNonceStr(Integer length)<br>
> 入参1：任意字符的长度，如果传入null，即为32位

- 例子：

> - String ranStr=StringUtils.generateNonceStr(1);
> - String ranStr1=StringUtils.generateNonceStr(null);



## 类校验工具
#### 1. 类非空校验    
- com.expansion.validation.ValiClazz
- boolean ClazzNotEmtry(Object o, List<String> notValidationMethods)<br>
>入参1:需要校验的对象;<br>
>入参2:允许为空的对象get方法名
- 例子
> - boolean status=ValiClazz.ClazzNotEmtry(Object,notValidationMethods);

#### 2. 类方法值域判断
- com.expansion.validation.ValiClazz
- boolean ClazzMethodRange(Object o, String method, List<String> range)<br>
> 入参1:等待校验类<br>
> 入参2:等待校验类中get方法<br>
> 入参3:值域的List



## 日期校验校验  
#### 1. 校验日期是否符合规定格式
- com.expansion.validation.ValiDate
- boolean dateFormat(String str,String formatStr)<br>
> 入参1:等待校验的日期字符串
> 入参2:规定的日期格式；例如:"yyyy-MM-dd"
