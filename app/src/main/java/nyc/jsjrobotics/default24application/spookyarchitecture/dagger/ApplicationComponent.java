package nyc.jsjrobotics.default24application.spookyarchitecture.dagger;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import javax.inject.Singleton;
import nyc.jsjrobotics.default24application.spookyarchitecture.dagger.androidSubcomponents.MainActivityModule;
import nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.buses.ActivityBus;
import nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.buses.UiEventBus;
import nyc.jsjrobotics.default24application.spookyarchitecture.template.Application;

@Singleton
@Component(modules = {
        EventBusModule.class,
        AndroidInjectionModule.class,
        FragmentModule.class,
        MainActivityModule.class
})
public interface ApplicationComponent {
    UiEventBus uiEventBus();
    ActivityBus activityBus();
    Application application();
    void inject(Application application);

}
