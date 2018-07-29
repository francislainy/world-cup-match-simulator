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
import com.francislainy.campos.worldcupmatchsimulator.fragments.OitavasDeFinalFragment;
import com.francislainy.campos.worldcupmatchsimulator.fragments.TeamGroupFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static int NUMBER_OF_PAGES = 9;
    private static final String DATABASE_NAME = "teams_db";
    private TeamDatabase teamDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teamDatabase = Room.databaseBuilder(this, TeamDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {

                List<Team> teams = new ArrayList<>();

                ArrayList<String> teamList = new ArrayList();
                teamList.add("Russia"); //todo: have team names in English
                teamList.add("Arabia Saudita");
                teamList.add("Egito");
                teamList.add("Uruguai");
                teamList.add("Portugal");
                teamList.add("Espanha");
                teamList.add("Marrocos");
                teamList.add("Ira");
                teamList.add("Franca");
                teamList.add("Peru");
                teamList.add("Marrocos");
                teamList.add("Dinamarca");
                teamList.add("Islandia");
                teamList.add("Argentina");
                teamList.add("Croacia");
                teamList.add("Nigeria");
                teamList.add("Brasil");
                teamList.add("Suica");
                teamList.add("Costa Rica");
                teamList.add("Servia");
                teamList.add("Alemanha");
                teamList.add("Mexico");
                teamList.add("Suecia");
                teamList.add("Coreia do Sul");
                teamList.add("Belgica");
                teamList.add("Panama");
                teamList.add("Tunisia");
                teamList.add("Inglaterra");
                teamList.add("Polonia");
                teamList.add("Senegal");
                teamList.add("Colombia");
                teamList.add("Japao");

                for (int i = 0; i < teamList.size(); i++) {

                    Team t = new Team();
                    t.setTeamName(teamList.get(i));

                    if (i<4) {
                        t.setTeamGroup("A");
                    }
                    else if (i<7) {
                        t.setTeamGroup("B");
                    }
                    else if (i<11) {
                        t.setTeamGroup("C");
                    }
                    else if (i<15) {
                        t.setTeamGroup("D");
                    }
                    else if (i<19) {
                        t.setTeamGroup("E");
                    }
                    else if (i<23) {
                        t.setTeamGroup("F");
                    }
                    else if (i<27) {
                        t.setTeamGroup("G");
                    }
                    else if (i<31) {
                        t.setTeamGroup("H");
                    }

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
                case 8:
                    return new OitavasDeFinalFragment();
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