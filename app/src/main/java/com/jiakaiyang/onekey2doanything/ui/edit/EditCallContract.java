package com.jiakaiyang.onekey2doanything.ui.edit;

import android.content.Context;

import com.jiakaiyang.onekey2doanything.ui.base.BasePresenter;
import com.jiakaiyang.onekey2doanything.ui.base.BaseView;

/**
 * Edit页面的接口协议
 */

public interface EditCallContract {
    interface View extends BaseView<Presenter> {
        public Context getViewContext();

        public String getName();

        public String getDesc();

        public String getNumber();

        public void setName(String name);

        public void setDesc(String desc);

        public void setNumber(String number);
    }


    interface Presenter extends BasePresenter {
        public  void createShortcut();
    }
}
