package com.incendiary.androidcommon.etc;

import java.util.Collection;
import java.util.List;

/**
 * Created by esa on 26/02/16, with awesomeness
 */
public class Values {

  public static int invert(int current, int val1, int val2) {
    return current == val1
      ? val2
      : val1;
  }

  public static boolean isTrue(Boolean aBoolean) {
    return aBoolean != null && aBoolean;
  }

  public static boolean isFalse(Boolean aBoolean) {
    return aBoolean == null || !aBoolean;
  }

  /**
   * Check if collection is null or empty
   **/
  public static boolean isEmpty(Collection<?> objects) {
    return objects == null || objects.isEmpty();
  }

  /**
   * Get first value of list or null
   **/
  public static <T> T first(List<T> list) {
    if (isEmpty(list)) return null;
    return list.get(0);
  }
}
