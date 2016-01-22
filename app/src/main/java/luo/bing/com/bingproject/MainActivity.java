package luo.bing.com.bingproject;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import luo.bing.com.bingproject.ndk_demo.HelloNDK;
import luo.bing.com.bingproject.volley.VolleySingleton;


public class MainActivity extends ActionBarActivity {
    private Context mContext;
    private ImageView mImgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.flow_main2);
        mContext = getApplicationContext();

        TextView txtView = (TextView) findViewById(R.id.txtView);
        HelloNDK helloNDK = new HelloNDK();
        txtView.setText(helloNDK.javaSayHello());

//        testImageView();
//
//        Toast.makeText(this.getApplicationContext(), "boot time : " + ConfigUtils.getBootTime(this.getApplicationContext()), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initVolley(){
        VolleySingleton.getVolleySingleton(mContext).addToRequestQueue(stringRequest);
        testJson();
    }

    private StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://www.baidu.com", new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Toast.makeText(mContext, response, Toast.LENGTH_LONG).show();
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(mContext, error.toString(), Toast.LENGTH_LONG).show();
        }
    });

    public void testImageView(){
        String url = "http://i.imgur.com/7spzG.png";
        mImgView = (ImageView) findViewById(R.id.imgView);

        ImageRequest request = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                mImgView.setImageBitmap(response);
            }
        }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mImgView.setImageResource(R.drawable.abc_btn_check_material);
            }
        });

        VolleySingleton.getVolleySingleton(mContext).addToRequestQueue(request);
    }

    private void testJson(){
        String url = "http://pipes.yahooapis.com/pipes/pipe.run?_id=giWz8Vc33BG6rQEQo_NLYQ&_render=json";
        final ProgressDialog pd = ProgressDialog.show(this, "Please Wait...", "Please Wait...");
        JsonObjectRequest jr = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(mContext, "success", Toast.LENGTH_LONG).show();
                pd.dismiss();
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, "failed", Toast.LENGTH_LONG).show();
                pd.dismiss();
            }
        });

        VolleySingleton.getVolleySingleton(mContext).addToRequestQueue(jr);
    }
}
