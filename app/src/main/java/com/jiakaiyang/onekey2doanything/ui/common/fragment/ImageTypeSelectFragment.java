package com.jiakaiyang.onekey2doanything.ui.common.fragment;

import android.widget.RadioGroup;

import com.jiakaiyang.onekey2doanything.R;
import com.jiakaiyang.onekey2doanything.ui.base.BaseFragment;

/**
 * Created by jia on 16/8/23.
 */

public class ImageTypeSelectFragment extends BaseFragment {
    private RadioGroup radioGroup;

    public static final int radioGroupId = R.id.radio_group;

    public static final int radioButtonCameraId = R.id.radio_btn_camera;

    public static final int radioButtonGalleryId = R.id.radio_btn_gallery;

    public static ImageTypeSelectFragment newInstance(){
        return new ImageTypeSelectFragment();
    }


    @Override
    public int getRootViewRes() {
        return R.layout.dialog_select_image_type;
    }


    @Override
    public void initView() {
        super.initView();
        radioGroup = (RadioGroup) rootView.findViewById(R.id.radio_group);
    }

    public RadioGroup getRadioGroup() {
        return radioGroup;
    }
}
