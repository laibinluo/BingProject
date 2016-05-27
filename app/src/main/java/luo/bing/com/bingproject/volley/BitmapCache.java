package luo.bing.com.bingproject.volley;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by bingluo on 2016/5/27.
 *
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
public class BitmapCache implements ImageLoader.ImageCache {
    private LruCache<String, Bitmap> mLruCache;


    public BitmapCache(){
        int maxSize = 10 * 1024 * 1024;
        mLruCache = new LruCache<String,  Bitmap>(maxSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return super.sizeOf(key, value);
            }
        };
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mLruCache.put(url, bitmap);
    }

    @Override
    public Bitmap getBitmap(String url) {
        return mLruCache.get(url);
    }


}
