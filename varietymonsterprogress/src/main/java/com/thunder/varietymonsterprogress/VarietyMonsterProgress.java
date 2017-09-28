package com.thunder.varietymonsterprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by thunder on 2017/9/23.
 */

public class VarietyMonsterProgress extends View {

    /* 默认宽 */
    private final float DEFAULT_WIDTH = 100;
    /* 默认高 */
    private final float DEFAULT_HEIGHT = 50;
    /* 默认总数 */
    private final int DEFAULT_COUNT = 8;
    /* 默认选中个数 */
    private final int DEFAULT_SELECTED = 0;
    /* 默认间距 */
    private final float DEFAULT_SPACING = 10;
    /* 默认圆角 */
    private final float DEFAULT_RADIUS = 0;
    /* 默认选中颜色 */
    private final int DEFAULT_SELECTEDCOLOR = Color.RED;
    /* 默认颜色 */
    private final int DEFAULT_NORMALCOLOR = Color.GRAY;

    /* 总数 */
    private int mCount;
    /* 选中个数 */
    private int mSelected = 0;
    /* 横向间距 */
    private float mSpacing = 10;
    /* 圆角 */
    private float mRadius;
    /* 选中颜色 */
    private int mSelectedColor = Color.RED;
    /* 正常颜色 */
    private int mNormalColor = Color.GRAY;

    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        if (count <= 0) {
            throw new IllegalStateException("Count can not be EMPTY !");
        }
        mCount = count;
    }

    public int getSelected() {
        return mSelected;
    }

    public void setSelected(int selected) {
        if (selected <= 0 && selected > mCount) {
            throw new IllegalStateException("Selected can not be EMPTY or greater than Count!");
        }
        mSelected = selected;
    }

    public float getSpacing() {
        return mSpacing;
    }

    public void setSpacing(float spacing) {
        mSpacing = spacing;
    }

    public float getRadius() {
        return mRadius;
    }

    public void setRadius(float radius) {
        mRadius = radius;
    }

    private Paint mNormalPaint;
    private Paint mSelectedPaint;

    public VarietyMonsterProgress(Context context) {
        this(context, null);
    }

    public VarietyMonsterProgress(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VarietyMonsterProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //取出xml里设置的属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.VarietyMonsterProgress);
        initView(typedArray);
    }

    private void initView(TypedArray typedArray) {

        mCount = typedArray.getInteger(R.styleable.VarietyMonsterProgress_count, DEFAULT_COUNT);
        mSelected = typedArray.getInteger(R.styleable.VarietyMonsterProgress_selected, DEFAULT_SELECTED);
        mSpacing = typedArray.getFloat(R.styleable.VarietyMonsterProgress_spacing, DEFAULT_SPACING);
        mRadius = typedArray.getFloat(R.styleable.VarietyMonsterProgress_radius, DEFAULT_RADIUS);
        mSelectedColor = typedArray.getColor(R.styleable.VarietyMonsterProgress_selectedColor, DEFAULT_SELECTEDCOLOR);
        mNormalColor = typedArray.getColor(R.styleable.VarietyMonsterProgress_normalColor, DEFAULT_NORMALCOLOR);

        mNormalPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mNormalPaint.setColor(mNormalColor);
        mNormalPaint.setStyle(Paint.Style.FILL);

        mSelectedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mSelectedPaint.setColor(mSelectedColor);
        mSelectedPaint.setStyle(Paint.Style.FILL);
        //回收typedArray对象
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        float width = getMySize(DEFAULT_WIDTH, widthMeasureSpec);
        float height = getMySize(DEFAULT_HEIGHT, heightMeasureSpec);

        if (width < height) {
            height = width;
        }

        setMeasuredDimension((int) width, (int) height);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        float itemWidth = (width - (mCount - 1) * mSpacing) / mCount;

        int startX = 0;
        if (mSelected == 0) {
            for (int i = 0; i < mCount; i++) {
                RectF rectF = new RectF(startX, 0, startX + itemWidth, height);
                drawRect(canvas, rectF, mRadius, mRadius, mNormalPaint);
                startX += itemWidth + mSpacing;
            }
        } else {
            for (int i = 0; i < mSelected; i++) {
                RectF rectF = new RectF(startX, 0, startX + itemWidth, height);
                drawRect(canvas, rectF, mRadius, mRadius, mSelectedPaint);
                startX += itemWidth + mSpacing;
            }
            int count = mCount - mSelected;
            for (int i = 0; i < count; i++) {
                RectF rectF = new RectF(startX, 0, startX + itemWidth, height);
                drawRect(canvas, rectF, mRadius, mRadius, mNormalPaint);
                startX += itemWidth + mSpacing;
            }
        }
    }

    private void drawRect(Canvas canvas, RectF rectF, float rx, float ry, Paint paint) {
        canvas.drawRoundRect(rectF, rx, ry, paint);
    }

    private float getMySize(float defaultSize, int measureSpec) {

        int mode = MeasureSpec.getMode(measureSpec);

        if (mode == MeasureSpec.UNSPECIFIED) {
            return defaultSize;
        } else {
            return MeasureSpec.getSize(measureSpec);
        }
    }
}
