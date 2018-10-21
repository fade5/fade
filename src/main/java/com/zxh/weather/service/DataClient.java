package com.zxh.weather.service;

import com.zxh.weather.vo.City;

import java.util.List;

/**
 * @author zxh
 * @Title: DataClient
 * @ProjectName weather
 * @Description: TODO
 * @date 2018/10/2118:57
 */
public interface DataClient {
    List<City> listCity();
}
