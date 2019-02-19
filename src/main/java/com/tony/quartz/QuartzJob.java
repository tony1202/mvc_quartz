package com.tony.quartz;

import com.tony.service.UserService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

@Component
public class QuartzJob extends QuartzJobBean {

    @Autowired
    private UserService userService;

    //    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        System.out.println("定时运行");
//        ScheduleJob scheduleJob  = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
//        userService.showDate("hello");
//    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("定时运行");
        String name = context.getJobDetail().getKey().getName();
        userService.showDate(name);
    }
}