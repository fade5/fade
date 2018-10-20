package com.zxh.weather.service;

import com.zxh.weather.vo.City;
import com.zxh.weather.vo.CityList;

import java.util.List;

/**
 * @author zxh
 * @Title: CityDateServicce
 * @ProjectName weather
 * @Description: TODO
 * @date 2018/10/1813:39
 */
public interface CityDateService {
    CityList getListCity() throws Exception;
}
