package com.brianway.learning.java.base.quartz;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JobScheduler {


    private String jobClass;


    public JobDetail createJobDetail() throws SchedulerException {
        JobDetail result = JobBuilder.newJob(QuartzJob.class).withIdentity("quartz_job").build();
        result.getJobDataMap().put("job", new SpringJob());
        return result;

    }

    private CronTrigger createTrigger(String cron) {
        return (CronTrigger) TriggerBuilder.newTrigger().withIdentity("quartz_job").withSchedule(CronScheduleBuilder.cronSchedule(cron).withMisfireHandlingInstructionDoNothing()).build();
    }

    public void startScheduler(String cron) throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail detail = createJobDetail();
        scheduler.scheduleJob(detail, createTrigger(cron));
        scheduler.start();
    }

    public static void main(String[] args) throws SchedulerException {
        String corn = "0/5 * * * * ?";
        JobScheduler scheduler = new JobScheduler();
        scheduler.startScheduler(corn);
    }
}
