package com.jiakaiyang.onekey2doanything.ui.shortcuts;

import com.jiakaiyang.onekey2doanything.ui.base.BasePresenter;
import com.jiakaiyang.onekey2doanything.ui.base.BaseView;

/**
 * 用于view 和 presenter 之间交互的一组接口,这些借口正是业务逻辑的抽象
 */
public interface ShortcutsContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

    }
}
