package com.example.brain.mvp_practise.main.message;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brain.mvp_practise.R;
import com.example.brain.mvp_practise.databinding.FragmentMessageBinding;
import com.example.brain.mvp_practise.main.MainRequest;

import static com.example.brain.mvp_practise.utils.PreConditions.checkNotNull;

/**
 * Created by brain on 12/30/16.
 */

public class MessageFragment extends Fragment implements MessageContract.View {
    MessageContract.Presenter messagePresenter;
    FragmentMessageBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_message,container,false);
        return binding.getRoot();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MainRequest){
            messagePresenter.setMainRequest((MainRequest) context);
        }
    }

    @Override
    public void setPresenter(MessageContract.Presenter presenter) {
        this.messagePresenter = checkNotNull(presenter);
    }

    @Override
    public void test() {

    }
}
