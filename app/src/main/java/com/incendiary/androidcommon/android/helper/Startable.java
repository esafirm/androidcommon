package com.incendiary.androidcommon.android.helper;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

/**
 * Created by esa on 17/03/16, with awesomeness
 */
public class Startable {

  private Object item;

  private Startable(Object o) {
    item = o;
  }

  public Object get() {
    return item;
  }

  public void startForResult(Intent intent, int reqCode) {
    if (item instanceof Activity) {
      ((Activity) item).startActivityForResult(intent, reqCode);
    } else if (item instanceof Fragment) {
      ((Fragment) item).startActivityForResult(intent, reqCode);
    } else if (item instanceof android.support.v4.app.Fragment) {
      ((android.support.v4.app.Fragment) item)
        .startActivityForResult(intent, reqCode);
    }
  }

  /* --------------------------------------------------- */
  /* > Wrapper */
  /* --------------------------------------------------- */

  public static Startable of(Activity activity) {
    return new Startable(activity);
  }

  public static Startable of(Fragment fragment) {
    return new Startable(fragment);
  }

  public static Startable of(android.support.v4.app.Fragment fragment) {
    return new Startable(fragment);
  }
}
