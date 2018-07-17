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
import com.francislainy.campos.worldcupmatchsimulator.database.Team;
import com.francislainy.campos.worldcupmatchsimulator.database.TeamDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    private static final String DATABASE_NAME = "teams_db";
    private TeamDatabase teamDatabase;

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

                final Team firstGroupA = teamDatabase.daoAccess().selectTeamByPosition( "A", 1);
                final Team secondGroupB = teamDatabase.daoAccess().selectTeamByPosition( "B", 2);
                final Team firstGroupC = teamDatabase.daoAccess().selectTeamByPosition( "C", 1);
                final Team secondGroupD = teamDatabase.daoAccess().selectTeamByPosition( "D", 2);
                final Team firstGroupE = teamDatabase.daoAccess().selectTeamByPosition( "E", 1);
                final Team secondGroupF = teamDatabase.daoAccess().selectTeamByPosition( "F", 2);
                final Team firstGroupG = teamDatabase.daoAccess().selectTeamByPosition( "G", 1);
                final Team secondGroupH = teamDatabase.daoAccess().selectTeamByPosition( "H", 2);
                final Team firstGroupB = teamDatabase.daoAccess().selectTeamByPosition( "B", 1);
                final Team secondGroupA = teamDatabase.daoAccess().selectTeamByPosition( "A", 2);
                final Team firstGroupD = teamDatabase.daoAccess().selectTeamByPosition( "D", 1);
                final Team secondGroupC = teamDatabase.daoAccess().selectTeamByPosition( "C", 2);
                final Team firstGroupF = teamDatabase.daoAccess().selectTeamByPosition( "F", 1);
                final Team secondGroupE = teamDatabase.daoAccess().selectTeamByPosition( "E", 2);
                final Team firstGroupH = teamDatabase.daoAccess().selectTeamByPosition( "H", 1);
                final Team secondGroupG = teamDatabase.daoAccess().selectTeamByPosition( "G", 2);


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvFirstGroupA.setText(firstGroupA.getTeamName());
                        tvSecondGroupB.setText(secondGroupB.getTeamName());
                        tvFirstGroupC.setText(firstGroupC.getTeamName());
                        tvSecondGroupD.setText(secondGroupD.getTeamName());
                        tvFirstGroupE.setText(firstGroupE.getTeamName());
                        tvSecondGroupF.setText(secondGroupF.getTeamName());
                        tvFirstGroupG.setText(firstGroupG.getTeamName());
                        tvSecondGroupH.setText(secondGroupH.getTeamName());
                        tvFirstGroupB.setText(firstGroupB.getTeamName());
                        tvSecondGroupA.setText(secondGroupA.getTeamName());
                        tvFirstGroupD.setText(firstGroupD.getTeamName());
                        tvSecondGroupC.setText(secondGroupC.getTeamName());
                        tvFirstGroupF.setText(firstGroupF.getTeamName());
                        tvSecondGroupE.setText(secondGroupE.getTeamName());
                        tvFirstGroupH.setText(firstGroupH.getTeamName());
                        tvSecondGroupG.setText(secondGroupG.getTeamName());
                    }
                });

            }}).start();


        return view;
    }

}

