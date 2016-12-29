package com.example.brain.mvp_practise.main;

/**
 * Created by brain on 12/28/16.
 */

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void requestDashBoard() {
        view.showDashBoard();
    }

    @Override
    public void requestMessage() {
        view.showMessage();
    }

    @Override
    public void requestFriend() {
        view.showFriend();
    }

    @Override
    public void requestDiscussion() {
        view.showDiscussion();
    }

}
