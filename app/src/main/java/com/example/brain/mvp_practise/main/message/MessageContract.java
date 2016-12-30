package com.example.brain.mvp_practise.main.message;

import com.example.brain.mvp_practise.BasePresenter;
import com.example.brain.mvp_practise.BaseView;
import com.example.brain.mvp_practise.main.MainRequest;

/**
 * Created by brain on 12/30/16.
 */

public interface MessageContract {

    interface View extends BaseView<Presenter>{
        void test();
    }

    interface Presenter extends BasePresenter{

        void setMainRequest(MainRequest context);
    }
}
