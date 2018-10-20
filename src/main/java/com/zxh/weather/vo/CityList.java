package com.zxh.weather.vo;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author zxh
 * @Title: CityList
 * @ProjectName weather
 * @Description: TODO
 * @date 2018/10/1810:35
 */
@Setter
@Getter
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {
    @XmlElement(name = "d")
    private List<City> city;
}
