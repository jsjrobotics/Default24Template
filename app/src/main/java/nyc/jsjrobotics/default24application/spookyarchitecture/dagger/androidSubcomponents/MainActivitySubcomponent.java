package nyc.jsjrobotics.default24application.spookyarchitecture.dagger.androidSubcomponents;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {}
}
