package com.zxh.weather.vo;


/*
{"data":
{"yesterday":{"date":"14日星期日","high":"高温 20℃","fx":"南风","low":"低温 10℃","fl":"<![CDATA[<3级]]>","type":"多云"},
"city":"北京","aqi":"175",
"forecast":[{"date":"15日星期一","high":"高温 17℃","fengli":"<![CDATA[<3级]]>","low":"低温 11℃","fengxiang":"北风","type":"小雨"},
{"date":"16日星期二","high":"高温 17℃","fengli":"<![CDATA[<3级]]>","low":"低温 7℃","fengxiang":"东北风","type":"多云"},
{"date":"17日星期三","high":"高温 17℃","fengli":"<![CDATA[<3级]]>","low":"低温 5℃","fengxiang":"无持续风向","type":"晴"},
{"date":"18日星期四","high":"高温 18℃","fengli":"<![CDATA[<3级]]>","low":"低温 6℃","fengxiang":"南风","type":"多云"},
{"date":"19日星期五","high":"高温 18℃","fengli":"<![CDATA[<3级]]>","low":"低温 7℃","fengxiang":"西南风","type":"多云"}],
"ganmao":"天气较凉，较易发生感冒，请适当增加衣服。体质较弱的朋友尤其应该注意防护。","wendu":"12"},
"status":1000,"desc":"OK"}
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author zxh
 * @Title: Weather
 * @ProjectName weather
 * @Description:  vo类  weather
 * @date 2018/10/15 22:17
 */
@Getter
@Setter
@ToString
public class Weather implements Serializable {
    private  String city;
    private  String aqi;
    private  String ganmao;
    private  Integer wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;

}
