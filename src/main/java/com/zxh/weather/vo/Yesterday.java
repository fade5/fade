package com.zxh.weather.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zxh
 * @Title: Yesterday
 * @ProjectName weather
 * @Description: {"yesterday":{"date":"14日星期日","high":"高温 20℃","fx":"南风","low":"低温 10℃","fl":"<![CDATA[<3级]]>","type":"多云"}
 * @date 2018/10/1522:39
 */
@Getter
@Setter
@ToString
public class Yesterday implements Serializable {

    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;

}
