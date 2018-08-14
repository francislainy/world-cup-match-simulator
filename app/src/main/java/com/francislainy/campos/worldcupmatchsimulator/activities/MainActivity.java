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
import com.francislainy.campos.worldcupmatchsimulator.fragments.ConfirmFragment;
import com.francislainy.campos.worldcupmatchsimulator.fragments.TeamGroupFragment;
import com.francislainy.campos.worldcupmatchsimulator.fragments.TeamGroupFragment2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static int NUMBER_OF_PAGES = 9;
    private static final String DATABASE_NAME = "teams_db"; //todo: have just one database
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
                    t.setTeamId(i+1);

                    if (i<4) {
                        t.setTeamGroup("A");
                    }
                    else if (i<8) {
                        t.setTeamGroup("B");
                    }
                    else if (i<12) {
                        t.setTeamGroup("C");
                    }
                    else if (i<16) {
                        t.setTeamGroup("D");
                    }
                    else if (i<20) {
                        t.setTeamGroup("E");
                    }
                    else if (i<24) {
                        t.setTeamGroup("F");
                    }
                    else if (i<28) {
                        t.setTeamGroup("G");
                    }
                    else if (i<32) {
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
                    return TeamGroupFragment2.newInstance("a");
                case 1:
                    return TeamGroupFragment2.newInstance("b");
                case 2:
                    return TeamGroupFragment2.newInstance("c");
                case 3:
                    return TeamGroupFragment2.newInstance("d");
                case 4:
                    return TeamGroupFragment2.newInstance("e");
                case 5:
                    return TeamGroupFragment2.newInstance("f");
                case 6:
                    return TeamGroupFragment2.newInstance("g");
                case 7:
                    return TeamGroupFragment2.newInstance("h");
                case 8:
                    return new ConfirmFragment(); // Fragment added to buy time for database to update and avoid null pointer exception
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