package com.francislainy.campos.worldcupmatchsimulator.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.francislainy.campos.worldcupmatchsimulator.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Francislainy on 29/07/2018.
 */

public class ConfirmFragment extends Fragment {

    @BindView(R.id.btn_next)
    Button btnNext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm, container, false);

        ButterKnife.bind(this, view);


        // Listeners
        btnNext.setOnClickListener(onClickNext);

        return view;
    }


    private View.OnClickListener onClickNext = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // FragmentManager fm getActivity().getSupportFragmentManager();
            // FragmentTransaction transaction = fm.beginTransaction();
             //todo: replace fragment having maybe another activity if can't use replace together with the view pager already in place


        }
    };


}
