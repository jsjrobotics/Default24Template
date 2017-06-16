package nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.events;

public abstract class DefaultEvent<T,D> {
    public abstract T getType();
    public abstract D getData();
}
