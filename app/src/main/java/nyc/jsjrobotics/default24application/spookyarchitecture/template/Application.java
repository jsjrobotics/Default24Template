package nyc.jsjrobotics.default24application.spookyarchitecture.template;

import android.app.Activity;
import android.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasFragmentInjector;
import javax.inject.Inject;
import nyc.jsjrobotics.default24application.spookyarchitecture.dagger.ApplicationComponent;
import nyc.jsjrobotics.default24application.spookyarchitecture.dagger.DaggerApplicationComponent;

public class Application extends android.app.Application implements HasActivityInjector,
                                                                    HasFragmentInjector {
    private ApplicationComponent injector;
    private static Application instance;

    @Inject DispatchingAndroidInjector<Activity> activityInjector;
    @Inject DispatchingAndroidInjector<Fragment> fragmentInjector;

    @Override public void onCreate() {
        super.onCreate();
        instance = this;
        injector = DaggerApplicationComponent.builder().build();
        injector.inject(this);
    }

    public ApplicationComponent getInjector() {
        return injector;
    }

    public static Application instance() {
        return instance;
    }

    public static void inject(Activity activity) {
        instance().activityInjector().inject(activity);
    }

    public static void inject(Fragment fragment) {
        instance().fragmentInjector().inject(fragment);
    }
    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    @Override public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }
}
