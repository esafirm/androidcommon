package com.incendiary.androidcommon.etc;

import android.util.Log;

public class Logger {

  private static final boolean ENABLE_STACK_TRACE = true;
  private static final boolean ENABLE_LONG_LOG = false;

  private static String TAG = "AndroidCommon";
  private static boolean ENABLE = true;

  public static void init(String tag, boolean enable) {
    TAG = tag;
    ENABLE = enable;
  }

  public static void log(int mode, String message) {
    log(mode, message, null);
  }

  public static void log(Throwable e) {
    if (e == null)
      return;

    log(Log.ERROR, e.toString(), null);
    printStack(e);
  }

  public static void log(Throwable e, boolean printStack) {

    if (e == null)
      return;

    log(Log.ERROR, e.toString(), null);

    if (printStack)
      printStack(e);
  }

  private static void printStack(Throwable e) {
    if (ENABLE_STACK_TRACE)
      e.printStackTrace();
  }

  public static void log(int mode, String message, String tag) {

    if (!ENABLE)
      return;

    if (message == null)
      return;

    if (tag == null)
      tag = "";

    if (message.trim().length() == 0)
      message = "Data Empty";

    if (ENABLE_LONG_LOG) {
      longLog(mode, tag, message);
    } else {
      if (mode == Log.DEBUG) {
        Log.d(TAG + tag, message);
      } else if (mode == Log.ERROR) {
        Log.e(TAG + tag, message);
      } else if (mode == Log.INFO) {
        Log.i(TAG + tag, message);
      } else if (mode == Log.WARN) {
        Log.w(TAG + tag, message);
      }
    }
  }

  private static void longLog(int mode, String tag, String message) {
    int maxLogSize = 1000;
    for (int i = 0; i <= message.length() / maxLogSize; i++) {
      int start = i * maxLogSize;
      int end = (i + 1) * maxLogSize;
      end = end > message.length() ? message.length() : end;

      if (mode == Log.DEBUG) {
        Log.d(TAG + tag, message.substring(start, end));
      } else if (mode == Log.ERROR) {
        Log.e(TAG + tag, message.substring(start, end));
      } else if (mode == Log.INFO) {
        Log.i(TAG + tag, message.substring(start, end));
      } else if (mode == Log.WARN) {
        Log.w(TAG + tag, message.substring(start, end));
      }
    }
  }
}
