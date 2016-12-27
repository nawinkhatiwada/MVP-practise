package com.example.brain.mvp_practise.auth.login;

import com.example.brain.mvp_practise.BasePresenter;
import com.example.brain.mvp_practise.BaseView;

/**
 * Created by brain on 12/26/16.
 */

 public interface LoginContract {

     interface View extends BaseView<Presenter>{
        void showLoginProgress();
        void showLoginSuccess();
        void showLoginError();
    }

    interface Presenter extends BasePresenter{
        void doLogin(String username, String password);

    }
}
