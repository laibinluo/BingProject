package luo.bing.com.bingproject.testView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import luo.bing.com.bingproject.log.LogUtils;

/**
 * Created by bingluo on 2016/6/1.
 *
 */
public class CustomImgContainer extends ViewGroup{
    public CustomImgContainer(Context context) {
        super(context);
    }

    public CustomImgContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImgContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int hightMode = MeasureSpec.getMode(heightMeasureSpec);
        int hightSize = MeasureSpec.getSize(heightMeasureSpec);

        // 计算所有子View的宽高
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int widthTotal;
        int heightTotal;

        int tSize = 0;
        int bSize = 0;
        int lSize = 0;
        int rSize = 0;

        int count = getChildCount();

        MarginLayoutParams params = null;

        for (int i =0;  i < count; ++ i){
            View view = getChildAt(i);
            int childWidth = view.getMeasuredWidth();
            int childHeight = view.getMeasuredHeight();

            params = (MarginLayoutParams)view.getLayoutParams();

            int vt, vl, vb, vr;
            if (i == 0 || i == 1){
                tSize += childWidth + params.leftMargin + params.rightMargin;
            }

            if (i == 0 || i == 2){
                lSize += childHeight + params.topMargin + params.bottomMargin;
            }

            if (i == 1 || i == 3){
                rSize += childHeight + params.topMargin + params.bottomMargin;
            }

            if (i == 2 || i == 3 ){
                bSize += childWidth + params.leftMargin + params.rightMargin;
            }
        }

        widthTotal = Math.max(tSize, bSize);
        heightTotal = Math.max(lSize, rSize);


        setMeasuredDimension(widthMode == MeasureSpec.EXACTLY ? widthSize:widthTotal,
                hightMode == MeasureSpec.EXACTLY ? hightSize:heightTotal);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        for (int i = 0; i < count; ++ i){
            View view = getChildAt(i);
            int height = view.getMeasuredHeight();
            int width = view.getMeasuredWidth();

            MarginLayoutParams params = (MarginLayoutParams)view.getLayoutParams();

            int left = 0, top = 0;
            switch (i){
                case 0:
                    left = params.leftMargin;
                    top = params.topMargin;
                    break;
                case 1:
                    left = getWidth() - params.leftMargin - params.rightMargin - width;
                    top = params.topMargin;
                    break;
                case 2:
                    left = params.leftMargin;
                    top = getHeight() - params.topMargin - params.bottomMargin - height;
                    break;
                case 3:
                    left = getWidth() - params.leftMargin - params.rightMargin - width;
                    top = getHeight() - params.topMargin - params.bottomMargin - height;
                    break;
                default:
                    break;
            }


            view.layout(left, top, left + width, top + height);

            LogUtils.d("parems left: " + params.leftMargin +
            ", right : " + params.rightMargin +
            ", top : " + params.topMargin +
            ", bottom : " + params.bottomMargin);
        }

    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        LogUtils.d("generateDefaultLayoutParams attrs ");
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        LogUtils.d("generateDefaultLayoutParams ");
        return new MarginLayoutParams(p);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        LogUtils.d("generateDefaultLayoutParams ");
        return new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }
}
