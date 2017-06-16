package nyc.jsjrobotics.default24application.spookyarchitecture.dagger;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.buses.ActivityBus;
import nyc.jsjrobotics.default24application.spookyarchitecture.eventBus.buses.UiEventBus;

@Module
abstract class EventBusModule {

    @Singleton
    @Provides static UiEventBus provideEventBus() {
        return new UiEventBus();
    }

    @Singleton
    @Provides static ActivityBus provideActivityBus() {
        return new ActivityBus();
    }
}
