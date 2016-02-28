package com.incendiary.androidcommon.android;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/**
 * Created by esa on 28/04/15, with awesomeness
 */
public class Screens {

  public static Point getDisplaySize() {
    Point point = new Point();
    WindowManager windowManager = AndroidUtils.getSystemService(Context.WIFI_SERVICE);
    windowManager.getDefaultDisplay().getSize(point);
    return point;
  }

  public static int getOrientation(Activity activity) {
    return activity.getWindowManager().getDefaultDisplay().getRotation();
  }
}
