package com.incendiary.androidcommon.android;

import android.content.ClipboardManager;
import android.content.Context;
import android.location.Location;
import android.os.Build;

import com.incendiary.androidcommon.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by esa on 28/02/16, with awesomeness
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
  sdk = Build.VERSION_CODES.LOLLIPOP,
  manifest = Config.NONE)
public class AndroidUtilsTest {

  @Before
  public void setUp() throws Exception {
    ContextProvider.install(RuntimeEnvironment.application);
  }

  @Test
  public void testGetSystemService() throws Exception {
    ClipboardManager manager = AndroidUtils.getSystemService(Context.CLIPBOARD_SERVICE);
    assertNotNull(manager);
  }

  @Test
  public void testCopyText() throws Exception {
    AndroidUtils.copyText("Copy");
    assertTrue("Copy".equals(AndroidUtils.pasteText()));
  }

  @Test
  public void testDumpLocationInfo() throws Exception {
    Location location = new Location("test");
    location.setLatitude(123123);
    location.setLongitude(123123);

    assertNotNull(AndroidUtils.dumpLocationInfo(location));
  }

  @Test
  public void testIsLollipopOrAbove() throws Exception {
    assertTrue(AndroidUtils.isLollipopOrAbove());
  }
}