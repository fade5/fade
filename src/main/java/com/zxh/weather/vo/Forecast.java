package com.zxh.weather.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zxh
 * @Title: Forecast
 * @ProjectName weather
 * @Description:
 * "forecast":[{"date":"15日星期一","high":"高温 17℃","fengli":"<![CDATA[<3级]]>","low":"低温 11℃","fengxiang":"北风","type":"小雨"},
 * {"date":"16日星期二","high":"高温 17℃","fengli":"<![CDATA[<3级]]>","low":"低温 7℃","fengxiang":"东北风","type":"多云"},
 * {"date":"17日星期三","high":"高温 17℃","fengli":"<![CDATA[<3级]]>","low":"低温 5℃","fengxiang":"无持续风向","type":"晴"},
 * {"date":"18日星期四","high":"高温 18℃","fengli":"<![CDATA[<3级]]>","low":"低温 6℃","fengxiang":"南风","type":"多云"},
 * {"date":"19日星期五","high":"高温 18℃","fengli":"<![CDATA[<3级]]>","low":"低温 7℃","fengxiang":"西南风","type":"多云"}],
 * @date 2018/10/1522:41
 */
@Getter
@Setter
@ToString
public class Forecast implements Serializable {

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}
