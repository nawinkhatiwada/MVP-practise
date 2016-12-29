package com.example.brain.mvp_practise.main.dashboard;

import com.example.brain.mvp_practise.main.MainRequest;

/**
 * Created by nawin on 12/29/16.
 */

public class DashboardPresenter implements DashboardContract.Presenter {
    private DashboardContract.View view;
    private MainRequest mainRequest;

    public DashboardPresenter(DashboardContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void selectTab() {
        view.onTabSelected();
    }

    @Override
    public void initDashboard() {
//        mainRequest.requestDashBoard();
    }

    @Override
    public void setMainRequest(MainRequest mainRequest) {
        this.mainRequest = mainRequest;
    }

}
