package com.jiakaiyang.onekey2doanything.ui.common.fragment;

import com.jiakaiyang.onekey2doanything.R;
import com.jiakaiyang.onekey2doanything.ui.base.BaseFragment;

/**
 * Created by jia on 16/8/23.
 */

public class ImageTypeSelectFragment extends BaseFragment {


    public static ImageTypeSelectFragment newInstance(){
        return new ImageTypeSelectFragment();
    }


    @Override
    public int getRootViewRes() {
        return R.layout.dialog_select_image_type;
    }
}
