package com.zxh.weather.controller;

import com.zxh.weather.service.CityDateService;
import com.zxh.weather.service.WeatherDateService;
import com.zxh.weather.vo.CityList;
import com.zxh.weather.vo.WeatherResponse;
import com.zxh.weather.bean.YmlConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxh
 * @Title: WeatherDateController
 * @ProjectName weather
 * @Description: TODO
 * @date 2018/10/1610:22
 */
@Slf4j
@Api("WeatherDateController相关的api")
@RestController()
@RequestMapping("/user")
public class WeatherDateController {

    @Autowired
    private WeatherDateService weatherDateService;
    @Autowired
    private CityDateService cityDateService;
    /**
    　　* @Description: 通过城市id查找 天气信息
    　　* @param id  城市id
    　　* @return  String 字符串
    　　* @throws
    　　* @author zxh
    　　* @date 2018/10/16 10:47
    　　*/
    @ApiOperation(value = "通过城市id查找天气信息", notes = "查询远程城市天气信息")
    @ApiImplicitParam(name = "cityId", value = "城市ID", paramType = "path", required = true, dataType = "String")
    @GetMapping("/cityId/{cityId}")
    public  WeatherResponse getWeatherDateById(@PathVariable("cityId") String id){
        WeatherResponse weatherResponse=weatherDateService.getWeatherDateById(id);

        return weatherResponse;
    }

    @GetMapping("/cityName/{cityName}")
    public  WeatherResponse getWeatherDateByName(@PathVariable("cityName")String name){
        WeatherResponse weatherResponse=weatherDateService.getWeatherDareByName(name);

        return weatherResponse;
    }

    @GetMapping("/city/batchInsert")
    public String syncWeatherDateById() {
        //log.info("122");
        try {
            CityList cityList=cityDateService.getListCity();
            for (int i = 0; i < cityList.getCity().size(); i++) {
                weatherDateService.saveWeatherDateById(cityList.getCity().get(i).getCityId());
                weatherDateService.saveWeatherDateById(cityList.getCity().get(i).getCityName());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "批量导入失败！！";
        }
        return "批量导入成功！！";
    }
}
