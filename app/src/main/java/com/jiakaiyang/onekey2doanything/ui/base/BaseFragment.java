package com.jiakaiyang.onekey2doanything.ui.base;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiakaiyang.onekey2doanything.R;

/**
 * Base Fragment
 */
public abstract class BaseFragment extends DialogFragment {
    protected View rootView;

    public abstract int getRootViewRes();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(getRootViewRes(), null);
        initView();
        return rootView;
    }

    public void initView(){

    }
}
