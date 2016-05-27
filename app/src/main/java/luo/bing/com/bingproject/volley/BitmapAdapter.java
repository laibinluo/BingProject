package luo.bing.com.bingproject.volley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

import luo.bing.com.bingproject.R;

/**
 * Created by bingluo on 2016/5/27.
 *
 */
public class BitmapAdapter extends BaseAdapter {
    public Context mContext;
    public ArrayList<Info> mList;
    public LayoutInflater mLayoutInflater;

    public BitmapAdapter(Context context, ArrayList<Info> list) {
        mContext = context;
        mList = list;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder ;
        if (convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.volley_image_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView)convertView.findViewById(R.id.imgView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        ImageLoader.ImageListener listener = ImageLoader.getImageListener(viewHolder.imageView, R.drawable.abc_ic_menu_selectall_mtrl_alpha,
                R.drawable.ic_launcher);

        VolleySingleton.getVolleySingleton(mContext).getImageLoader().get(mList.get(position).getUrl(), listener);

        return convertView;
    }

    public class ViewHolder{
        public ImageView imageView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
