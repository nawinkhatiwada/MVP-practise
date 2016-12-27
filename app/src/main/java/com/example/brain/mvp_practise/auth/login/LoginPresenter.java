package com.example.brain.mvp_practise.auth.login;

import android.os.AsyncTask;

import com.example.brain.mvp_practise.auth.AuthRequest;

import java.util.Random;

/**
 * Created by brain on 12/26/16.
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View view;
    private AuthRequest authRequest;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }


    @Override
    public void doLogin(String username, String password) {
        view.showLoginProgress();
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                Random random = new Random();
                int num = random.nextInt(100);
                if (num < 50) {
                    view.showLoginError();
                } else {
                    view.showLoginSuccess();
                }
            }
        }.execute();

    }

    @Override
    public void openRegister() {
        authRequest.requestRegister();
    }

    @Override
    public void openLogin() {
        authRequest.requestLogin();
    }

    @Override
    public void openDashBoard() {
        authRequest.requestDashboard();
    }

    @Override
    public void setAuthRequest(AuthRequest authRequest) {
        this.authRequest = authRequest;
    }

    @Override
    public void start() {

    }
}
