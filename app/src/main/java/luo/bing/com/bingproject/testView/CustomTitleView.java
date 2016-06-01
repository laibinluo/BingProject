package luo.bing.com.bingproject.testView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import luo.bing.com.bingproject.R;
import luo.bing.com.bingproject.log.LogUtils;

/**
 * Created by bingluo on 2016/6/1.
 *
 */
public class CustomTitleView extends View {

    private int mTextSize;
    private int mTextColor;
    private String mTextTitle;
    private Paint mPaint;

    private Rect mBound;
    public CustomTitleView(Context context) {
        this(context, null);
    }

    public CustomTitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        int n  = a.getIndexCount();
        for (int i = 0;  i < n; ++ i){
            int attr = a.getIndex(i);
            switch (attr){
                case  R.styleable.CustomTitleView_titleText:
                    mTextTitle = a.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    mTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    mTextSize = a.getDimensionPixelSize(attr,
                            (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
            }
        }

        a.recycle();

        mPaint = new Paint();

        mBound = new Rect();
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width , height;
        if (widthMode == MeasureSpec.EXACTLY){
            width = widthSize;
        }else {
            mPaint.setTextSize(mTextSize);

            mPaint.getTextBounds(mTextTitle, 0, mTextTitle.length(), mBound);
            width = mBound.width() + getPaddingLeft() + getPaddingRight();
        }

        if (heightMode == MeasureSpec.EXACTLY){
            height = heightSize;
        }else {
            mPaint.setTextSize(mTextSize);

            mPaint.getTextBounds(mTextTitle, 0, mTextTitle.length(), mBound);
            height = mBound.height() + getPaddingBottom() + getPaddingTop();
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        measure(0, 0);
        mPaint.setColor(Color.RED);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(mTextColor);
        canvas.drawText(mTextTitle, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);

        LogUtils.d("==============onDraw====================");
        LogUtils.d("getMeasuredWidth : " + getMeasuredWidth());
        LogUtils.d("getMeasuredHeight : " + getMeasuredHeight());
        LogUtils.d("getWidth : " + getWidth());
        LogUtils.d("getMeasuredWidth : " + getHeight());

    }
}
