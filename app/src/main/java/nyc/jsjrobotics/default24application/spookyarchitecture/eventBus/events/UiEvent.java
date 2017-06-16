package nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.events;

import nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.EventTypes;

public class UiEvent<D> extends DefaultEvent<EventTypes.UiEvent, D> {
    private final EventTypes.UiEvent type;
    private final D data;

    public UiEvent(final EventTypes.UiEvent type, final D data) {
        this.type = type;
        this.data = data;
    }

    @Override public EventTypes.UiEvent getType() {
        return type;
    }

    @Override public D getData() {
        return data;
    }
}
