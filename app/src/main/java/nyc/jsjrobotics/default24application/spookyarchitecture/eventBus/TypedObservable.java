package nyc.jsjrobotics.default24application.spookyarchitecture.eventBus;

import android.util.Log;
import java.util.Observable;
import java.util.function.Consumer;

public class TypedObservable<T> extends Observable{
    private static final String TAG = "TypedObservable";
    private final Class<T> classType;
    private final Consumer<Exception> errorListener;
    private Object lastNotification;

    private TypedObservable(final Class<T> type, final Consumer<Exception> onError) {
        classType = type;
        errorListener = onError;
    }

    public static <V> TypedObservable<V> create(final Class<V> clickEventClass) {
        return new TypedObservable<>(clickEventClass, error -> { Log.e(TAG,error.getMessage());});
    }

    public static <V> TypedObservable<V> create(final Class<V> clickEventClass, Consumer<Exception> onError) {
        return new TypedObservable<>(clickEventClass, onError);
    }

    public void onError(final Exception e) {
        errorListener.accept(e);
    }

    @Override public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public void notifyObservers(Object arg) {
        if (!classType.isAssignableFrom(arg.getClass())) {
            throw new IllegalArgumentException("Invalid type");
        }
        if (lastNotification == null) {
            setChanged();
        } else if (!lastNotification.equals(arg)){
            setChanged();
        }
        super.notifyObservers(arg);
        lastNotification = arg;
    }
}
