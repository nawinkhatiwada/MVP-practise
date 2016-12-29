package com.example.brain.mvp_practise.auth;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.brain.mvp_practise.R;
import com.example.brain.mvp_practise.auth.login.LoginContract;
import com.example.brain.mvp_practise.auth.login.LoginFragment;
import com.example.brain.mvp_practise.auth.login.LoginPresenter;
import com.example.brain.mvp_practise.auth.register.RegisterContract;
import com.example.brain.mvp_practise.auth.register.RegisterFragment;
import com.example.brain.mvp_practise.auth.register.RegisterPresenter;
import com.example.brain.mvp_practise.main.MainActivity;
import com.example.brain.mvp_practise.databinding.ActivityAuthBinding;

public class AuthActivity extends AppCompatActivity implements AuthRequest {
    ActivityAuthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth);
        requestLogin();
        setSupportActionBar(binding.toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void requestLogin() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mainActivityContainer);
        if (fragment == null || !(fragment instanceof LoginFragment)) {
            fragment = new LoginFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.mainActivityContainer, fragment)
                    .commit();
        }
        new LoginPresenter((LoginContract.View) fragment);
    }

    @Override
    public void requestRegister() {

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mainActivityContainer);
        if (fragment == null || !(fragment instanceof RegisterFragment)) {
            fragment = new RegisterFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.mainActivityContainer, fragment)
                    .commit();
        }
        new RegisterPresenter((RegisterContract.View) fragment);
    }

    @Override
    public void requestMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().findFragmentById(R.id.mainActivityContainer) instanceof RegisterFragment) {
            requestLogin();
        } else {
            super.onBackPressed();
        }
    }
}
