package com.zxh.weather.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author zxh
 * @Title: RestTemplateUtil
 * @ProjectName weather
 * @Description: TODO
 * @date 2018/10/1610:08
 */
public class RestTemplateUtil {

    private static RestTemplate restTemplate;
   //private RestTemplate restTemplate;
    /**
    　　* @Description: 远程访问uri 获取其返回值
    　　* @param uri 要访问的地址
    　　* @return String json字符串
    　　* @throws
    　　* @author zxh
    　　* @date 2018/10/18 10:41
    　　*/
    public static  String getForEntity(String uri){
       // String body=null;
        ResponseEntity<String>
                responseEntity=restTemplate.getForEntity(uri,String.class);
        String body=null;
        if(responseEntity.getStatusCodeValue()==200){
            body=responseEntity.getBody();
        }
        return body;
    }
}
