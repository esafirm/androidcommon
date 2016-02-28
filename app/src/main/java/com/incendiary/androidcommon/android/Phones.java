package com.incendiary.androidcommon.android;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/**
 * Created by esa on 07/07/15, with awesomeness
 */
public class Phones {

  public static boolean isPhoneAvailable() {
    TelephonyManager manager = AndroidUtils.getSystemService(Context.TELEPHONY_SERVICE);
    String lineNumber = manager.getLine1Number();
    int phoneType = manager.getPhoneType();

    return !(TextUtils.isEmpty(lineNumber) || phoneType == TelephonyManager.PHONE_TYPE_NONE);
  }
}
