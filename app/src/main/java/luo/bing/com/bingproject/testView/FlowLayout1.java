package luo.bing.com.bingproject.testView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bingluo on 2016/1/19.
 *
 */
public class FlowLayout1 extends ViewGroup{
    public FlowLayout1(Context context) {
        super(context);
    }

    public FlowLayout1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int viewGroupWidth = getMeasuredWidth();

        int posX = left;
        int posY = top;

        int lineHeight = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; ++i){
            View childView = getChildAt(i);

            int width = childView.getMeasuredWidth();
            int height = childView.getMeasuredHeight();

            FlowLayout1.LayoutParams margins = (FlowLayout1.LayoutParams) (childView.getLayoutParams());

            if (posX + width + margins.leftMargin + margins.rightMargin > viewGroupWidth){
                posX = left;
                lineHeight = Math.max(lineHeight, height + margins.topMargin + margins.bottomMargin);
                posY += lineHeight;
            }

            childView.layout(posX + margins.leftMargin, posY , posX + width, posY + height);
            posX += width + margins.leftMargin + margins.rightMargin;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams{
        public LayoutParams(Context c, AttributeSet attributeSet){
            super(c, attributeSet);
        }
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new FlowLayout1.LayoutParams(getContext(), attrs);
    }
}
