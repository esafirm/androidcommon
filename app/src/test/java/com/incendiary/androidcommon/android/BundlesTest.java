package com.incendiary.androidcommon.android;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.incendiary.androidcommon.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by esa on 28/02/16, with awesomeness
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(
  constants = BuildConfig.class,
  sdk = Build.VERSION_CODES.LOLLIPOP,
  manifest = Config.NONE
)
public class BundlesTest {

  @Before
  public void setUp() throws Exception {
    ContextProvider.install(RuntimeEnvironment.application);
  }

  @Test
  public void testCreateEmptyIntentWithBundle() throws Exception {
    Bundle testBundle = new Intent(Intent.ACTION_VIEW).getExtras();
    assertNull(testBundle);

    Bundle bundle = Bundles.wrap(new Data("test"));
    Intent intent = Bundles.createEmptyIntentWithBundle(bundle);
    assertNotNull(intent.getExtras());
  }

  @Test
  public void testExtractWrap() throws Exception {
    Bundle bundle = Bundles.wrap(new Data("test"));
    Data testData = Bundles.extract(bundle, Data.class);

    assertNotNull(testData);
    assertTrue(testData.data.equals("test"));
  }

  @Test
  public void testExtarctWrapList() throws Exception {
    ArrayList<Data> datas = new ArrayList<>();
    datas.add(new Data("test"));

    Bundle bundle = Bundles.wrapList(datas, Data.class);
    datas = Bundles.extarctList(bundle, Data.class);

    assertNotNull(datas);
    assertTrue(datas.get(0).data.equals("test"));
  }

  @Test
  public void testContain() throws Exception {
    boolean contain = Bundles.has(Bundles.wrap(new Data("data")), Data.class);
    assertTrue(contain);
  }

  static class Data implements Parcelable {

    private final String data;

    public Data(String data) {
      this.data = data;
    }

    @Override
    public int describeContents() {
      return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(this.data);
    }

    protected Data(Parcel in) {
      this.data = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
      public Data createFromParcel(Parcel source) {
        return new Data(source);
      }

      public Data[] newArray(int size) {
        return new Data[size];
      }
    };
  }
}