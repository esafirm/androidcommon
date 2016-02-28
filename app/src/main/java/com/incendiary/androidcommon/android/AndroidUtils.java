package com.incendiary.androidcommon.android;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.StrictMode;
import android.support.v4.content.IntentCompat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Locale;

public final class AndroidUtils {

  private static final String CLIPBOARD_LABEL = "AndroidCommon.Clipboard";

  /**
   * Context using {@code contextor}
   **/
  @SuppressWarnings("unchecked")
  public static <T> T getSystemService(String name) {
    return (T) ContextProvider.get().getSystemService(name);
  }

  /**
   * Context using {@code contextor}
   **/
  public static void copyText(String text) {
    ClipboardManager clipboard = getSystemService(Context.CLIPBOARD_SERVICE);
    ClipData clip = ClipData.newPlainText(CLIPBOARD_LABEL, text);
    clipboard.setPrimaryClip(clip);
  }

  /**
   * Context using {@code contextor}
   **/
  public static String pasteText() {
    ClipboardManager clipboard = getSystemService(Context.CLIPBOARD_SERVICE);
    ClipData clipData = clipboard.getPrimaryClip();
    return clipData.getItemAt(0).getText().toString();
  }

  /**
   * Context using {@code contextor}
   **/
  public static void restartApp() {
    Context context = ContextProvider.get();
    Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
    intent = IntentCompat.makeRestartActivityTask(intent.getComponent());
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  public static String dumpLocationInfo(Location loc) {
    if (loc == null) {
      return "Location null or empty";
    }
    return String.format(Locale.getDefault(), "lat: %f, lng: %f, acc: %f, provider: %s",
      loc.getLatitude(), loc.getLongitude(), loc.getAccuracy(),
      loc.getProvider());
  }

  public static boolean isLollipopOrAbove() {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
  }

  public static void enableStrictMode() {
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
      .detectAll()
      .penaltyLog()
      .build());
    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
      .detectLeakedSqlLiteObjects()
      .detectLeakedClosableObjects()
      .penaltyLog()
      .penaltyDeath()
      .build());
  }

  /* --------------------------------------------------- */
  /* > Keyboard */
  /* --------------------------------------------------- */

  public static void hideKeyboard(View editText) {
    try {
      InputMethodManager imm = (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    } catch (Exception ignored) {
    }
  }

  public static void showKeyboard(View editText) {
    try {
      InputMethodManager imm = (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.showSoftInput(editText, 0);
    } catch (Exception ignored) {
    }
  }
}
