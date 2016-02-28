package com.incendiary.androidcommon.android;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

/**
 * Created by esa on 22/02/16, with awesomeness
 */
public class Toasts {

  /**
   * Context using {@code contextor}
   **/
  public static void show(@StringRes int text) {
    show(ContextProvider.get(), ContextProvider.get().getString(text));
  }

  /**
   * Context using {@code contextor}
   **/
  public static void show(String text) {
    show(ContextProvider.get(), text);
  }

  public static void show(Context context, @StringRes int text) {
    show(context, context.getString(text));
  }

  public static void show(Context context, String text) {
    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
  }

  /**
   * Context using {@code contextor}
   **/
  public static void show(@LayoutRes int resId, int gravity){
    show(ContextProvider.get(), resId, gravity);
  }

  public static void show(Context context, @LayoutRes int resId, int gravity) {
    View view = LayoutInflater.from(context).inflate(resId, null);
    Toast toast = new Toast(context);
    toast.setView(view);
    toast.setGravity(gravity, 0, 0);
    toast.setDuration(Toast.LENGTH_SHORT);
    toast.show();
  }
}
