package nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.buses;

import android.os.Handler;
import android.os.Looper;
import nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.TypedObserver;
import nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.TypedObservable;
import nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.events.DefaultEvent;

public abstract class AbstractEventBus<T extends DefaultEvent> {
    protected final TypedObservable<T> backgroundObservable;
    protected final TypedObservable<T> uiObservable;
    private final Handler handler;

    protected AbstractEventBus(Class<T> dataType) {
        backgroundObservable = TypedObservable.create(dataType);
        uiObservable = TypedObservable.create(dataType);
        handler = new Handler(Looper.getMainLooper());

    }

    public final void post(final T event ) {
        handler.post(() -> uiObservable.notifyObservers(event));
        Thread t = new Thread(() -> {
            backgroundObservable.notifyObservers(event);
        });
        t.start();

    };

    public final <U extends T> void addObserver(final TypedObserver<U> observer) {
        if (observer.runOnUiThread()) {
            uiObservable.addObserver(observer);
        } else {
            backgroundObservable.addObserver(observer);
        }
    }

    public final <U extends T> void deleteObserver(final TypedObserver<U> observer) {
        backgroundObservable.deleteObserver(observer);
        uiObservable.deleteObserver(observer);
    }
}
