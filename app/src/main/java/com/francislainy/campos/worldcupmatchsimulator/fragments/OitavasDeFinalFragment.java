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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.francislainy.campos.worldcupmatchsimulator.R;
import com.francislainy.campos.worldcupmatchsimulator.adapter.MatchAdapter;
import com.francislainy.campos.worldcupmatchsimulator.database.Match;
import com.francislainy.campos.worldcupmatchsimulator.database.MatchDatabase;
import com.francislainy.campos.worldcupmatchsimulator.database.Team;
import com.francislainy.campos.worldcupmatchsimulator.database.TeamDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

// import com.francislainy.campos.worldcupmatchsimulator.database.MatchDatabase;

public class OitavasDeFinalFragment extends Fragment {


    @BindView(R.id.tv_first_group_a)
    TextView tvFirstGroupA;
    @BindView(R.id.tv_second_group_b)
    TextView tvSecondGroupB;
    @BindView(R.id.tv_first_group_c)
    TextView tvFirstGroupC;
    @BindView(R.id.tv_second_group_d)
    TextView tvSecondGroupD;
    @BindView(R.id.tv_first_group_e)
    TextView tvFirstGroupE;
    @BindView(R.id.tv_second_group_f)
    TextView tvSecondGroupF;
    @BindView(R.id.tv_first_group_g)
    TextView tvFirstGroupG;
    @BindView(R.id.tv_second_group_h)
    TextView tvSecondGroupH;
    @BindView(R.id.tv_first_group_b)
    TextView tvFirstGroupB;
    @BindView(R.id.tv_second_group_a)
    TextView tvSecondGroupA;
    @BindView(R.id.tv_first_group_d)
    TextView tvFirstGroupD;
    @BindView(R.id.tv_second_group_c)
    TextView tvSecondGroupC;
    @BindView(R.id.tv_first_group_f)
    TextView tvFirstGroupF;
    @BindView(R.id.tv_second_group_e)
    TextView tvSecondGroupE;
    @BindView(R.id.tv_first_group_h)
    TextView tvFirstGroupH;
    @BindView(R.id.tv_second_group_g)
    TextView tvSecondGroupG;

    @BindView(R.id.rd_match1)
    RadioGroup rdMatch1;
    @BindView(R.id.rd_match1_team1)
    RadioButton rdMatch1Team1;
    @BindView(R.id.rd_match1_team2)
    RadioButton rdMatch1Team2;
    @BindView(R.id.rd_match2_team1)
    RadioButton rdMatch2Team1;
    @BindView(R.id.rd_match2_team2)
    RadioButton rdMatch2Team2;
    @BindView(R.id.rd_match3_team1)
    RadioButton rdMatch3Team1;
    @BindView(R.id.rd_match3_team2)
    RadioButton rdMatch3Team2;
    @BindView(R.id.rd_match4_team1)
    RadioButton rdMatch4Team1;
    @BindView(R.id.rd_match4_team2)
    RadioButton rdMatch4Team2;
    @BindView(R.id.rd_match5_team1)
    RadioButton rdMatch5Team1;
    @BindView(R.id.rd_match5_team2)
    RadioButton rdMatch5Team2;
    @BindView(R.id.rd_match6_team1)
    RadioButton rdMatch6Team1;
    @BindView(R.id.rd_match6_team2)
    RadioButton rdMatch6Team2;
    @BindView(R.id.rd_match7_team1)
    RadioButton rdMatch7Team1;
    @BindView(R.id.rd_match7_team2)
    RadioButton rdMatch7Team2;
    @BindView(R.id.rd_match8_team1)
    RadioButton rdMatch8Team1;
    @BindView(R.id.rd_match8_team2)
    RadioButton rdMatch8Team2;

    @BindView(R.id.rv)
    RecyclerView rv;


    private static final String DATABASE_NAME = "teams_db";
    private TeamDatabase teamDatabase;
    // private static final String DATABASE_NAME = "teams_db";
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
                        tvFirstGroupA.setText(firstGroupA[0].getTeamName());
                        tvSecondGroupB.setText(secondGroupB[0].getTeamName());
                        tvFirstGroupC.setText(firstGroupC[0].getTeamName());
                        tvSecondGroupD.setText(secondGroupD[0].getTeamName());
                        tvFirstGroupE.setText(firstGroupE[0].getTeamName());
                        tvSecondGroupF.setText(secondGroupF[0].getTeamName());
                        tvFirstGroupG.setText(firstGroupG[0].getTeamName());
                        tvSecondGroupH.setText(secondGroupH[0].getTeamName());
                        tvFirstGroupB.setText(firstGroupB[0].getTeamName());
                        tvSecondGroupA.setText(secondGroupA[0].getTeamName());
                        tvFirstGroupD.setText(firstGroupD[0].getTeamName());
                        tvSecondGroupC.setText(secondGroupC[0].getTeamName());
                        tvFirstGroupF.setText(firstGroupF[0].getTeamName());
                        tvSecondGroupE.setText(secondGroupE[0].getTeamName());
                        tvFirstGroupH.setText(firstGroupH[0].getTeamName());
                        tvSecondGroupG.setText(secondGroupG[0].getTeamName());

                        displayTeams();

                    }
                });

            }
        }).start();


        matchDatabase = Room.databaseBuilder(getContext(), MatchDatabase.class, "match_result")
                .fallbackToDestructiveMigration()
                .build();


        addDataToMatchDatabase();


        final int[] selectedId = {0};


        rdMatch1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                selectedId[0] = rdMatch1.getCheckedRadioButtonId();

                Team team = null;

                if (selectedId[0] == R.id.rd_match1_team1) {
                    Toast.makeText(getContext(), "radio1", Toast.LENGTH_SHORT).show();

                    team = firstGroupA[0];

                } else if (selectedId[0] == R.id.rd_match1_team2) {
                    Toast.makeText(getContext(), "radio2", Toast.LENGTH_SHORT).show();

                    team = secondGroupB[0];
                }

                final Team finalTeam = team;
                new Thread(new Runnable() {
                    @Override
                    public void run() {


                        if (firstGroupA[0] != null) {

                            Match match1 = new Match();
                            // match1.setMatchWinner(finalTeam.getTeamId());
                            // match1.setMatchLabel("Match 1");


                            // matchDatabase.matchDaoAccess().insertSingleMatchWinner(match1);
                        }


                    }
                }).start();


            }
        });


        return view;
    }


    private void addDataToMatchDatabase() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                if (firstGroupA[0] != null && secondGroupB[0] != null) {

                    Match match1 = new Match();
                    match1.setTeam1(firstGroupA[0].getTeamName());
                    match1.setTeam1(secondGroupB[0].getTeamName());

                    match1.setMatchLabel("Match Fran");


                    matchDatabase.matchDaoAccess().insertSingleMatchWinner(match1);
                }


            }
        }).start();

    }


    private void displayTeams() {

        MatchAdapter matchAdapter = new MatchAdapter(getActivity());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(layoutManager);
        rv.setNestedScrollingEnabled(false);

        rv.setAdapter(matchAdapter);

        // Team team = new Team();
        // team.setTeamName("Fran");

        // matchAdapter.addItem(team);

        matchAdapter.addItem(new Match(firstGroupA[0].getTeamName(), secondGroupB[0].getTeamName()));
        matchAdapter.addItem(new Match(firstGroupC[0].getTeamName(), secondGroupD[0].getTeamName()));
        matchAdapter.addItem(new Match(firstGroupE[0].getTeamName(), secondGroupF[0].getTeamName()));
        matchAdapter.addItem(new Match(firstGroupG[0].getTeamName(), secondGroupH[0].getTeamName()));
        matchAdapter.addItem(new Match(firstGroupB[0].getTeamName(), secondGroupA[0].getTeamName()));
        matchAdapter.addItem(new Match(firstGroupD[0].getTeamName(), secondGroupC[0].getTeamName()));
        matchAdapter.addItem(new Match(firstGroupF[0].getTeamName(), secondGroupE[0].getTeamName()));
        matchAdapter.addItem(new Match(firstGroupH[0].getTeamName(), secondGroupG[0].getTeamName()));




        // matchAdapter.addItem(firstGroupA[0]);
        // matchAdapter.addItem(secondGroupB[0]);
        // matchAdapter.addItem(firstGroupC[0]);
        // matchAdapter.addItem(secondGroupD[0]);
        // matchAdapter.addItem(firstGroupE[0]);
        // matchAdapter.addItem(secondGroupF[0]);
        // matchAdapter.addItem(firstGroupG[0]);
        // matchAdapter.addItem(secondGroupH[0]);
        // matchAdapter.addItem(firstGroupB[0]);
        // matchAdapter.addItem(secondGroupA[0]);
        // matchAdapter.addItem(firstGroupD[0]);
        // matchAdapter.addItem(secondGroupC[0]);
        // matchAdapter.addItem(firstGroupF[0]);
        // matchAdapter.addItem(secondGroupE[0]);
        // matchAdapter.addItem(firstGroupH[0]);
        // matchAdapter.addItem(secondGroupG[0]);

    }

}