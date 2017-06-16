package nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.buses;

import javax.inject.Singleton;
import nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.events.UiEvent;

@Singleton
public class UiEventBus extends AbstractEventBus<UiEvent> {
    public UiEventBus() {
        super(UiEvent.class);
    }
}
