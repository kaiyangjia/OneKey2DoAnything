package com.jiakaiyang.onekey2doanything.ui.common.fragment;

import com.jiakaiyang.onekey2doanything.ui.base.BasePresenter;
import com.jiakaiyang.onekey2doanything.ui.base.BaseView;

/**
 * TypeSelect页面的Contract
 */

public interface TypeSelectContract {
    interface View extends BaseView<Presenter> {

        /**
         * 显示next button,可以进入下一页
         */
        public void showNextBtn();

        /**
         * 隐藏next button
         */
        public void hideNextBtn();
    }


    interface Presenter extends BasePresenter {

    }
}
