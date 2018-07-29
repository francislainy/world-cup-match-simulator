package com.francislainy.campos.worldcupmatchsimulator.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.francislainy.campos.worldcupmatchsimulator.R;

import butterknife.ButterKnife;

/**
 * Created by Francislainy on 29/07/2018.
 */

public class ConfirmFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm, container, false);

        ButterKnife.bind(this, view);

        return view;
    }



}
