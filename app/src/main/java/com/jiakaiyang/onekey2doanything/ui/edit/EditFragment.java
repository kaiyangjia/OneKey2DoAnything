package com.jiakaiyang.onekey2doanything.ui.edit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jiakaiyang.onekey2doanything.R;
import com.jiakaiyang.onekey2doanything.ui.base.BaseFragment;
import com.jiakaiyang.onekey2doanything.ui.base.OnPageIndexClickListener;

/**
 * 用于编辑已经添加的command的页面
 */

public class EditFragment extends BaseFragment
        implements EditContract.View
        , View.OnClickListener{
    public static final String PAGE_TAG = "EditPage";

    private OnPageIndexClickListener onPageIndexClickListener;

    private Button btnPre;


    public static EditFragment newInstance(){
        return new EditFragment();
    }


    @Override
    public void initView(){
        btnPre = (Button) rootView.findViewById(R.id.btn_pre);
        btnPre.setOnClickListener(this);
    }


    @Override
    public void setPresenter(EditContract.Presenter presenter) {

    }

    public OnPageIndexClickListener getOnPageIndexClickListener() {
        return onPageIndexClickListener;
    }

    public void setOnPageIndexClickListener(OnPageIndexClickListener onPageIndexClickListener) {
        this.onPageIndexClickListener = onPageIndexClickListener;
    }

    @Override
    public int getRootViewRes() {
        return R.layout.command_edit_frg;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pre:
                onPageIndexClickListener.onPreClick(PAGE_TAG);
                break;
        }
    }
}
