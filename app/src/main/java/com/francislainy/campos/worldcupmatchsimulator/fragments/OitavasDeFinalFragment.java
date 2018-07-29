package com.francislainy.campos.worldcupmatchsimulator.fragments;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.francislainy.campos.worldcupmatchsimulator.R;
import com.francislainy.campos.worldcupmatchsimulator.adapter.MatchAdapter;
import com.francislainy.campos.worldcupmatchsimulator.database.Match;
import com.francislainy.campos.worldcupmatchsimulator.database.Team;
import com.francislainy.campos.worldcupmatchsimulator.database.TeamDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

// import com.francislainy.campos.worldcupmatchsimulator.database.MatchDatabase;

public class OitavasDeFinalFragment extends Fragment {

    @BindView(R.id.rv)
    RecyclerView rv;

    private static final String DATABASE_NAME = "teams_db";
    private TeamDatabase teamDatabase;

    final Team[] firstGroupA = {null};
    final Team[] secondGroupB = {null};
    final Team[] firstGroupC = {null};
    final Team[] secondGroupD = {null};
    final Team[] firstGroupE = {null};
    final Team[] secondGroupF = {null};
    final Team[] firstGroupG = {null};
    final Team[] secondGroupH = {null};
    final Team[] firstGroupB = {null};
    final Team[] secondGroupA = {null};
    final Team[] firstGroupD = {null};
    final Team[] secondGroupC = {null};
    final Team[] firstGroupF = {null};
    final Team[] secondGroupE = {null};
    final Team[] firstGroupH = {null};
    final Team[] secondGroupG = {null};


    public OitavasDeFinalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_oitavas_de_final, container, false);

        ButterKnife.bind(this, view);


        teamDatabase = Room.databaseBuilder(getContext(), TeamDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {

                firstGroupA[0] = teamDatabase.daoAccess().selectTeamByPosition("A", 1);
                secondGroupB[0] = teamDatabase.daoAccess().selectTeamByPosition("B", 2);
                firstGroupC[0] = teamDatabase.daoAccess().selectTeamByPosition("C", 1);
                secondGroupD[0] = teamDatabase.daoAccess().selectTeamByPosition("D", 2);
                firstGroupE[0] = teamDatabase.daoAccess().selectTeamByPosition("E", 1);
                secondGroupF[0] = teamDatabase.daoAccess().selectTeamByPosition("F", 2);
                firstGroupG[0] = teamDatabase.daoAccess().selectTeamByPosition("G", 1);
                secondGroupH[0] = teamDatabase.daoAccess().selectTeamByPosition("H", 2);
                firstGroupB[0] = teamDatabase.daoAccess().selectTeamByPosition("B", 1);
                secondGroupA[0] = teamDatabase.daoAccess().selectTeamByPosition("A", 2);
                firstGroupD[0] = teamDatabase.daoAccess().selectTeamByPosition("D", 1);
                secondGroupC[0] = teamDatabase.daoAccess().selectTeamByPosition("C", 2);
                firstGroupF[0] = teamDatabase.daoAccess().selectTeamByPosition("F", 1);
                secondGroupE[0] = teamDatabase.daoAccess().selectTeamByPosition("E", 2);
                firstGroupH[0] = teamDatabase.daoAccess().selectTeamByPosition("H", 1);
                secondGroupG[0] = teamDatabase.daoAccess().selectTeamByPosition("G", 2);


                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        displayTeams();

                    }
                });

            }
        }).start();


        return view;
    }


    private void displayTeams() {

        MatchAdapter matchAdapter = new MatchAdapter(getActivity());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);
        rv.setNestedScrollingEnabled(false);

        rv.setAdapter(matchAdapter);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        matchAdapter.addItem(new Match(firstGroupA[0].getTeamName(), secondGroupB[0].getTeamName()));
        matchAdapter.addItem(new Match(firstGroupC[0].getTeamName(), secondGroupD[0].getTeamName()));
        matchAdapter.addItem(new Match(firstGroupE[0].getTeamName(), secondGroupF[0].getTeamName()));
        if (secondGroupH[0] != null) {
            matchAdapter.addItem(new Match(firstGroupG[0].getTeamName(), secondGroupH[0].getTeamName()));
        }
        matchAdapter.addItem(new Match(firstGroupB[0].getTeamName(), secondGroupA[0].getTeamName()));
        matchAdapter.addItem(new Match(firstGroupD[0].getTeamName(), secondGroupC[0].getTeamName()));
        matchAdapter.addItem(new Match(firstGroupF[0].getTeamName(), secondGroupE[0].getTeamName()));

        if (firstGroupH[0] != null) {
            matchAdapter.addItem(new Match(firstGroupH[0].getTeamName(), secondGroupG[0].getTeamName()));
        }

    }

}