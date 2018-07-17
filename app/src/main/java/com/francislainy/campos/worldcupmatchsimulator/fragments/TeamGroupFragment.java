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
import com.francislainy.campos.worldcupmatchsimulator.database.TeamDatabase;

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

        Bundle bundle = getArguments();

        if (bundle != null) {

            if (bundle.getString("group") != null) {

                String group = bundle.getString("group");

                teamDatabase = Room.databaseBuilder(getContext(), TeamDatabase.class, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();

                switch (group) {

                    case "a":
                        btn1.setText("Russia");
                        btn2.setText("Arabia Saudita");
                        btn3.setText("Egito");
                        btn4.setText("Uruguai");

                        tvGroupName.setText("Group A");

                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                               teamDatabase.daoAccess().updateTeam(1, 2);
                               teamDatabase.daoAccess().updateTeam(2, 1);
                               teamDatabase.daoAccess().updateTeam(3, 3);
                               teamDatabase.daoAccess().updateTeam(4, 4);

                            }}).start();

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