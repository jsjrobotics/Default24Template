package nyc.jsjrobotics.default24application.spookyarchitecture.dagger;

import android.app.Fragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.FragmentKey;
import dagger.multibindings.IntoMap;
import nyc.jsjrobotics.default24application.spookyarchitecture.dagger.androidSubcomponents.SelectSubjectFragment;
import nyc.jsjrobotics.default24application.spookyarchitecture.dagger.androidSubcomponents.SelectSubjectFragmentSubcomponent;

@Module(subcomponents = {
        SelectSubjectFragmentSubcomponent.class
})
abstract class FragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(SelectSubjectFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindSelectSubjectInjectorFactory(SelectSubjectFragmentSubcomponent.Builder builder);
}
