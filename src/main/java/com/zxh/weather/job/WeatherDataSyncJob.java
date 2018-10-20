package com.zxh.weather.job;

import com.zxh.weather.controller.WeatherDateController;
import com.zxh.weather.service.CityDateService;
import com.zxh.weather.service.WeatherDateService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.core.QuartzScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author zxh
 * @Title: WeatherDataSyncJob
 * @ProjectName weather
 * @Description: TODO
 * @date 2018/10/1718:05
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {
    @Autowired
    private WeatherDateController weatherDateController;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("WeatherDataSyncJob ");
        try {
            weatherDateController.syncWeatherDateById();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
