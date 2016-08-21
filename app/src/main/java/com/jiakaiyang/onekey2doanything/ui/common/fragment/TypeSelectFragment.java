package com.jiakaiyang.onekey2doanything.ui.common.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import com.jiakaiyang.onekey2doanything.R;
import com.jiakaiyang.onekey2doanything.ui.base.BaseFragment;
import com.jiakaiyang.onekey2doanything.ui.base.OnPageIndexClickListener;
import com.jiakaiyang.onekey2doanything.ui.common.views.DynamicRadioGroup;

/**
 * 选择 command 类型的页面
 */

public class TypeSelectFragment extends BaseFragment
        implements TypeSelectContract.View
        , RadioGroup.OnCheckedChangeListener
        ,View.OnClickListener{
    public static final String PAGE_TAG = "TypeSelectPage";

    private Button btnNext;

    private OnPageIndexClickListener onPageIndexClickListener;

    public TypeSelectFragment(){}

    public static TypeSelectFragment newInstance(){
        return new TypeSelectFragment();
    }

    @Override
    public int getRootViewRes() {
        return R.layout.type_select_frg;
    }


    @Override
    public void initView(){
        DynamicRadioGroup dynamicRadioGroup = (DynamicRadioGroup) rootView.findViewById(R.id.radio_group);
        dynamicRadioGroup.setOnCheckedChangeListener(this);

        btnNext = (Button) rootView.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(group.getCheckedRadioButtonId() != -1){
            showNextBtn();
        }else {
            hideNextBtn();
        }
    }

    @Override
    public void setPresenter(TypeSelectContract.Presenter presenter) {

    }

    @Override
    public void showNextBtn() {
        if(btnNext != null && !btnNext.isShown()){
            btnNext.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideNextBtn() {
        if(btnNext != null && btnNext.isShown()){
            btnNext.setVisibility(View.GONE);
        }
    }

    public OnPageIndexClickListener getOnPageIndexClickListener() {
        return onPageIndexClickListener;
    }

    public void setOnPageIndexClickListener(OnPageIndexClickListener onPageIndexClickListener) {
        this.onPageIndexClickListener = onPageIndexClickListener;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_next:
                onPageIndexClickListener.onNextClick(PAGE_TAG);
                break;
        }
    }
}
