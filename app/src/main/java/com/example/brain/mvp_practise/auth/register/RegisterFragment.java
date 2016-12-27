package com.example.brain.mvp_practise.auth.register;

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
import com.example.brain.mvp_practise.databinding.FragmentRegisterBinding;

import static com.example.brain.mvp_practise.utils.PreConditions.checkNotNull;

/**
 * Created by brain on 12/26/16.
 */

public class RegisterFragment extends Fragment implements RegisterContract.View {
    private RegisterContract.Presenter registerPresenter;
    FragmentRegisterBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);
        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof AuthRequest){
            registerPresenter.setAuthRequest((AuthRequest) context);
        }
    }

    @Override
    public void showRegisterSuccess() {

    }

    @Override
    public void showRegisterError() {

    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        registerPresenter = checkNotNull(presenter);
    }
}
