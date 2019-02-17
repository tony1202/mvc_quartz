package com.tony.controller;

import com.tony.quartz.QuartzJobFactory;
import com.tony.quartz.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuartzController {

    @Autowired
    private QuartzManager quartzManager;
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){

        quartzManager.addJob("tony","trigger", QuartzJobFactory.class,"0/30 * 22 14 2 ? 2019");

        return "ok";
    }
}
