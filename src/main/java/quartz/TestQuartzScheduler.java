package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

public class TestQuartzScheduler {


    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.getListenerManager().addTriggerListener(new MyGlobalTriggerListener());
        scheduler.start();
        JobDetail jobDetail = JobBuilder.newJob(ZSFJob1.class)
                .withIdentity("job", "zsf").build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "zsf")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?"))
                .build();
        scheduler.scheduleJob(jobDetail,trigger);
        System.out.println("end---");
        TimeUnit.MINUTES.sleep(2);
        scheduler.shutdown();
    }
}
