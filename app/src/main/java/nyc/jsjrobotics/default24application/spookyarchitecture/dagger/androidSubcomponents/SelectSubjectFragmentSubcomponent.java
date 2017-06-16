package nyc.jsjrobotics.default24application.spookyarchitecture.dagger.androidSubcomponents;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface SelectSubjectFragmentSubcomponent extends AndroidInjector<SelectSubjectFragment> {
    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<SelectSubjectFragment> {}

}
