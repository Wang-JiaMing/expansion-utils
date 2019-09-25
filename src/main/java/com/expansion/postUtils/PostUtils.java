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

        System.out.println(PostUtils.postJsonToUrl("http://www.baidu.com",stringMap,null));
    }
}
