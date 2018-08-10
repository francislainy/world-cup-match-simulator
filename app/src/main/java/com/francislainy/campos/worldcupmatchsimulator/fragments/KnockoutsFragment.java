package com.francislainy.campos.worldcupmatchsimulator.fragments;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.francislainy.campos.worldcupmatchsimulator.R;
import com.francislainy.campos.worldcupmatchsimulator.adapter.MatchAdapter;
import com.francislainy.campos.worldcupmatchsimulator.database.Match;
import com.francislainy.campos.worldcupmatchsimulator.database.MatchDatabase;
import com.francislainy.campos.worldcupmatchsimulator.database.Team;
import com.francislainy.campos.worldcupmatchsimulator.database.TeamDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

// import com.francislainy.campos.worldcupmatchsimulator.database.MatchDatabase;

public class KnockoutsFragment extends Fragment {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.btn_next)
    Button btnNext;

    private static final String DATABASE_NAME = "teams_db";
    private TeamDatabase teamDatabase;
    private MatchDatabase matchDatabase;

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
    private String winner1;
    private String winner2;
    private String winner3;
    private String winner4;
    private String winner5;
    private String winner6;
    private String winner7;
    private String winner8;


    public KnockoutsFragment() {
        // Required empty public constructor
    }

    public static KnockoutsFragment newInstance(String stage) {

        KnockoutsFragment fragment = new KnockoutsFragment();

        Bundle args = new Bundle();
        args.putString("stage", stage);
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_knockouts, container, false);

        ButterKnife.bind(this, view);


        teamDatabase = Room.databaseBuilder(getContext(), TeamDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        matchDatabase = Room.databaseBuilder(getContext(), MatchDatabase.class, "match_result")
                .fallbackToDestructiveMigration()
                .build();

        Bundle bundle = getArguments();
        String stage = "";

        if (bundle != null) {
            stage = bundle.getString("stage");
        }

        if (stage.equals("oitavas")) {

            oitavas();
        } else if (stage.equals("quartas")) {
            quartas();
        }


        // Listeners
        btnNext.setOnClickListener(onClickNext);

        return view;
    }


    private View.OnClickListener onClickNext = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            FragmentManager fm = getActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.container_body, KnockoutsFragment.newInstance("quartas")).commit();

        }
    };


    private void oitavas() {
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


                Match match1 = new Match(1, "1", firstGroupA[0].getTeamName(), firstGroupA[0].getTeamName(), secondGroupB[0].getTeamName());
                Match match2 = new Match(2, "2", firstGroupC[0].getTeamName(), firstGroupC[0].getTeamName(), secondGroupD[0].getTeamName());
                Match match3 = new Match(3, "3", firstGroupE[0].getTeamName(), firstGroupE[0].getTeamName(), secondGroupF[0].getTeamName());
                Match match4 = new Match(4, "4", firstGroupG[0].getTeamName(), firstGroupG[0].getTeamName(), secondGroupH[0].getTeamName());
                Match match5 = new Match(5, "5", firstGroupB[0].getTeamName(), firstGroupB[0].getTeamName(), secondGroupA[0].getTeamName());
                Match match6 = new Match(6, "6", firstGroupD[0].getTeamName(), firstGroupD[0].getTeamName(), secondGroupC[0].getTeamName());
                Match match7 = new Match(7, "7", firstGroupF[0].getTeamName(), firstGroupF[0].getTeamName(), secondGroupE[0].getTeamName());
                Match match8 = new Match(8, "8", firstGroupH[0].getTeamName(), firstGroupH[0].getTeamName(), secondGroupG[0].getTeamName());

                matchDatabase.matchDaoAccess().insertMatch(match1);
                matchDatabase.matchDaoAccess().insertMatch(match2);
                matchDatabase.matchDaoAccess().insertMatch(match3);
                matchDatabase.matchDaoAccess().insertMatch(match4);
                matchDatabase.matchDaoAccess().insertMatch(match5);
                matchDatabase.matchDaoAccess().insertMatch(match6);
                matchDatabase.matchDaoAccess().insertMatch(match7);
                matchDatabase.matchDaoAccess().insertMatch(match8);

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        displayTeams("oitavas");

                    }
                });

            }
        }).start();
    }


    private void quartas() {

        MatchAdapter matchAdapter = new MatchAdapter(getActivity());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);
        rv.setNestedScrollingEnabled(false);

        rv.setAdapter(matchAdapter);

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {

                winner1 = matchDatabase.matchDaoAccess().selectMatchWinner(1);
                winner2 = matchDatabase.matchDaoAccess().selectMatchWinner(2);
                winner3 = matchDatabase.matchDaoAccess().selectMatchWinner(3);
                winner4 = matchDatabase.matchDaoAccess().selectMatchWinner(4);
                winner5 = matchDatabase.matchDaoAccess().selectMatchWinner(5);
                winner6 = matchDatabase.matchDaoAccess().selectMatchWinner(6);
                winner7 = matchDatabase.matchDaoAccess().selectMatchWinner(7);
                winner8 = matchDatabase.matchDaoAccess().selectMatchWinner(8);


                Match match9 = new Match(9, "9", winner1, winner1, winner2); // todo: confirm whether the logic for matches is correct
                Match match10 = new Match(10, "10", winner3, winner3, winner4);
                Match match11 = new Match(11, "11", winner5, winner5, winner6);
                Match match12 = new Match(12, "12", winner7, winner7, winner8);


                matchDatabase.matchDaoAccess().insertMatch(match9);
                matchDatabase.matchDaoAccess().insertMatch(match10);
                matchDatabase.matchDaoAccess().insertMatch(match11);
                matchDatabase.matchDaoAccess().insertMatch(match12);

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        displayTeams("quartas");

                    }
                });

            }
        }).start();
    }


    private void displayTeams(String stage) {

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

        if (stage.equals("oitavas")) {

            matchAdapter.addItem(new Match(1, firstGroupA[0].getTeamName(), secondGroupB[0].getTeamName()));
            matchAdapter.addItem(new Match(2, firstGroupC[0].getTeamName(), secondGroupD[0].getTeamName()));
            matchAdapter.addItem(new Match(3, firstGroupE[0].getTeamName(), secondGroupF[0].getTeamName()));
            matchAdapter.addItem(new Match(4, firstGroupG[0].getTeamName(), secondGroupH[0].getTeamName()));
            matchAdapter.addItem(new Match(5, firstGroupB[0].getTeamName(), secondGroupA[0].getTeamName()));
            matchAdapter.addItem(new Match(6, firstGroupD[0].getTeamName(), secondGroupC[0].getTeamName()));
            matchAdapter.addItem(new Match(7, firstGroupF[0].getTeamName(), secondGroupE[0].getTeamName()));
            matchAdapter.addItem(new Match(8, firstGroupH[0].getTeamName(), secondGroupG[0].getTeamName()));

        } else if (stage.equals("quartas")) {

            matchAdapter.addItem(new Match(9, winner1, winner2)); // todo: set match winner on database
            matchAdapter.addItem(new Match(10, winner3, winner4));
            matchAdapter.addItem(new Match(11, winner5, winner6));
            matchAdapter.addItem(new Match(12, winner7, winner8));

        }

    }

}