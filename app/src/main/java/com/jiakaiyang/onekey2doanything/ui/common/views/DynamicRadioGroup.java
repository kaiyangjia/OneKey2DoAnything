package com.jiakaiyang.onekey2doanything.ui.common.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jiakaiyang.onekey2doanything.R;

/**
 * A RadioGroup can add RadioButton dynamically in the code
 */

public class DynamicRadioGroup extends RadioGroup{
    private int radioButtonRes;

    private String[] names;


    public DynamicRadioGroup(Context context) {
        super(context);
        init(context, null);
    }

    public DynamicRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs){
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.DynamicRadioGroup, 0, 0);

        int itemsId = a.getResourceId(R.styleable.DynamicRadioGroup_items, 0);
        int itemLayout = a.getResourceId(R.styleable.DynamicRadioGroup_item_layout, 0);
        a.recycle();

        setNamesRes(itemsId);
        setRadioButtonRes(itemLayout);

        initView();
    }

    private void initView(){
        if(names != null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            for(int i=0;i<names.length;i++){
                String name = names[i];
                RadioButton radioButton = (RadioButton) inflater.inflate(getRadioButtonRes(), null);
                radioButton.setText(name);
                android.view.ViewGroup.LayoutParams layoutParams =
                        new android.view.ViewGroup.LayoutParams(
                                android.view.ViewGroup.LayoutParams.MATCH_PARENT
                                , android.view.ViewGroup.LayoutParams.WRAP_CONTENT);
                //调用的是RadioGroup的addView
                addView(radioButton, i, layoutParams);
            }
        }
    }

    public int getRadioButtonRes() {
        return radioButtonRes;
    }

    public void setRadioButtonRes(int resId){
        this.radioButtonRes = resId;
    }


    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }


    public void setNamesRes(int resId){
        if(resId > 0){
            String[] strings = getContext().getResources().getStringArray(resId);
            setNames(strings);
        }
    }
}
