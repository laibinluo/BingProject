package luo.bing.com.bingproject.log;

import android.util.Log;

import luo.bing.com.bingproject.BuildConfig;

public class LogUtils {
	private static final String TAG = "Radio";
	public final static boolean DEBUG = BuildConfig.DEBUG;

	public static void v(String log) {
		if (DEBUG) {
			Log.v(TAG, log);
		}
	}

	public static void d(String log) {
		if (DEBUG) {
			Log.d(TAG, log);
		}
	}

	public static void i(String log) {
		if (DEBUG) {
			Log.i(TAG, log);
		}
	}

	public static void e(String log) {
		if (DEBUG) {
			Log.e(TAG, log);
		}
	}
}
