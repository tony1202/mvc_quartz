package com.tony.controller;

import com.tony.User;
import com.tony.quartz.QuartzJob;
import com.tony.quartz.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String test(String jName,String tName){

        quartzManager.addJob(jName,tName, QuartzJob.class,"0/5 * * * * ? 2019");

        return "ok";
    }


    @RequestMapping("/test2")
    @ResponseBody
    public String test2(){
        quartzManager.getjobs();

        return "ok";
    }

    @RequestMapping("/test1")
    @ResponseBody
    public String test1(@RequestBody User[] users){
        System.out.println(users.length);
        return "ok";
    }
}
