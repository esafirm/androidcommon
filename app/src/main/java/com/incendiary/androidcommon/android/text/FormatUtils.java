package com.incendiary.androidcommon.android.text;

import java.util.Locale;

/**
 * Created by esa on 14/11/14.
 */
public class FormatUtils {

  public static String ordinal(int i) {
    String[] sufixes = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
    switch (i % 100) {
      case 11:
      case 12:
      case 13:
        return i + "th";
      default:
        return i + sufixes[i % 10];
    }
  }

  public static String decimal(float d) {
    if (d == (int) d)
      return Strings.format("%d", (int) d);
    else
      return Strings.format("%.2f", d);
  }

  public static String uppercaseFirstLetter(String data) {
    if (data != null && !data.isEmpty())
      data = data.substring(0, 1).toUpperCase(Locale.getDefault()) +
        data.substring(1);
    return data;
  }
}
