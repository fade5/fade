package com.zxh.weather.service.impl;

import com.zxh.weather.service.CityDateService;
import com.zxh.weather.utils.XmlBuilder;
import com.zxh.weather.vo.City;
import com.zxh.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.List;

/**
 * @author zxh
 * @Title: CityDateServicceImpl
 * @ProjectName weather
 * @Description: TODO
 * @date 2018/10/1813:40
 */
@Service
public class CityDateServiceImpl implements CityDateService {
    @Override
    public  CityList getListCity() throws Exception {
        ClassPathResource classPathResource=new ClassPathResource("city.xml");
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(classPathResource.getInputStream(),"utf-8"));
        StringBuffer str =new StringBuffer();
        String line="";
        while((line=bufferedReader.readLine())!=null){
            str.append(line);
        }
        if (bufferedReader!=null){
            bufferedReader.close();
        }
        CityList cityList=(CityList)XmlBuilder.xmlToV(CityList.class,str.toString());
        return cityList;
    }
}
