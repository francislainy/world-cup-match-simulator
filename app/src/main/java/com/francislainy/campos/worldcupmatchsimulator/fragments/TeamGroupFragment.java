package com.francislainy.campos.worldcupmatchsimulator.fragments;


import android.arch.persistence.room.Room;
import android.content.ClipData;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.francislainy.campos.worldcupmatchsimulator.R;
import com.francislainy.campos.worldcupmatchsimulator.database.TeamDatabase;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.DragEvent.ACTION_DROP;

//https://arte.folha.uol.com.br/esporte/copa-2018/simulador-de-resultados/

public class TeamGroupFragment extends Fragment {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
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

    boolean hasLayoutWithoutChild = true;

    int positionTeamId1 = 0;
    int positionTeamId2 = 0;
    int positionTeamId3 = 0;
    int positionTeamId4 = 0;

    private static final String DATABASE_NAME = "teams_db";
    private TeamDatabase teamDatabase;
    ArrayList<LinearLayout> layouts = new ArrayList<>();

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

// todo: fix how tapping a team makes it disappear
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


    private final class MyTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            for (LinearLayout layout : layouts) {

                if (layout.getChildCount() == 0) {

                    layout.setOnDragListener(new MyDragListener());
                }

            }


            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                view.setVisibility(View.VISIBLE);

                return true;
            }


            return false;
        }
    }


    private class MyDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {

            int action = dragEvent.getAction();
            int id = view.getId();
            LinearLayout layout = getActivity().findViewById(id);

            switch (action) {

                case ACTION_DROP:

                    View viewBeingHold = (View) dragEvent.getLocalState();
                    ViewGroup owner = (ViewGroup) viewBeingHold.getParent();

                    owner.removeView(viewBeingHold);
                    LinearLayout containerWhereViewWillBeDropped = (LinearLayout) view;
                    viewBeingHold.setVisibility(View.VISIBLE);


                    // Remove the view temporarily from the layout and add it to cl
                    View viewAlreadyOnLayout = containerWhereViewWillBeDropped.getChildAt(0);

                    if (viewAlreadyOnLayout != null) {

                        containerWhereViewWillBeDropped.removeView(viewAlreadyOnLayout);

                        // cl.removeViewAt(0);
                        cl.addView(viewAlreadyOnLayout); //todo: check whether adding the view to a temporary parent is necessary

                        containerWhereViewWillBeDropped.addView(viewBeingHold); // containerWhereViewWillBeDropped - btn1 now already on ll_2


                        cl.removeView(viewAlreadyOnLayout);
                        owner.addView(viewAlreadyOnLayout);

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