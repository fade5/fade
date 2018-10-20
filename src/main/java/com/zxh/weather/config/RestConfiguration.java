package com.zxh.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zxh
 * @Title: RestConfiguration
 * @ProjectName weather
 * @Description: RestTemplate bean 配置类 通过RestTemplateBuilder 生成
 * @date 2018/10/1610:52
 */
@Configuration
public class RestConfiguration {

    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    public  RestTemplate getRestTemplate(){
        return builder.build();
    }
}
