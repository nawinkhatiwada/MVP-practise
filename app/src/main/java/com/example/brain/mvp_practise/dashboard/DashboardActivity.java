package com.example.brain.mvp_practise.dashboard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.brain.mvp_practise.R;
import com.example.brain.mvp_practise.databinding.ActivityDashboardBinding;

/**
 * Created by brain on 12/27/16.
 */

public class DashboardActivity extends AppCompatActivity{
    ActivityDashboardBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
    }
}
