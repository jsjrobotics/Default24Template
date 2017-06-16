package nyc.jsjrobotics.default24application.spookyarchitecture.views;


import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

public abstract class ViewUtils {

    public static int getScreenWidthPx(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    public static int getScreenHeightPx(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    private static DisplayMetrics getDisplayMetrics(Context context) {
        final DisplayMetrics metrics = new DisplayMetrics();
        final WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        windowManager.getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }

    public static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
    public static float dpToPx(Context context, float dp){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }
}
