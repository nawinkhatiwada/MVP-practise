package com.example.brain.mvp_practise.auth.register;

import com.example.brain.mvp_practise.BasePresenter;
import com.example.brain.mvp_practise.BaseView;

/**
 * Created by brain on 12/26/16.
 */

interface RegisterContract {

    interface View extends BaseView<Presenter> {
        void showRegisterSuccess();
        void showRegisterError();
    }

    interface Presenter extends BasePresenter {
        void doRegister(String name, String email, String password);
    }
}
