package com.quartz.scheduler;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.quartz.job.HelloJob;

public class helloScheduler {

	public static void main(String[] args) throws SchedulerException {
		// 创建一个JobDetail实例，将该实例与HelloJob class绑定
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group1")
				.usingJobData("message", "我是一个jobDetail").usingJobData("value", 1.23f).build();

		// 创建一个Trigger实例，定义该job立即执行，并且每隔两秒执行一次
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").usingJobData("message", "我是一个trigger").usingJobData("value", 1.43).startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();

		SchedulerFactory scfa = new StdSchedulerFactory();
		Scheduler s = scfa.getScheduler();
		s.start();
		s.scheduleJob(jobDetail, trigger);
	}
}
