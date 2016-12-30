package com.example.brain.mvp_practise.main.message;

import com.example.brain.mvp_practise.main.MainRequest;

/**
 * Created by brain on 12/30/16.
 */

public class MessagePresenter implements MessageContract.Presenter {
    MessageContract.View view;
    private MainRequest mainRequest;

    public MessagePresenter(MessageContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void setMainRequest(MainRequest mainRequest) {
        this.mainRequest = mainRequest;
    }
}
