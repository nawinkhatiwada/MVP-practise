package com.example.brain.mvp_practise.auth.login;

import com.example.brain.mvp_practise.BasePresenter;
import com.example.brain.mvp_practise.BaseView;
import com.example.brain.mvp_practise.auth.AuthRequest;

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
        void openLogin();
        void openDashBoard();
        void openRegister();
        void setAuthRequest(AuthRequest authRequest);
    }
}
