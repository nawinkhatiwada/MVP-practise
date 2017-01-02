package com.example.brain.mvp_practise.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.brain.mvp_practise.MVPBus;
import com.example.brain.mvp_practise.R;
import com.example.brain.mvp_practise.databinding.ActivityMainBinding;
import com.example.brain.mvp_practise.databinding.TabsViewpagerBinding;
import com.example.brain.mvp_practise.main.dashboard.DashboardContract;
import com.example.brain.mvp_practise.main.dashboard.DashboardFragment;
import com.example.brain.mvp_practise.main.dashboard.DashboardPresenter;
import com.example.brain.mvp_practise.main.dashboard.DashboardRequestEvent;
import com.example.brain.mvp_practise.main.message.MessageContract;
import com.example.brain.mvp_practise.main.message.MessageFragment;
import com.example.brain.mvp_practise.main.message.MessagePresenter;
import com.squareup.otto.Subscribe;

/**
 * Created by brain on 12/27/16.
 */

public class MainActivity extends AppCompatActivity  {
    ActivityMainBinding binding;
    TabsViewpagerBinding content;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        this.content = binding.content;
        setSupportActionBar(content.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }
        requestDashBoard(null);
        drawerLayout = binding.drawerLayout;
        setupDrawerContent(binding.navView);
    }

    private void setupDrawerContent(NavigationView navView) {
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        switch (menuItem.getItemId()) {
                            case R.id.nav_dashboard:
                              requestDashBoard(null);
                                break;
                            case R.id.nav_messages:
                                requestMessage(null);
                                drawerLayout.closeDrawer(GravityCompat.START);
                                break;
                        }
                        return true;
                    }
                });
    }


    @Override
    protected void onResume() {
        super.onResume();
        MVPBus.getInstance().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MVPBus.getInstance().unregister(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Subscribe
    public void requestDashBoard(Events.DashBoardRequest event) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mainContainer);
            if (fragment == null || !(fragment instanceof DashboardFragment)) {
                fragment = new DashboardFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment)
                        .commit();
                content.tvTitle.setText(getResources().getString(R.string.dashboard));
            }
            new DashboardPresenter((DashboardContract.View) fragment);
        }



    @Subscribe
    public void requestMessage(Events.MessageRequest event) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mainContainer);
        if (fragment == null || !(fragment instanceof MessageFragment)) {
            fragment = new MessageFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment)
                    .commit();
            content.tvTitle.setText(getResources().getString(R.string.message));
        }
        new MessagePresenter((MessageContract.View) fragment);
    }


}
