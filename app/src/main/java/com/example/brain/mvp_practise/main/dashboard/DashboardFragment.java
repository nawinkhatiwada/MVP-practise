package com.example.brain.mvp_practise.main.dashboard;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brain.mvp_practise.R;
import com.example.brain.mvp_practise.auth.AuthRequest;
import com.example.brain.mvp_practise.databinding.FragmentDashboardBinding;
import com.example.brain.mvp_practise.main.MainRequest;

import static com.example.brain.mvp_practise.utils.PreConditions.checkNotNull;

/**
 * Created by nawin on 12/29/16.
 */

public class DashboardFragment extends Fragment implements DashboardContract.View {
    private DashboardContract.Presenter dashboardPresenter;
    FragmentDashboardBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding  = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard,container,false);
        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainRequest) {
            dashboardPresenter.setMainRequest((MainRequest) context);
        }
    }
    @Override
    public void onTabSelected() {

    }

    @Override
    public void setPresenter(DashboardContract.Presenter presenter) {
        dashboardPresenter = checkNotNull(presenter);
    }
}
