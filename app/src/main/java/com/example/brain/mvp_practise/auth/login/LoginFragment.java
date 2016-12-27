package com.example.brain.mvp_practise.auth.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.brain.mvp_practise.R;
import com.example.brain.mvp_practise.auth.AuthRequest;
import com.example.brain.mvp_practise.databinding.FragmentLoginBinding;

import static com.example.brain.mvp_practise.utils.PreConditions.checkNotNull;

/**
 * Created by brain on 12/26/16.
 */

public class LoginFragment extends Fragment implements LoginContract.View {
    private LoginContract.Presenter loginPresenter;

    FragmentLoginBinding loginBinding;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        attachLoginButtonClick();
        attachRegisterButtonClick();
        return loginBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AuthRequest) {
            loginPresenter.setAuthRequest((AuthRequest) context);
        }
    }

    @Override
    public void showLoginProgress() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void showLoginSuccess() {
        progressDialog.dismiss();
        Toast.makeText(getActivity(), "Login Success", Toast.LENGTH_LONG).show();
        loginPresenter.openDashBoard();

    }

    @Override
    public void showLoginError() {
        progressDialog.dismiss();
        Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        loginPresenter = checkNotNull(presenter);
    }

    private void attachLoginButtonClick() {
        loginBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = loginBinding.userName.getText().toString();
                String password = loginBinding.password.getText().toString();
                if (TextUtils.isEmpty(username) ||
                        TextUtils.isEmpty(password)) {
                    Toast.makeText(getActivity(), "Cant be Empty", Toast.LENGTH_LONG).show();
                } else {
                    loginPresenter.doLogin(username, password);
                }
            }
        });

    }

    private void attachRegisterButtonClick() {
        loginBinding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.openRegister();
            }
        });
    }
}
