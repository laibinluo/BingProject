package luo.bing.com.bingproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by bingluo on 2016/1/11.
 *
 */
public class ConfigUtils {
    public static final String BOOT_TIME_NAME = "boot_time_name";
    public static final String BOOT_TIME_KEY = "boot_time";
    public static int MODE = Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE + Context.MODE_MULTI_PROCESS;
    public static final String TAG = "ConfigUtils";

    public static void saveBootTime(Context context, float time){
        SharedPreferences share = context.getSharedPreferences(BOOT_TIME_NAME, MODE);
        SharedPreferences.Editor editor = share.edit();

        editor.putFloat(BOOT_TIME_KEY, time);
        editor.commit();

        Log.d(TAG, "boot_time : " + time);
    }

    public static float getBootTime(Context context){
        SharedPreferences share = context.getSharedPreferences(BOOT_TIME_NAME, MODE);
        return share.getFloat(BOOT_TIME_KEY, 0);
    }
}
