package luo.bing.com.bingproject.volley;

import java.io.Serializable;

/**
 * Created by bingluo on 2016/5/27.
 *
 */
public class Info implements Serializable{
    private String mUrl;

    public Info(String url){
        mUrl = url;
    }

    public String getUrl(){
        return mUrl;
    }

    public void setUrl(String url){
        int x = 123;

        mUrl = url;
    }


}
