package com.francislainy.campos.worldcupmatchsimulator.fragments;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.francislainy.campos.worldcupmatchsimulator.R;
import com.francislainy.campos.worldcupmatchsimulator.database.MatchDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WinnerFragment extends Fragment {

    @BindView(R.id.tv_winner)
    TextView tvWinner;

    MatchDatabase matchDatabase;

    public WinnerFragment() {
        // Required empty public constructor
    }


    public static WinnerFragment newInstance() {

        Bundle args = new Bundle();

        WinnerFragment fragment = new WinnerFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_winner, container, false);

        ButterKnife.bind(this, view);


        matchDatabase = Room.databaseBuilder(getContext(), MatchDatabase.class, "match_result")
                .fallbackToDestructiveMigration()
                .build();

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {

                final String winner1 = matchDatabase.matchDaoAccess().selectMatchWinner(15);

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        tvWinner.setText("The winner is " + winner1);

                    }
                });

            }
        }).start();


        return view;
    }

}