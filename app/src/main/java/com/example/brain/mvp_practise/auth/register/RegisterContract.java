package com.example.brain.mvp_practise.auth.register;

import android.content.Context;

import com.example.brain.mvp_practise.BasePresenter;
import com.example.brain.mvp_practise.BaseView;
import com.example.brain.mvp_practise.auth.AuthRequest;

/**
 * Created by brain on 12/26/16.
 */

public interface RegisterContract {

    interface View extends BaseView<Presenter> {
        void showRegisterProgress();
        void showRegisterSuccess();
        void showRegisterError();
    }

    interface Presenter extends BasePresenter {
        void doRegister(String name, String email, String password);
        void openMain();
        void setAuthRequest(AuthRequest authRequest);
    }
}
