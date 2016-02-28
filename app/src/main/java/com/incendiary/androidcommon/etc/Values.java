package com.incendiary.androidcommon.etc;

/**
 * Created by esa on 26/02/16, with awesomeness
 */
public class Values {

  public static int invert(int current, int val1, int val2) {
    return current == val1
      ? val2
      : val1;
  }

  /**
   * @return true if not null and true
   **/
  public static boolean isTrue(Boolean aBoolean) {
    return aBoolean != null && aBoolean;
  }

  /**
   * @return true if null or {@code false}
   **/
  public static boolean isFalse(Boolean aBoolean) {
    return aBoolean == null || !aBoolean;
  }
}
