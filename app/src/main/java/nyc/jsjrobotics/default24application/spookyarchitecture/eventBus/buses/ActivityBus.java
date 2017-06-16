package nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.buses;

import javax.inject.Singleton;
import nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.events.ActivityEvent;

@Singleton
public class ActivityBus extends AbstractEventBus<ActivityEvent>{
    public ActivityBus() {
        super(ActivityEvent.class);
    }
}
