package nyc.jsjrobotics.default24application.spookyarchitecture.template;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.os.Bundle;
import android.support.annotation.Nullable;

public abstract class DefaultActivity extends Activity implements LifecycleRegistryOwner {
    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
    protected abstract void registerLifecycles();
    protected abstract void unregisterLifecycles();

    @Override protected void onCreate(@Nullable final Bundle savedInstanceState) {
        Application.inject(this);
        super.onCreate(savedInstanceState);
        registerLifecycles();
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);

    }

    @Override public void onStart() {
        super.onStart();
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @Override public void onResume() {
        super.onResume();
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override public void onPause() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        super.onPause();
    }

    @Override public void onStop() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        super.onStop();
    }

    @Override public void onDestroy() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        unregisterLifecycles();
        super.onDestroy();
    }

    @Override public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }
}
