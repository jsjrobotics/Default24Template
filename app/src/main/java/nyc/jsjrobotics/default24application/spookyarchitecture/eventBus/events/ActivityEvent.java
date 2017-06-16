package nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.events;

import android.app.Activity;
import java.util.function.Consumer;
import nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.EventTypes;

public class ActivityEvent extends DefaultEvent<EventTypes.ActivityEvent, Consumer<Activity>> {
    private final EventTypes.ActivityEvent type;
    private final Consumer<Activity> data;

    public ActivityEvent(final EventTypes.ActivityEvent type, final Consumer<Activity> data) {
        this.type = type;
        this.data = data;
    }

    @Override public EventTypes.ActivityEvent getType() {
        return type;
    }

    @Override public Consumer<Activity> getData() {
        return data;
    }
}
