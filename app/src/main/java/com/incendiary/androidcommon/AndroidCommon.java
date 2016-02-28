package com.incendiary.androidcommon;

import android.app.Application;

import com.incendiary.androidcommon.android.ContextProvider;
import com.incendiary.androidcommon.etc.Logger;

/**
 * Created by esa on 27/02/16, with awesomeness
 */
public class AndroidCommon {

  public static void install(Application application, boolean enableLogger) {
    ContextProvider.install(application);
    Logger.init(application.getPackageName(), enableLogger);
  }
}
