package com.incendiary.androidcommon.utils;

/**
 * Created by esa on 09/04/16, with awesomeness
 */
public class Preconditions {

  public static <T> T checkNotNull(T reference) {
    if (reference == null) {
      throw new NullPointerException();
    }
    return reference;
  }
}
