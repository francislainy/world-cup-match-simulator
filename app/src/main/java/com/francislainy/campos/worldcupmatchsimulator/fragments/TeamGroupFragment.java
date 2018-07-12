package com.francislainy.campos.worldcupmatchsimulator.fragments;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.francislainy.campos.worldcupmatchsimulator.R;
import com.francislainy.campos.worldcupmatchsimulator.database.Team;
import com.francislainy.campos.worldcupmatchsimulator.database.TeamDatabase;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TeamGroupFragment extends Fragment {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.tv_group_name)
    TextView tvGroupName;

    private static final String DATABASE_NAME = "teams_db";
    private TeamDatabase teamDatabase;


    public TeamGroupFragment() {
        // Required empty public constructor
    }


    public static TeamGroupFragment newInstance(String group) {

        TeamGroupFragment fragment = new TeamGroupFragment();
        Bundle args = new Bundle();
        args.putString("group", group);
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team_group, container, false);

        ButterKnife.bind(this, view);
        teamDatabase = Room.databaseBuilder(getContext(), TeamDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {

                Team team2 = new Team();
                // team2.setTeamId("4");
                team2.setTeamName("Egito20");
                team2.setTeamGroup("Group A");
                // teamDatabase.daoAccess().insertSingleTeam(team2);

                List<Team> teams = new ArrayList<>();

                ArrayList<String> listGroupA = new ArrayList<>();
                listGroupA.add("Russia");
                listGroupA.add("Arabia Saudita");
                listGroupA.add("Egito");
                listGroupA.add("Uruguai");

                for (String teamName : listGroupA) {
                    Team t = new Team();
                    t.setTeamName(teamName);
                    t.setTeamGroup("A");
                    teams.add(t);
                }

                ArrayList<String> listGroupB = new ArrayList<>();
                listGroupB.add("Portugal");
                listGroupB.add("Espanha");
                listGroupB.add("Marrocos");
                listGroupB.add("Ira");

                for (String teamName : listGroupB) {
                    Team t = new Team();
                    t.setTeamName(teamName);
                    t.setTeamGroup("B");
                    teams.add(t);
                }

                ArrayList<String> listGroupC = new ArrayList<>();
                listGroupC.add("Franca");
                listGroupC.add("Peru");
                listGroupC.add("Marrocos");
                listGroupC.add("Dinamarca");

                for (String teamName : listGroupC) {
                    Team t = new Team();
                    t.setTeamName(teamName);
                    t.setTeamGroup("C");
                    teams.add(t);
                }

                ArrayList<String> listGroupD = new ArrayList<>();
                listGroupD.add("Islandia");
                listGroupD.add("Argentina");
                listGroupD.add("Croacia");
                listGroupD.add("Nigeria");

                for (String teamName : listGroupD) {
                    Team t = new Team();
                    t.setTeamName(teamName);
                    t.setTeamGroup("D");
                    teams.add(t);
                }

                ArrayList<String> listGroupE = new ArrayList<>();
                listGroupE.add("Brasil");
                listGroupE.add("Suica");
                listGroupE.add("Costa Rica");
                listGroupE.add("Servia");

                for (String teamName : listGroupE) {
                    Team t = new Team();
                    t.setTeamName(teamName);
                    t.setTeamGroup("E");
                    teams.add(t);
                }

                ArrayList<String> listGroupF = new ArrayList<>();
                listGroupF.add("Alemanha");
                listGroupF.add("Mexico");
                listGroupF.add("Suecia");
                listGroupF.add("Coreia do Sul");

                for (String teamName : listGroupF) {
                    Team t = new Team();
                    t.setTeamName(teamName);
                    t.setTeamGroup("F");
                    teams.add(t);
                }

                ArrayList<String> listGroupG = new ArrayList<>();
                listGroupG.add("Belgica");
                listGroupG.add("Panama");
                listGroupG.add("Tunisia");
                listGroupG.add("Inglaterra");

                for (String teamName : listGroupG) {
                    Team t = new Team();
                    t.setTeamName(teamName);
                    t.setTeamGroup("G");
                    teams.add(t);
                }

                ArrayList<String> listGroupH = new ArrayList<>();
                listGroupH.add("Polonia");
                listGroupH.add("Senegal");
                listGroupH.add("Colombia");
                listGroupH.add("Japao");

                for (String teamName : listGroupH) {
                    Team t = new Team();
                    t.setTeamName(teamName);
                    t.setTeamGroup("H");
                    teams.add(t);
                }

                teamDatabase.daoAccess().insertMultipleTeams(teams);

            }
        }).start();


        Bundle bundle = getArguments();

        if (bundle != null) {

            if (bundle.getString("group") != null) {

                String group = bundle.getString("group");

                switch (group) {

                    case "a":
                        btn1.setText("Russia");
                        btn2.setText("Arabia Saudita");
                        btn3.setText("Egito");
                        btn4.setText("Uruguai");

                        tvGroupName.setText("Group A");

                        break;

                    case "b":
                        btn1.setText("Portugal");
                        btn2.setText("Espanha");
                        btn3.setText("Marrocos");
                        btn4.setText("Ira");

                        tvGroupName.setText("Group B");

                        break;

                    case "c":
                        btn1.setText("Franca");
                        btn2.setText("Australia");
                        btn3.setText("Peru");
                        btn4.setText("Dinamarca");

                        tvGroupName.setText("Group C");

                        break;

                    case "d":
                        btn1.setText("Islandia");
                        btn2.setText("Argentina");
                        btn3.setText("Croacia");
                        btn4.setText("Nigeria");

                        tvGroupName.setText("Group D");

                        break;

                    case "e":
                        btn1.setText("Brasil");
                        btn2.setText("Suica");
                        btn3.setText("Costa Rica");
                        btn4.setText("Servia");

                        tvGroupName.setText("Group E");

                        break;

                    case "f":
                        btn1.setText("Alemanha");
                        btn2.setText("Mexico");
                        btn3.setText("Suecia");
                        btn4.setText("Coreia do Sul");

                        tvGroupName.setText("Group F");

                        break;

                    case "g":
                        btn1.setText("Belgica");
                        btn2.setText("Panama");
                        btn3.setText("Tunisia");
                        btn4.setText("Inglaterra");

                        tvGroupName.setText("Group G");

                        break;

                    case "h":
                        btn1.setText("Polonia");
                        btn2.setText("Senegal");
                        btn3.setText("Colombia");
                        btn4.setText("Japao");

                        tvGroupName.setText("Group H");

                        break;

                }

            }

        }


        return view;
    }

}