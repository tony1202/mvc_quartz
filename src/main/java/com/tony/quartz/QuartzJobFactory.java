package com.tony.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJobFactory implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("定时运行");
        ScheduleJob scheduleJob  = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        System.out.println("正在运行 - "+scheduleJob.getJobName());
    }
}