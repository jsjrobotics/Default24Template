package nyc.jsjrobotics.default24application.spookyarchitecture.views;

import android.view.View;
import java.util.Optional;

public interface IDefaultView {
    Optional<View> getLoadingView();
    Optional<View> getLoadedView();
    Optional<View> getErrorView();
    View getRoot();
    void setLoading(boolean isLoading);
    void setError();

}
