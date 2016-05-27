package luo.bing.com.bingproject.volley;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import luo.bing.com.bingproject.R;

public class VolleyActivity extends ActionBarActivity {
    private ArrayList<Info> mList = new ArrayList<Info>();

    public ListView listView;

    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_image_list);


        listView = (ListView) findViewById(R.id.listView);

        adapter = new BitmapAdapter(this, mList);

        init();

        listView.setAdapter(adapter);

    }


    private void init(){

        Info info1 = new Info("http://imgstatic.baidu.com/img/image/shouye/fanbingbing.jpg");
        Info info2 = new Info("http://imgstatic.baidu.com/img/image/shouye/liuyifei.jpg");
        Info info3 = new Info("http://imgstatic.baidu.com/img/image/shouye/wanglihong.jpg");
        Info info4 = new Info("http://imgstatic.baidu.com/img/image/shouye/gaoyuanyuan.jpg");
        Info info5 = new Info("http://imgstatic.baidu.com/img/image/shouye/yaodi.jpg");
        Info info6 = new Info("http://imgstatic.baidu.com/img/image/shouye/zhonghanliang.jpg");
        Info info7 = new Info("http://imgstatic.baidu.com/img/image/shouye/xiezhen.jpg");
        Info info8 = new Info("http://imgstatic.baidu.com/img/image/shouye/yiping3.jpg");
        Info info9 = new Info("http://imgstatic.baidu.com/img/image/shouye/erping4.jpg");
        Info info10 = new Info("http://imgstatic.baidu.com/img/image/shouye/hangeng.jpg");
        Info info11 = new Info("http://imgstatic.baidu.com/img/image/shouye/liuyan1.jpg");
        Info info12 = new Info("http://imgstatic.baidu.com/img/image/shouye/liushishi1.jpg");
        Info info13 = new Info("http://imgstatic.baidu.com/img/image/shouye/sunli1.jpg");
        Info info14 = new Info("http://imgstatic.baidu.com/img/image/shouye/tangyan1.jpg");
        Info info15 = new Info("http://imgstatic.baidu.com/img/image/shouye/zhanggenshuo1.jpg");
        Info info16 = new Info("http://imgstatic.baidu.com/img/image/shouye/xiaohua0605.jpg");
        mList.add(info1);
        mList.add(info2);
        mList.add(info3);
        mList.add(info4);
        mList.add(info5);
        mList.add(info6);
        mList.add(info7);
        mList.add(info8);
        mList.add(info9);
        mList.add(info10);
        mList.add(info11);
        mList.add(info12);
        mList.add(info13);
        mList.add(info14);
        mList.add(info15);
        mList.add(info16);
    }
}
