package com.incendiary.androidcommon.android;

/**
 * Created by esa on 17/03/16, with awesomeness
 */
public class Sizes {

  public static float px2dp(float px) {
    return px / ContextProvider.get().getResources().getDisplayMetrics().density;
  }

  public static float dp2px(float dp) {
    return dp * ContextProvider.get().getResources().getDisplayMetrics().density;
  }

  public static float px2sp(float px) {
    return px / ContextProvider.get().getResources().getDisplayMetrics().scaledDensity;
  }

  public static float sp2px(float sp) {
    return sp * ContextProvider.get().getResources().getDisplayMetrics().scaledDensity;
  }
}
