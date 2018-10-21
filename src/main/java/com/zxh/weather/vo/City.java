package com.zxh.weather.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author zxh
 * @Title: City
 * @ProjectName weather
 * @Description: city.xml  文件bean类 @XmlRootElement
 * @date 2018/10/1810:26
 */
@Setter
@Getter
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class City {
    @XmlAttribute(name="d1")
    private String cityId;
    @XmlAttribute(name="d2")
    private String cityName;
    @XmlAttribute(name="d3")
    private String cityCode;
    @XmlAttribute(name="d4")
    private String province;
}
