package com.francislainy.campos.worldcupmatchsimulator.fragments;


import android.arch.persistence.room.Room;
import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.francislainy.campos.worldcupmatchsimulator.R;
import com.francislainy.campos.worldcupmatchsimulator.database.TeamDatabase;

import java.util.ArrayList;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.DragEvent.ACTION_DROP;

//https://arte.folha.uol.com.br/esporte/copa-2018/simulador-de-resultados/

public class TeamGroupFragment2 extends Fragment {

    @BindView(R.id.btn1)
    ImageView btn1;
    @BindView(R.id.btn2)
    ImageView btn2;
    @BindView(R.id.btn3)
    ImageView btn3;
    @BindView(R.id.btn4)
    ImageView btn4;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.ll_1)
    LinearLayout ll_1;
    @BindView(R.id.ll_2)
    LinearLayout ll_2;
    @BindView(R.id.ll_3)
    LinearLayout ll_3;
    @BindView(R.id.ll_4)
    LinearLayout ll_4;
    @BindView(R.id.cl_1)
    ConstraintLayout cl;
    @BindView(R.id.tv_group_name)
    TextView tvGroupName;

    @BindDrawable(R.drawable.russia)
    Drawable russia;
    @BindDrawable(R.drawable.arabia_saudita)
    Drawable arabia_saudirta;
    @BindDrawable(R.drawable.egito)
    Drawable egito;
    @BindDrawable(R.drawable.uruguai)
    Drawable uruguai;
    @BindDrawable(R.drawable.portugal)
    Drawable portugal;
    @BindDrawable(R.drawable.espanha)
    Drawable espanha;
    @BindDrawable(R.drawable.marrocos)
    Drawable marrocos;
    @BindDrawable(R.drawable.ira)
    Drawable ira;
    @BindDrawable(R.drawable.franca)
    Drawable franca;
    @BindDrawable(R.drawable.australia)
    Drawable australia;
    @BindDrawable(R.drawable.peru)
    Drawable peru;
    @BindDrawable(R.drawable.dinamarca)
    Drawable dinamarca;
    @BindDrawable(R.drawable.islandia)
    Drawable islandia;
    @BindDrawable(R.drawable.croacia)
    Drawable croacia;
    @BindDrawable(R.drawable.argentina)
    Drawable argentina;
    @BindDrawable(R.drawable.nigeria)
    Drawable nigeria;
    @BindDrawable(R.drawable.brasil)
    Drawable brasil;
    @BindDrawable(R.drawable.suica)
    Drawable suica;
    @BindDrawable(R.drawable.costa_rica)
    Drawable costa_rica;
    @BindDrawable(R.drawable.servia)
    Drawable servia;
    @BindDrawable(R.drawable.alemanha)
    Drawable alemanha;
    @BindDrawable(R.drawable.mexico)
    Drawable mexico;
    @BindDrawable(R.drawable.suecia)
    Drawable suecia;
    @BindDrawable(R.drawable.coreia_do_sul)
    Drawable coreia_do_sul;
    @BindDrawable(R.drawable.belgica)
    Drawable belgica;
    @BindDrawable(R.drawable.panama)
    Drawable panama;
    @BindDrawable(R.drawable.tunisia)
    Drawable tunisia;
    @BindDrawable(R.drawable.inglaterra)
    Drawable inglaterra;
    @BindDrawable(R.drawable.polonia)
    Drawable polonia;
    @BindDrawable(R.drawable.senegal)
    Drawable senegal;
    @BindDrawable(R.drawable.colombia)
    Drawable colombia;
    @BindDrawable(R.drawable.japao)
    Drawable japao;


    int positionTeamId1 = 0;
    int positionTeamId2 = 0;
    int positionTeamId3 = 0;
    int positionTeamId4 = 0;

    private static final String DATABASE_NAME = "teams_db";
    private TeamDatabase teamDatabase;
    ArrayList<LinearLayout> layouts = new ArrayList<>();

    public TeamGroupFragment2() {
        // Required empty public constructor
    }


    public static TeamGroupFragment2 newInstance(String group) {

        TeamGroupFragment2 fragment = new TeamGroupFragment2();
        Bundle args = new Bundle();
        args.putString("group", group);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team_group2, container, false);

        ButterKnife.bind(this, view);

        Bundle bundle = getArguments();

        if (bundle != null) {

            if (bundle.getString("group") != null) {

                String group = bundle.getString("group");

                teamDatabase = Room.databaseBuilder(getContext(), TeamDatabase.class, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();

                setGroupDetails(group);

            }

        }


        btn1.setOnTouchListener(new MyTouchListener());
        btn2.setOnTouchListener(new MyTouchListener());
        btn3.setOnTouchListener(new MyTouchListener());
        btn4.setOnTouchListener(new MyTouchListener());
        // cl.setOnDragListener(new MyDragListener());

        layouts.add(ll_1);
        layouts.add(ll_2);
        layouts.add(ll_3);
        layouts.add(ll_4);

        for (LinearLayout layout : layouts) {
            layout.setOnDragListener(new MyDragListener());
        }

        return view;
    }


    private void setGroupDetails(String groupName) {

        switch (groupName) {

            case "a":

                btn1.setImageDrawable(russia);
                btn2.setImageDrawable(arabia_saudirta);
                btn3.setImageDrawable(egito);
                btn4.setImageDrawable(uruguai);

                tvGroupName.setText("Group A");

                break;

            case "b":

                btn1.setImageDrawable(portugal);
                btn2.setImageDrawable(espanha);
                btn3.setImageDrawable(marrocos);
                btn4.setImageDrawable(ira);

                tvGroupName.setText("Group B");

                break;

            case "c":

                btn1.setImageDrawable(franca);
                btn2.setImageDrawable(australia);
                btn3.setImageDrawable(peru);
                btn4.setImageDrawable(dinamarca);

                tvGroupName.setText("Group C");

                break;

            case "d":

                btn1.setImageDrawable(islandia);
                btn2.setImageDrawable(argentina);
                btn3.setImageDrawable(croacia);
                btn4.setImageDrawable(nigeria);

                tvGroupName.setText("Group D");

                break;

            case "e":

                btn1.setImageDrawable(brasil);
                btn2.setImageDrawable(suica);
                btn3.setImageDrawable(costa_rica);
                btn4.setImageDrawable(servia);

                tvGroupName.setText("Group E");

                break;


            case "f":

                btn1.setImageDrawable(alemanha);
                btn2.setImageDrawable(mexico);
                btn3.setImageDrawable(suecia);
                btn4.setImageDrawable(coreia_do_sul);

                tvGroupName.setText("Group F");


                break;

            case "g":

                btn1.setImageDrawable(belgica);
                btn2.setImageDrawable(panama);
                btn3.setImageDrawable(tunisia);
                btn4.setImageDrawable(inglaterra);

                tvGroupName.setText("Group G");

                break;

            case "h":

                btn1.setImageDrawable(polonia);
                btn2.setImageDrawable(senegal);
                btn3.setImageDrawable(colombia);
                btn4.setImageDrawable(japao);

                tvGroupName.setText("Group H");

                break;
        }
    }


    private final class MyTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            for (LinearLayout layout : layouts) {

                if (layout.getChildCount() == 0) {

                    layout.setOnDragListener(new MyDragListener());
                }
            }


            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.VISIBLE);

            return true;

        }
    }


    private class MyDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            int action = dragEvent.getAction();

            switch (action) {

                case ACTION_DROP:

                    View viewBeingHold = (View) dragEvent.getLocalState();
                    ViewGroup owner = (ViewGroup) viewBeingHold.getParent();

                    owner.removeView(viewBeingHold);
                    LinearLayout containerWhereViewWillBeDropped = (LinearLayout) view;
                    viewBeingHold.setVisibility(View.VISIBLE);

                    View viewAlreadyOnLayout = containerWhereViewWillBeDropped.getChildAt(0);

                    if (viewAlreadyOnLayout != null) {

                        containerWhereViewWillBeDropped.removeView(viewAlreadyOnLayout);

                        containerWhereViewWillBeDropped.addView(viewBeingHold);

                        owner.addView(viewAlreadyOnLayout);

                    } else if (viewAlreadyOnLayout == null) {// it means we're still on the same layout

                        owner.addView(viewBeingHold);

                    }


                    updateDatabaseWithTeamPosition();

                    break;

            }

            return true;
        }
    }


    @Override
    public void onPause() {
        super.onPause();

        updateDatabaseWithTeamPosition();
    }


    private void updateDatabaseWithTeamPosition() {
        setPositionWithinGroup(ll_1, 1);
        setPositionWithinGroup(ll_2, 2);
        setPositionWithinGroup(ll_3, 3);
        setPositionWithinGroup(ll_4, 4);

        String teamGroupName = tvGroupName.getText().toString().toLowerCase();

        switch (teamGroupName) {

            case "group a":

                updateDatabaseStartingFromTeamId(1);

                break;

            case "group b":

                updateDatabaseStartingFromTeamId(5);

                break;

            case "group c":

                updateDatabaseStartingFromTeamId(9);

                break;

            case "group d":

                updateDatabaseStartingFromTeamId(13);

                break;

            case "group e":

                updateDatabaseStartingFromTeamId(17);

                break;

            case "group f":

                updateDatabaseStartingFromTeamId(21);

                break;

            case "group g":

                updateDatabaseStartingFromTeamId(25);

                break;

            case "group h":

                updateDatabaseStartingFromTeamId(29);

                break;
        }
    }


    private void updateDatabaseStartingFromTeamId(final int id) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                teamDatabase.daoAccess().updateTeam(id, positionTeamId1);
                teamDatabase.daoAccess().updateTeam(id + 1, positionTeamId2);
                teamDatabase.daoAccess().updateTeam(id + 2, positionTeamId3);
                teamDatabase.daoAccess().updateTeam(id + 3, positionTeamId4);

            }
        }).start();

    }


    private void setPositionWithinGroup(LinearLayout layout, int position) {
        if (layout.getChildAt(0) != null) {

            int teamViewIdLayout = layout.getChildAt(0).getId();

            switch (teamViewIdLayout) {

                case R.id.btn1:
                    positionTeamId1 = position;
                    break;
                case R.id.btn2:
                    positionTeamId2 = position;
                    break;
                case R.id.btn3:
                    positionTeamId3 = position;
                    break;
                case R.id.btn4:
                    positionTeamId4 = position;
                    break;
            }

        }
    }

}