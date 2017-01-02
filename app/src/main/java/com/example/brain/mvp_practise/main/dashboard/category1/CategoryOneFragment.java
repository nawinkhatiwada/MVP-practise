package com.example.brain.mvp_practise.main.dashboard.category1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brain.mvp_practise.R;

/**
 * Created by brain on 12/30/16.
 */

public class CategoryOneFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category_one,container,false);
    }
}
