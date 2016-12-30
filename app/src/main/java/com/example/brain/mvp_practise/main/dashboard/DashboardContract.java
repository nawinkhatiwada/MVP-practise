package com.example.brain.mvp_practise.main.dashboard;

import com.example.brain.mvp_practise.BasePresenter;
import com.example.brain.mvp_practise.BaseView;
import com.example.brain.mvp_practise.main.MainRequest;

/**
 * Created by nawin on 12/29/16.
 */

public interface DashboardContract {

    interface View extends BaseView<Presenter>{
        void onTabSelected();
    }

    interface Presenter extends BasePresenter{
        void selectTab();
        void setMainRequest(MainRequest mainRequest);
    }
}
