package com.incendiary.androidcommon.android;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.ArrayList;

public class Bundles {

  public static Intent createEmptyIntentWithBundle(Bundle bundle) {
    Intent intent = new Intent();
    intent.putExtras(bundle);
    return intent;
  }

  public static <T extends Parcelable> T extract(Bundle bundle, Class<T> clazz) {
    if (bundle == null)
      throw new IllegalStateException("Bundle cannot be null");

    String key = clazz.getSimpleName();
    if (!bundle.containsKey(key))
      return null;

    return bundle.getParcelable(key);
  }

  public static <T extends Parcelable> ArrayList<T> extarctList(Bundle bundle, Class<T> clazz) {
    if (bundle == null)
      throw new IllegalStateException("Bundle cannot be null");

    String key = clazz.getSimpleName();
    if (!bundle.containsKey(key))
      return null;

    return bundle.getParcelableArrayList(key);
  }

  public static Bundle wrap(Parcelable o) {
    Bundle bundle = new Bundle();
    bundle.putParcelable(o.getClass().getSimpleName(), o);
    return bundle;
  }

  public static <T extends Parcelable> Bundle wrapList(ArrayList<T> data, Class<T> clazz) {
    Bundle bundle = new Bundle();
    bundle.putParcelableArrayList(clazz.getSimpleName(), data);
    return bundle;
  }

  public static boolean has(Bundle bundle, Class<?> clazz) {
    return has(bundle, clazz.getSimpleName());
  }

  public static boolean has(Bundle bundle, String key) {
    return bundle != null && bundle.containsKey(key);
  }
}