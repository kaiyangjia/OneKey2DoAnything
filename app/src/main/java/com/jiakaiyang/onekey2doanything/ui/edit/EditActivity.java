package com.jiakaiyang.onekey2doanything.ui.edit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;

import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import com.jiakaiyang.onekey2doanything.R;
import com.jiakaiyang.onekey2doanything.ui.base.BaseActivity;
import com.jiakaiyang.onekey2doanything.ui.base.CommonFragmentPagerAdapter;
import com.jiakaiyang.onekey2doanything.ui.base.OnPageIndexClickListener;
import com.jiakaiyang.onekey2doanything.ui.common.fragment.TypeSelectFragment;
import com.jiakaiyang.onekey2doanything.utils.ActivityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 编辑command的页面
 */

public class EditActivity extends BaseActivity
        implements OnPageIndexClickListener{
    //表示启动着希望该Activity打开创建新command的模式
    public static final int ACTIVTY_FLAG_CREATE = 1;
    //表示启动者希望该Activity打开编辑已有的command的模式
    public static final int ACTVITY_FLAG_EDIT = 2;

    private ViewPager mViewPager;
    private CommonFragmentPagerAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_act);


        initView();
    }

    private void initView(){
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        // 设置viewPager不可滑动
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        if(mActivityFlag == 0){
            //默认值
            mActivityFlag = ACTIVTY_FLAG_CREATE;
        }

        List<Fragment> fragments = new ArrayList<>();
        TypeSelectFragment typeSelectFragment = null;

        EditFragment editFragment = null;
        switch (mActivityFlag){
            case ACTVITY_FLAG_EDIT:
                editFragment = EditFragment.newInstance();
                fragments.add(editFragment);
                break;
            case ACTIVTY_FLAG_CREATE:
            default:
                typeSelectFragment = TypeSelectFragment.newInstance();
                typeSelectFragment.setOnPageIndexClickListener(this);
                editFragment = EditFragment.newInstance();
                editFragment.setOnPageIndexClickListener(this);
                fragments.add(typeSelectFragment);
                fragments.add(editFragment);
                break;
        }

        mAdapter = new CommonFragmentPagerAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void onPreClick(String pageTag) {
        switch (pageTag){
            case EditFragment.PAGE_TAG:
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() - 1);
                break;
        }
    }

    @Override
    public void onNextClick(String pageTag) {
        switch (pageTag){
            case TypeSelectFragment.PAGE_TAG:
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                break;
        }
    }
}
