package com.expansion.postUtils;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.support.AllEncompassingFormHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName:expansion-utils
 * @packageName:com.expansion.postUtils
 * @authorName:wangjiaming
 * @createDate:2019-05-20
 * @editor:IntelliJ IDEA
 * @other:
 **/
public class PostUtils {

    public static String postJsonToUrl(String url, Map<String,String> headersMap, String jsonStr) {
        SimpleClientHttpRequestFactory httpRequestFactory = new SimpleClientHttpRequestFactory();
        httpRequestFactory.setReadTimeout(30000);
        httpRequestFactory.setConnectTimeout(5000);
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new ByteArrayHttpMessageConverter());
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        messageConverters.add(stringHttpMessageConverter);
        messageConverters.add(new ResourceHttpMessageConverter());
        messageConverters.add(new SourceHttpMessageConverter());
        messageConverters.add(new AllEncompassingFormHttpMessageConverter());
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
        restTemplate.setMessageConverters(messageConverters);
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        for (String key : headersMap.keySet()) {
            System.out.println(key+"|"+headersMap.get(key));
            headers.add(key,headersMap.get(key).toString());
        }
        HttpEntity<String> formEntity = new HttpEntity<String>(jsonStr, headers);
        String result = restTemplate.postForObject(url, formEntity, String.class);
        return result;
    }

    public static void main(String[] args) {
        Map<String,String> stringMap=new HashMap<String, String>();
        stringMap.put("WONDERS","946C67AE6F7F4EE693C9BBF4563DED21");
        String json="{\n" +
                "    \"orgCode\": \"34094558\",\n" +
                "    \"orgName\": \"广州市越秀区光塔街社区卫生服务中心\",\n" +
                "    \"orderType\":\"0\",\n" +
                "    \"idNumber\": \"440100000000000000\",\n" +
                "    \"name\": \"小明同学\",\n" +
                "    \"hospOutTradeNo\":\"001\",\n" +
                "    \"totalFee\": \"1\",\n" +
                "    \"cashFee\": \"1\",\n" +
                "    \"body\": \"诊查费\",\n" +
                "    \"payType\": \"1\",\n" +
                "    \"insuranceFee\": \"0\",\n" +
                "    \"serialNo\": \"\",\n" +
                "    \"orgNo\": \"\",\n" +
                "    \"gmtOutCreate\": \"2018-01-01 01:01:01\",\n" +
                "    \"billNo\": \"\"\n" +
                "}";
        PostUtils.postJsonToUrl("http://localhost:3737/external/wx/pushmessage",stringMap,json);
    }
}
