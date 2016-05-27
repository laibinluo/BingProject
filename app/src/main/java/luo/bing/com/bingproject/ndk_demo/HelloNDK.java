package luo.bing.com.bingproject.ndk_demo;

import android.util.Log;

/**
 * Created by bingluo on 2016/1/22.
 *
 */
public class HelloNDK {
    private final String TAG = "HelloNDK";
    static {
        System.loadLibrary("HelloNDK");
    }

    public String javaSayHellzo(){
        Log.d(TAG,  "javaSayHello ====");
        return sayHello();
    }

    /**
     * ndk test
     */
    public native String sayHello();
}
