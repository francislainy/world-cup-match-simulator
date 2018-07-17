package com.francislainy.campos.worldcupmatchsimulator.activities;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.francislainy.campos.worldcupmatchsimulator.R;
import com.francislainy.campos.worldcupmatchsimulator.database.Team;
import com.francislainy.campos.worldcupmatchsimulator.database.TeamDatabase;
import com.francislainy.campos.worldcupmatchsimulator.fragments.TeamGroupFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static int NUMBER_OF_PAGES = 8;
    private static final String DATABASE_NAME = "teams_db";
    private TeamDatabase teamDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FragmentManager fm = getSupportFragmentManager();
        // FragmentTransaction transaction = fm.beginTransaction();
        // TeamGroupFragment fragment = new TeamGroupFragment();
        // transaction.replace(R.id.fragment, fragment).commit();


        teamDatabase = Room.databaseBuilder(this, TeamDatabase.class, DATABASE_NAME)
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
                listGroupA.add("Russia"); //todo: have team names in English
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


        ViewPager pager = findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {

            switch (pos) {

                case 0:
                    return TeamGroupFragment.newInstance("a");
                case 1:
                    return TeamGroupFragment.newInstance("b");
                case 2:
                    return TeamGroupFragment.newInstance("c");
                case 3:
                    return TeamGroupFragment.newInstance("d");
                case 4:
                    return TeamGroupFragment.newInstance("e");
                case 5:
                    return TeamGroupFragment.newInstance("f");
                case 6:
                    return TeamGroupFragment.newInstance("g");
                case 7:
                    return TeamGroupFragment.newInstance("h");
                default:
                    return TeamGroupFragment.newInstance("a");
            }
        }

        @Override
        public int getCount() {
            return NUMBER_OF_PAGES;
        }

    }


}