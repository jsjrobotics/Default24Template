package nyc.jsjrobotics.default24application.spookyarchitecture.dagger.androidSubcomponents;

import android.app.Activity;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import nyc.jsjrobotics.default24application.spookyarchitecture.template.Application;

@Module(subcomponents = MainActivitySubcomponent.class)
public abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity> bindYourActivityInjectorFactory(MainActivitySubcomponent.Builder builder);

    @Provides static Application provideApplication() {
        return Application.instance();
    }

}
