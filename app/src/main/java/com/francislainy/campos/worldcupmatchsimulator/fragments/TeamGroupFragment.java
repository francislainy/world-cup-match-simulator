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

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.DragEvent.ACTION_DROP;


public class TeamGroupFragment extends Fragment {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.ll_1)
    LinearLayout ll_1;
    @BindView(R.id.ll_2)
    LinearLayout ll_2;
    @BindView(R.id.ll_3)
    LinearLayout ll_3;
    @BindView(R.id.ll_4)
    LinearLayout ll_4;
    @BindView(R.id.cl)
    ConstraintLayout cl;
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

                            }
                        }).start();

                        break;

                    case "b":
                        btn1.setText("Portugal");
                        btn2.setText("Espanha");
                        btn3.setText("Marrocos");
                        btn4.setText("Ira");

                        tvGroupName.setText("Group B");

                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                teamDatabase.daoAccess().updateTeam(5, 2);
                                teamDatabase.daoAccess().updateTeam(6, 1);
                                teamDatabase.daoAccess().updateTeam(7, 3);
                                teamDatabase.daoAccess().updateTeam(8, 4);

                            }
                        }).start();


                        break;

                    case "c":
                        btn1.setText("Franca");
                        btn2.setText("Australia");
                        btn3.setText("Peru");
                        btn4.setText("Dinamarca");

                        tvGroupName.setText("Group C");

                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                teamDatabase.daoAccess().updateTeam(9, 2);
                                teamDatabase.daoAccess().updateTeam(10, 1);
                                teamDatabase.daoAccess().updateTeam(11, 3);
                                teamDatabase.daoAccess().updateTeam(12, 4);

                            }
                        }).start();


                        break;

                    case "d":
                        btn1.setText("Islandia");
                        btn2.setText("Argentina");
                        btn3.setText("Croacia");
                        btn4.setText("Nigeria");

                        tvGroupName.setText("Group D");

                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                teamDatabase.daoAccess().updateTeam(13, 2);
                                teamDatabase.daoAccess().updateTeam(14, 1);
                                teamDatabase.daoAccess().updateTeam(15, 3);
                                teamDatabase.daoAccess().updateTeam(16, 4);

                            }
                        }).start();

                        break;

                    case "e":
                        btn1.setText("Brasil");
                        btn2.setText("Suica");
                        btn3.setText("Costa Rica");
                        btn4.setText("Servia");

                        tvGroupName.setText("Group E");

                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                teamDatabase.daoAccess().updateTeam(17, 2);
                                teamDatabase.daoAccess().updateTeam(18, 1);
                                teamDatabase.daoAccess().updateTeam(19, 3);
                                teamDatabase.daoAccess().updateTeam(20, 4);

                            }
                        }).start();

                        break;

                    case "f":
                        btn1.setText("Alemanha");
                        btn2.setText("Mexico");
                        btn3.setText("Suecia");
                        btn4.setText("Coreia do Sul");

                        tvGroupName.setText("Group F");

                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                teamDatabase.daoAccess().updateTeam(21, 2);
                                teamDatabase.daoAccess().updateTeam(22, 1);
                                teamDatabase.daoAccess().updateTeam(23, 3);
                                teamDatabase.daoAccess().updateTeam(24, 4);

                            }
                        }).start();

                        break;

                    case "g":
                        btn1.setText("Belgica");
                        btn2.setText("Panama");
                        btn3.setText("Tunisia");
                        btn4.setText("Inglaterra");

                        tvGroupName.setText("Group G");

                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                teamDatabase.daoAccess().updateTeam(25, 2);
                                teamDatabase.daoAccess().updateTeam(26, 1);
                                teamDatabase.daoAccess().updateTeam(27, 3);
                                teamDatabase.daoAccess().updateTeam(28, 4);

                            }
                        }).start();

                        break;

                    case "h":
                        btn1.setText("Polonia");
                        btn2.setText("Senegal");
                        btn3.setText("Colombia");
                        btn4.setText("Japao");

                        tvGroupName.setText("Group H");

                        new Thread(new Runnable() {
                            @Override
                            public void run() {

                                teamDatabase.daoAccess().updateTeam(29, 2);
                                teamDatabase.daoAccess().updateTeam(30, 1);
                                teamDatabase.daoAccess().updateTeam(31, 3);
                                teamDatabase.daoAccess().updateTeam(32, 4);

                            }
                        }).start();

                        break;

                }

            }

        }


        btn1.setOnTouchListener(new MyTouchListener());
        btn2.setOnTouchListener(new MyTouchListener());
        btn3.setOnTouchListener(new MyTouchListener());
        btn4.setOnTouchListener(new MyTouchListener());
        ll_1.setOnDragListener(new MyDragListener());
        ll_2.setOnDragListener(new MyDragListener());
        ll_3.setOnDragListener(new MyDragListener());
        ll_4.setOnDragListener(new MyDragListener());
        // cl.setOnDragListener(new MyDragListener());


        return view;
    }


    private final class MyTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            if (ll_1.getChildCount() == 0) {
                ll_1.setOnDragListener(new MyDragListener());
            }

            if (ll_2.getChildCount() == 0) {
                ll_2.setOnDragListener(new MyDragListener());
            }

            if (ll_3.getChildCount() == 0) {
                ll_3.setOnDragListener(new MyDragListener());
            }

            if (ll_4.getChildCount() == 0) {
                ll_4.setOnDragListener(new MyDragListener());
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


            switch (action) {

                case ACTION_DROP:

                    View view1 = (View) dragEvent.getLocalState();
                    ViewGroup owner = (ViewGroup) view1.getParent();

                    owner.removeView(view1);
                    LinearLayout container = (LinearLayout) view;
                    view1.setVisibility(View.VISIBLE);

                    if (container.getChildCount() == 0) {
                        container.addView(view1); // Only view not already filled can have a child added to it

                        if (view.getId() == R.id.ll_1) {
                            ll_1.setOnDragListener(null);
                        } else if (view.getId() == R.id.ll_2) {
                            ll_2.setOnDragListener(null);
                        } else if (view.getId() == R.id.ll_3) {
                            ll_3.setOnDragListener(null);
                        } else if (view.getId() == R.id.ll_4) {
                            ll_4.setOnDragListener(null);
                        }

                    } else {

                        if (view.getId() == R.id.ll_1) {
                            ll_1.setOnDragListener(new MyDragListener());
                        } else if (view.getId() == R.id.ll_2) {
                            ll_2.setOnDragListener(new MyDragListener());
                        } else if (view.getId() == R.id.ll_3) {
                            ll_3.setOnDragListener(new MyDragListener());
                        } else if (view.getId() == R.id.ll_2) {
                            ll_4.setOnDragListener(new MyDragListener());
                        }

                        // Cancel drag if can't put button inside view already occupied
                        return false;
                    }

                    break;

            }

            return true;
        }
    }

}