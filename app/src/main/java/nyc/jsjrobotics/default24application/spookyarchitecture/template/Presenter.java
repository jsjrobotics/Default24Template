package nyc.jsjrobotics.default24application.spookyarchitecture.template;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleRegistry;
import javax.inject.Singleton;

/**
 * A Presenter persists across activities and fragments.
 * Hence it should only use the Application Context.
 * This class should expose observables for state changes which are bound to in an activity or fragment
 * All activity or fragments that use the same instance will share Lifecycle Call backs
 */
@Singleton
public interface Presenter extends LifecycleObserver {

    void registerLifecycle(LifecycleRegistry lifecycle);
    void unregisterLifecycle(LifecycleRegistry lifecycle);

}
