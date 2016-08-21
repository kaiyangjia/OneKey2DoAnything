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

    @Override
    public int getRootViewRes() {
        return R.layout.shortcuts_frg;
    }
}
