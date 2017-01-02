package com.example.brain.mvp_practise.main.dashboard;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brain.mvp_practise.MVPBus;
import com.example.brain.mvp_practise.R;
import com.example.brain.mvp_practise.auth.AuthRequest;
import com.example.brain.mvp_practise.databinding.FragmentDashboardBinding;
import com.example.brain.mvp_practise.main.MainRequest;
import com.example.brain.mvp_practise.main.dashboard.category1.CategoryOneFragment;

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false);
        if (binding.viewpager != null) {
            setupViewPager(binding.viewpager);

        }
        binding.tabs.setupWithViewPager(binding.viewpager);
        return binding.getRoot();
    }

    private void setupViewPager(ViewPager viewpager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new CategoryOneFragment(), "Category 1");
        adapter.addFragment(new CategoryOneFragment(), "Category 2");
        viewpager.setAdapter(adapter);
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

        binding.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void setPresenter(DashboardContract.Presenter presenter) {
        dashboardPresenter = checkNotNull(presenter);
    }
}
