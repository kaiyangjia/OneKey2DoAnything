package com.jiakaiyang.onekey2doanything.ui.help;

import com.jiakaiyang.onekey2doanything.R;
import com.jiakaiyang.onekey2doanything.ui.base.BaseFragment;

/**
 * 帮助页面
 */

public class HelpFragment extends BaseFragment{

    public static HelpFragment newInstance(){
        return new HelpFragment();
    }


    @Override
    public int getRootViewRes() {
        return R.layout.help_frg;
    }
}
