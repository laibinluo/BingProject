package luo.bing.com.bingproject.testView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bingluo on 2016/1/19.
 *
 */
public class CustomView extends View {
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
