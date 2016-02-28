package com.incendiary.androidcommon.android;

import android.content.Context;

/**
 * Created by esa on 27/02/16, with awesomeness
 */
public class ContextProvider {

  private static ContextProvider mInstance;

  private static ContextProvider getInstance() {
    if (mInstance == null) {
      mInstance = new ContextProvider();
    }
    return mInstance;
  }

  private Context mContext;

  private ContextProvider() {
  }

  /**
   * Should be application context
   */
  private void init(Context context) {
    mContext = context;
  }

  private Context getContext() {
    if (mContext == null)
      throw new IllegalStateException("Must call init first before getContext()");
    return mContext;
  }

  /* --------------------------------------------------- */
  /* > Public */
  /* --------------------------------------------------- */

  public static void install(Context context) {
    getInstance().init(context);
  }

  public static Context get() {
    return getInstance().getContext();
  }
}
