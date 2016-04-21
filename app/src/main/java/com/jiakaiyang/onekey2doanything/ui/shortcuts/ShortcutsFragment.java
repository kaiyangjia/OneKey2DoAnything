package com.jiakaiyang.onekey2doanything.ui.shortcuts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiakaiyang.onekey2doanything.R;
import com.jiakaiyang.onekey2doanything.ui.base.BaseFragment;

/**
 * shortcut 列表界面
 */
public class ShortcutsFragment extends BaseFragment{
    public static ShortcutsFragment newInstance() {
        return new ShortcutsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = LayoutInflater.from(getContext()).inflate(R.layout.shortcuts_frg, null);
        return root;
    }
}
