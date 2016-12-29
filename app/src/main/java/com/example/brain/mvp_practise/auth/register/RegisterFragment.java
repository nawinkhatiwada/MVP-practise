package com.example.brain.mvp_practise.auth.register;

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
import com.example.brain.mvp_practise.databinding.FragmentRegisterBinding;

import static com.example.brain.mvp_practise.utils.PreConditions.checkNotNull;

/**
 * Created by brain on 12/26/16.
 */

public class RegisterFragment extends Fragment implements RegisterContract.View {
    private RegisterContract.Presenter registerPresenter;
    FragmentRegisterBinding binding;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        attachRegisterButtonClick();
        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof AuthRequest) {
            registerPresenter.setAuthRequest((AuthRequest) context);
        }
    }

    @Override
    public void showRegisterProgress() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void showRegisterSuccess() {
        progressDialog.dismiss();
        Toast.makeText(getActivity(), "Register Success", Toast.LENGTH_LONG).show();
        registerPresenter.openMain();

    }

    @Override
    public void showRegisterError() {
        progressDialog.dismiss();
        Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();

    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        registerPresenter = checkNotNull(presenter);
    }

    private void attachRegisterButtonClick() {
        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.name.getText().toString();
                String username = binding.userName.getText().toString();
                String password = binding.password.getText().toString();

                if (TextUtils.isEmpty(name) ||
                        TextUtils.isEmpty(username) ||
                        TextUtils.isEmpty(password)) {
                    Toast.makeText(getActivity(), "Cant be empty", Toast.LENGTH_LONG).show();
                } else {
                    registerPresenter.doRegister(name, username, password);
                }
            }
        });
    }
}
