package com.francislainy.campos.worldcupmatchsimulator.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.francislainy.campos.worldcupmatchsimulator.R;
import com.francislainy.campos.worldcupmatchsimulator.fragments.TeamGroupFragment;

public class MainActivity extends AppCompatActivity {

    public final static int NUMBER_OF_PAGES = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FragmentManager fm = getSupportFragmentManager();
        // FragmentTransaction transaction = fm.beginTransaction();
        // TeamGroupFragment fragment = new TeamGroupFragment();
        // transaction.replace(R.id.fragment, fragment).commit();

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