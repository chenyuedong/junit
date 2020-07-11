package quartz;

import org.quartz.Trigger;
import org.quartz.TriggerListener;
import org.quartz.listeners.TriggerListenerSupport;

public class MyGlobalTriggerListener extends TriggerListenerSupport {

    @Override
    public String getName() {
        return "zsf";
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        super.triggerMisfired(trigger);
        System.out.println(trigger.getJobKey().getGroup()+"---"+trigger.getJobKey().getName());
    }
}