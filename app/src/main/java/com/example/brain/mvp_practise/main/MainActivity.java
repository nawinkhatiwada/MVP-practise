package com.example.brain.mvp_practise.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.brain.mvp_practise.R;
import com.example.brain.mvp_practise.databinding.ActivityMainBinding;
import com.example.brain.mvp_practise.databinding.TabsViewpagerBinding;

/**
 * Created by brain on 12/27/16.
 */

public class MainActivity extends AppCompatActivity implements MainContract.View {
    ActivityMainBinding binding;
    TabsViewpagerBinding content;
    private MainContract.Presenter mainPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        this.content = binding.content;
        setSupportActionBar(content.toolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void showDashBoard() {

    }

    @Override
    public void showMessage() {

    }

    @Override
    public void showFriend() {

    }

    @Override
    public void showDiscussion() {

    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.mainPresenter = presenter;
    }
}
