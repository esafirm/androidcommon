package com.incendiary.androidcommon.android;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class ActivityHelper {

  public static void setTitle(AppCompatActivity activity, int title) {
    setTitle(activity, activity.getString(title));
  }

  public static void setTitle(AppCompatActivity activity, String title) {
    ActionBar actionBar = activity.getSupportActionBar();
    if (actionBar != null)
      actionBar.setTitle(title);
    else
      activity.setTitle(title);
  }

  public static void setToolbarVisibility(AppCompatActivity activity, boolean isVisible) {
    ActionBar actionBar = activity.getSupportActionBar();
    if (actionBar != null) {
      if (isVisible)
        actionBar.show();
      else
        actionBar.hide();
    }
  }

  public static boolean isToolbarVisible(AppCompatActivity activity) {
    ActionBar actionBar = activity.getSupportActionBar();
    return actionBar != null && actionBar.isShowing();
  }

  public static ActionBar getActionBar(AppCompatActivity activity) {
    return activity.getSupportActionBar();
  }

  public static void setDisplayAsUp(AppCompatActivity activity, boolean isUp) {
    ActionBar actionBar = activity.getSupportActionBar();
    if (actionBar != null)
      actionBar.setDisplayHomeAsUpEnabled(isUp);
  }

  public static void setIconOnly(AppCompatActivity activity, int resId) {
    ActionBar actionBar = activity.getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayShowHomeEnabled(true);
      actionBar.setDisplayShowTitleEnabled(false);
      actionBar.setIcon(resId);
    }
  }
}
