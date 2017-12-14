package com.incendiary.androidcommon;

import android.app.Application;

import com.incendiary.androidcommon.android.AndroidUtils;
import com.incendiary.androidcommon.android.ContextProvider;
import com.incendiary.androidcommon.android.Foreground;
import com.incendiary.androidcommon.android.text.Strings;
import com.incendiary.androidcommon.etc.Logger;

/**
 * Created by esa on 27/02/16, with awesomeness
 */
public class AndroidCommon {

  private Application application;
  private String logTag;
  private boolean enableLogger;
  private boolean enableStrictMode;
  private boolean enableForeground;

  private AndroidCommon(Application application) {
    this.application = application;
  }

  public static AndroidCommon with(Application application) {
    return new AndroidCommon(application);
  }

  public AndroidCommon enableLogger(boolean isEnable) {
    enableLogger = isEnable;
    return this;
  }

  public AndroidCommon logTag(String tag) {
    logTag = tag;
    return this;
  }

  public AndroidCommon enableStricMode(boolean isEnable) {
    enableStrictMode = isEnable;
    return this;
  }

  public AndroidCommon enableForeground(boolean isEnable) {
    enableForeground = isEnable;
    return this;
  }

  /* --------------------------------------------------- */
  /* > Install */
  /* --------------------------------------------------- */

  public void install() {
    ContextProvider.install(application);

    String tag = Strings.isNullOrEmpty(logTag)
      ? application.getPackageName()
      : logTag;

    Logger.init(tag, enableLogger);

    if (enableStrictMode)
      AndroidUtils.enableStrictMode();

    if (enableForeground)
      Foreground.init(application);
  }
}
