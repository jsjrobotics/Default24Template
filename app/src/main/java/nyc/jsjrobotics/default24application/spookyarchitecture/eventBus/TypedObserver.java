package nyc.jsjrobotics.default24application.spookyarchitecture.eventBus;

import java.util.Observable;
import java.util.Observer;
import java.util.function.BiConsumer;

public final class TypedObserver<T> implements Observer{
    private final BiConsumer<Observable, T> callback;
    private final Class<T> dataType;
    private final boolean runOnUiThread;

    private TypedObserver(Class<T> dataClass,
                          BiConsumer<Observable, T> update,
                          final boolean runOnUiThread) {
        callback = update;
        dataType = dataClass;
        this.runOnUiThread = runOnUiThread;
    }

    @Override
    public final void update(final Observable o, final Object arg) {
        if (!dataType.isAssignableFrom(arg.getClass())){
            throw new AssertionError("Incompatible type passed to observer");
        }
        callback.accept(o, dataType.cast(arg));
    }

    public static <V> TypedObserver<V> create(final Class<V> clickEventClass,
                                              final BiConsumer<Observable, V> biConsumer,
                                              final boolean runOnUiThread) {
        return new TypedObserver<>(clickEventClass, biConsumer, runOnUiThread);
    }

    public boolean runOnUiThread() {
        return runOnUiThread;
    }
}
