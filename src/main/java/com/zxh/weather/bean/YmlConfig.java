package com.zxh.weather.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author zxh
 * @Title: YmlConfig
 * @ProjectName weather
 * @Description: yml 文件配置文件
 * @date 2018/10/16 13:56
 */
@Component
@ConfigurationProperties(prefix = "myyml")
@Setter
@Getter
@ToString
public class YmlConfig  implements Serializable {
    private String weatherUrl;
}
