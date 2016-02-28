package com.incendiary.androidcommon.android.text;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by esa on 22/03/16, with awesomeness
 */
public class FormatUtilsTest {

  @Test
  public void testUppercaseFirstLetter() throws Exception {
    String name = "esa";
    name = FormatUtils.uppercaseFirstLetter(name);
    assertTrue(name.equals("Esa"));
  }
}