package com.jiakaiyang.onekey2doanything.ui.common.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.percent.PercentLayoutHelper;
import android.support.percent.PercentRelativeLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;

import com.jiakaiyang.onekey2doanything.R;

/**
 * not a subclass of EditText, a subclass of PercentRelativeLayout
 */

public class EditItemEditTextView extends PercentRelativeLayout{
    private TextView mNameView;

    private EditText mValueView;

    private float mDefaultNamePercent = 0.2f;

    private float mDefaultValuePercent = 0.8f;


    public EditItemEditTextView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public EditItemEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public EditItemEditTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }


    private void init(Context context, AttributeSet attrs, int defStyle){
        mNameView = new TextView(context);
        mValueView = new EditText(context);

        // 获取xml中的参数
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.EditItemEditTextView, 0, 0);
        float namePercent = a.getFloat(R.styleable.EditItemEditTextView_name_percent, mDefaultNamePercent);
        float valuePercent = a.getFloat(R.styleable.EditItemEditTextView_value_parent, mDefaultValuePercent);
        String name = a.getString(R.styleable.EditItemEditTextView_name);
        String value = a.getString(R.styleable.EditItemEditTextView_value);
        int nameTextSize = a.getDimensionPixelSize(
                R.styleable.EditItemEditTextView_name_text_size, (int) mNameView.getTextSize());
        int valueTextSize = a.getDimensionPixelSize(
                R.styleable.EditItemEditTextView_value_text_size, (int) mValueView.getTextSize());
        a.recycle();


        // init Name View instance
        mNameView.setGravity(Gravity.LEFT);
        mNameView.setGravity(Gravity.CENTER_VERTICAL);
        mNameView.setText(name);
        mNameView.setTextSize(TypedValue.COMPLEX_UNIT_PX, nameTextSize);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        layoutParams.addRule(PercentRelativeLayout.ALIGN_PARENT_LEFT, PercentRelativeLayout.TRUE);
        PercentLayoutHelper.PercentLayoutInfo info = layoutParams.getPercentLayoutInfo();
        info.widthPercent = namePercent;
        mNameView.setLayoutParams(layoutParams);
        addView(mNameView);

        // init Value View instance
        mValueView.setText(value);
        mValueView.setEllipsize(TextUtils.TruncateAt.END);
        mValueView.setTextSize(TypedValue.COMPLEX_UNIT_PX, valueTextSize);
        mValueView.setGravity(Gravity.LEFT);
        mValueView.setGravity(Gravity.CENTER_VERTICAL);
        layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        layoutParams.addRule(PercentRelativeLayout.ALIGN_PARENT_RIGHT, PercentRelativeLayout.TRUE);
        info = layoutParams.getPercentLayoutInfo();
        info.widthPercent = valuePercent;
        mValueView.setLayoutParams(layoutParams);
        addView(mValueView);
    }


    public TextView getmNameView() {
        return mNameView;
    }

    public EditText getmValueView() {
        return mValueView;
    }
}
