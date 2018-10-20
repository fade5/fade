package com.zxh.weather.service;

import com.zxh.weather.vo.WeatherResponse;
import org.springframework.stereotype.Service;

/**
 * @author zxh
 * @Title: WeatherResponseService
 * @ProjectName weather
 * @Description: TODO
 * @date 2018/10/1522:51
//<editor-fold desc="Description">
 */
//</editor-fold>
public interface WeatherDateService {
    public WeatherResponse getWeatherDateById(String id);
    public WeatherResponse getWeatherDareByName(String name);
    public void syncWeatherDateById();

    public WeatherResponse saveWeatherDateById(String name);

}
