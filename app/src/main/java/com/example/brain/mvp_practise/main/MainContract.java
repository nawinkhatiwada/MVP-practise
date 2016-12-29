package com.example.brain.mvp_practise.main;

import com.example.brain.mvp_practise.BasePresenter;
import com.example.brain.mvp_practise.BaseView;

/**
 * Created by brain on 12/28/16.
 */

public interface MainContract {

    interface View extends BaseView<Presenter>{
        void showDashBoard();
        void showMessage();
        void showFriend();
        void showDiscussion();
    }
    interface Presenter extends BasePresenter{
        void requestDashBoard();
        void requestMessage();
        void requestFriend();
        void requestDiscussion();
    }
}
