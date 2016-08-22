package com.jiakaiyang.onekey2doanything.ui.feedback;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.google.common.base.Strings;
import com.jiakaiyang.onekey2doanything.R;
import com.jiakaiyang.onekey2doanything.ui.base.BaseFragment;
import com.jiakaiyang.onekey2doanything.utils.PropertiesUtils;

/**
 * Created by jia on 16/8/22.
 */

public class FeedbackFragment extends BaseFragment
        implements View.OnClickListener{
    private EditText feedbackContentView;

    private EditText emailView;


    public static FeedbackFragment newInstance(){
        return new FeedbackFragment();
    }

    @Override
    public int getRootViewRes() {
        return R.layout.feedback_frg;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String leanCloudAppId = PropertiesUtils.readLocalProperties(getActivity().getAssets(), "leanCloudAppId");
        String leanCloudAppKey = PropertiesUtils.readLocalProperties(getActivity().getAssets(), "leanCloudAppKey");
        AVOSCloud.useAVCloudUS();
        AVOSCloud.initialize(getActivity(), leanCloudAppId, leanCloudAppKey);
    }

    @Override
    public void initView() {
        super.initView();
        rootView.findViewById(R.id.btn_done).setOnClickListener(this);

        feedbackContentView = (EditText) rootView.findViewById(R.id.feedback_content);
        emailView = (EditText) rootView.findViewById(R.id.email);
    }

    @Override
    public void onClick(View v) {
        if(Strings.isNullOrEmpty(feedbackContentView.getText().toString())){
            feedbackContentView.setError(getResources().getString(R.string.feedback_cant_null));
        }else{
            AVObject feedback = new AVObject("Feedback");
            feedback.put("feedback", feedbackContentView.getText().toString());
            feedback.put("email", emailView.getText().toString());
            feedback.saveInBackground();

            Snackbar.make(rootView.findViewById(android.R.id.content)
                    , getResources().getString(R.string.feedback_success)
                    , Snackbar.LENGTH_LONG).show();
        }
    }
}
