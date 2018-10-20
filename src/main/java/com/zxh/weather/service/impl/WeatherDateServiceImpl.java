package com.zxh.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxh.weather.bean.YmlConfig;
import com.zxh.weather.service.CityDateService;
import com.zxh.weather.service.WeatherDateService;
import com.zxh.weather.utils.StringUtils;
import com.zxh.weather.utils.XmlBuilder;
import com.zxh.weather.vo.CityList;
import com.zxh.weather.vo.Weather;
import com.zxh.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author zxh
 * @Title: WeatherDateServiceImpl
 * @ProjectName weather
 * @Description: TODO
 * @date 2018/10/1522:56
 */
@Service
@Slf4j
public class WeatherDateServiceImpl implements WeatherDateService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private YmlConfig ymlConfig;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private CityDateService cityDateService;
    /**
    　　* @Description: 通过id 进行获取天气信息
    　　* @param id
    　　* @return WeatherResponse
    　　* @throws
    　　* @author zxh
    　　* @date 2018/10/16 10:13
    　　*/
    @Override
    @Cacheable(value = "user", key = "#id", unless = "#result.data eq null")
    public WeatherResponse getWeatherDateById(String id)  {
        log.info("没有使用缓存");
        String url =ymlConfig.getWeatherUrl()+"?citykey="+id;
        return getForEntity(url);
    }
    /**
     　　* @Description: 通过name进行获取天气信息
     　　* @param id
     　　* @return WeatherResponse
     　　* @throws
     　　* @author zxh
     　　* @date 2018/10/16 10:13
     　　*/
    @Override
    @Cacheable(value = "user", key = "#name", unless = "#result.data eq null")
    public WeatherResponse getWeatherDareByName(String name) {
        log.info("没有使用缓存");
        String url=ymlConfig.getWeatherUrl()+"?city="+name;
        return getForEntity(url);
    }
    /**
    　　* @Description: 根据城市id 进行保存数据
    　　* @param
    　　* @return
    　　* @throws
    　　* @author zxh
    　　* @date 2018/10/18 13:51
    　　*/
    @Override
    public void syncWeatherDateById() {
        log.info("122");
        try {
            CityList cityList=cityDateService.getListCity();
            for (int i = 0; i < cityList.getCity().size(); i++) {
                saveWeatherDateById(cityList.getCity().get(i).getCityId());
                saveWeatherDateById(cityList.getCity().get(i).getCityName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @CachePut(value = "user", key = "#code" )
    ///@Cacheable(value = "user", key = "#id", unless = "#result.data eq null")
    public WeatherResponse saveWeatherDateById(String  code){
        log.info("正在存入缓存："+code);
        String url="";
        if(StringUtils.isNumeric(code)){
             url =ymlConfig.getWeatherUrl()+"?citykey="+code;
        }else {
             url=ymlConfig.getWeatherUrl()+"?city="+code;
        }

        return getForEntity(url);
    }
    /**
     　　* @Description:抽取通用方法
     　　* @param id
     　　* @return WeatherResponse
     　　* @throws
     　　* @author zxh
     　　* @date 2018/10/16 10:13
     　　*/
    private   WeatherResponse getForEntity(String url){
        //log.info("没有使用缓存");
        //restTemplate方法 获取url 返回的值
        ResponseEntity<String>
                responseEntity=restTemplate.getForEntity(url,String.class);
        String body=null;
        //判断是否返回成功
        if(responseEntity.getStatusCodeValue()==200){
            body=responseEntity.getBody();
        }
        //json 转对象 ObjectMapper springboot -start 内置对象
        ObjectMapper mapper=new ObjectMapper();
        WeatherResponse response =null;
        try {
            response=mapper.readValue(body, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
