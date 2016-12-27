package com.example.brain.mvp_practise.auth.register;

import com.example.brain.mvp_practise.auth.AuthRequest;

/**
 * Created by brain on 12/26/16.
 */

public class RegisterPresenter implements RegisterContract.Presenter {
    private RegisterContract.View view;
    private AuthRequest authRequest;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void doRegister(String name, String email, String password) {

    }

    @Override
    public void setAuthRequest(AuthRequest authRequest) {
        this.authRequest = authRequest;
    }
}
