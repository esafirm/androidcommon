package com.incendiary.androidcommon.android;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by esa on 28/04/15, with awesomeness
 */
public class Screens {

  public static Point getDisplaySize() {
    Point point = new Point();
    WindowManager windowManager = AndroidUtils.getSystemService(Context.WINDOW_SERVICE);
    if (Build.VERSION.SDK_INT >= 13) {
      windowManager.getDefaultDisplay().getSize(point);
    } else {
      Display display = windowManager.getDefaultDisplay();
      point.set(display.getWidth(), display.getHeight());
    }
    return point;
  }

  public static int getOrientation(Activity activity) {
    return activity.getWindowManager().getDefaultDisplay().getRotation();
  }

  public static float getScreenDensity() {
    return ContextProvider.get()
      .getResources()
      .getDisplayMetrics()
      .density;
  }

}
