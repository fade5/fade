package com.zxh.weather.config;

import com.zxh.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zxh
 * @Title: QuaetzConfigturaion
 * @ProjectName weather
 * @Description: Quaetz 配置类  包括JobDetail  Trigger 两个bean
 * @date 2018/10/1718:10
 */
@Configuration
public class QuaetzConfigturaion {

    @Bean
    public JobDetail getJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob").storeDurably().build();
    }
    @Bean
    public Trigger getTrigger(){
        SimpleScheduleBuilder simpleScheduleBuilder=
                SimpleScheduleBuilder.simpleSchedule().
                        withIntervalInSeconds(30).repeatForever();
        return TriggerBuilder.newTrigger().withIdentity("weatherDataSyncTrigger").forJob(getJobDetail()).withSchedule(simpleScheduleBuilder).build();
    }
}
