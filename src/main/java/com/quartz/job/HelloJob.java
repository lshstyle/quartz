package com.quartz.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

public class HelloJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Execute Time is :" + sf.format(date));
		System.out.println("Hello World !");
		JobKey jobKey = context.getJobDetail().getKey();
		TriggerKey triggerKey = context.getTrigger().getKey();
		System.out.println("my job message:" + jobKey.getName() + "group:" + jobKey.getGroup());
		System.out.println("my trigger message:" + triggerKey.getName() + "group:" + triggerKey.getGroup());
		
		String jobMsg = context.getJobDetail().getJobDataMap().getString("message");
		float jobValue = context.getJobDetail().getJobDataMap().getFloat("value");
		
		System.out.println(jobMsg + jobValue);
		
		String triggerMsg = context.getTrigger().getJobDataMap().getString("message");
		double triggerValue = context.getTrigger().getJobDataMap().getDouble("value");
		System.out.println(triggerMsg + triggerValue);
		
	}
	
	
}
