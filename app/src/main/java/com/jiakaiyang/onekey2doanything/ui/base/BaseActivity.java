package com.jiakaiyang.onekey2doanything.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jiakaiyang.onekey2doanything.utils.Constants;

/**
 * 所有Activity的父类
 */
public abstract class BaseActivity extends AppCompatActivity {
    //启动者传递的flag,用于告诉被启动的Activity具体要进行什么样的动作
    protected int mActivityFlag;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if(intent.getExtras() != null
            && intent.getExtras().containsKey(Constants.KEY_ACTIVITY_FLAG)){
            mActivityFlag = intent.getIntExtra(Constants.KEY_ACTIVITY_FLAG, 0);
        }
    }
}
