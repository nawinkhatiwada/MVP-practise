package com.example.brain.mvp_practise.auth.register;

import android.os.AsyncTask;

import com.example.brain.mvp_practise.auth.AuthRequest;

import java.util.Random;

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
        view.showRegisterProgress();
        new AsyncTask<Void,Void,Void>(){

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
                    view.showRegisterError();
                } else {
                    view.showRegisterSuccess();
                }
            }
        }.execute();
    }

    @Override
    public void openMain() {
        authRequest.requestMain();
    }

    @Override
    public void setAuthRequest(AuthRequest authRequest) {
        this.authRequest = authRequest;
    }
}
