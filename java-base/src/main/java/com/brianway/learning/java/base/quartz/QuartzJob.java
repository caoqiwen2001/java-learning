package com.brianway.learning.java.base.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author caoqiwen
 * 实现job接口 并入到该类中
 */
public class QuartzJob implements Job {

    private LiteJob job;

    public LiteJob getJob() {
        return job;
    }

    public void setJob(LiteJob job) {
        this.job = job;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if (job instanceof SpringJob) {
            job.execute();
        }
    }
}
