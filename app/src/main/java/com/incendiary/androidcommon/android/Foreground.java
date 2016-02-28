package com.incendiary.androidcommon.android;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

public class Foreground implements Application.ActivityLifecycleCallbacks {

	private static Foreground instance;

	private boolean paused = true;

	/**
	 * Its not strictly necessary to use this method - _usually_ invoking
	 * get with a Context gives us a path to retrieve the Application and
	 * initialise, but sometimes (e.g. in test harness) the ApplicationContext
	 * is != the Application, and the docs make no guarantees.
	 *
	 * @param application
	 * @return an initialised Foreground instance
	 */
	public static Foreground init(Application application) {
		if (instance == null) {
			instance = new Foreground();
			application.registerActivityLifecycleCallbacks(instance);
		}
		return instance;
	}

	public static Foreground get(Application application) {
		if (instance == null) {
			init(application);
		}
		return instance;
	}

	public static Foreground get(Context ctx) {
		if (instance == null) {
			Context appCtx = ctx.getApplicationContext();
			if (appCtx instanceof Application) {
				init((Application) appCtx);
			}
			throw new IllegalStateException(
				"Foreground is not initialised and " +
					"cannot obtain the Application object");
		}
		return instance;
	}

	public static Foreground get() {
		if (instance == null) {
			throw new IllegalStateException(
				"Foreground is not initialised - invoke " +
					"at least once with parameterised init/get");
		}
		return instance;
	}

	public boolean isForeground() {
		return !paused;
	}

	public boolean isBackground() {
		return paused;
	}

	@Override
	public void onActivityResumed(Activity activity) {
		paused = false;
	}

	@Override
	public void onActivityPaused(Activity activity) {
		paused = true;
	}

	@Override
	public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
	}

	@Override
	public void onActivityStarted(Activity activity) {
	}

	@Override
	public void onActivityStopped(Activity activity) {
	}

	@Override
	public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
	}

	@Override
	public void onActivityDestroyed(Activity activity) {
	}
}