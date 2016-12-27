package com.example.brain.mvp_practise.auth;

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
import com.example.brain.mvp_practise.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(binding.toolbar);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.mainActivityContainer);
        if (fragment == null ||!(fragment instanceof LoginFragment)) {
            fragment = new LoginFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.mainActivityContainer, fragment)
                    .commit();
        }
        new LoginPresenter((LoginContract.View) fragment);
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
}
