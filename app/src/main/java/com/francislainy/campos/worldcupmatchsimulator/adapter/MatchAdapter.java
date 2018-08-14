package com.francislainy.campos.worldcupmatchsimulator.adapter;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.francislainy.campos.worldcupmatchsimulator.R;
import com.francislainy.campos.worldcupmatchsimulator.database.Match;
import com.francislainy.campos.worldcupmatchsimulator.database.MatchDatabase;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Francislainy on 25/07/2018.
 */

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {

    private ArrayList<Match> data = new ArrayList<>();

    private Activity activity;


    public MatchAdapter(Activity activity) {

        this.activity = activity;
    }


    public void addItem(Match item) {

        data.add(item);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MatchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_match_item, parent, false);

        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull MatchAdapter.ViewHolder holder, int position) {

        holder.bind(position);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_first_group)
        TextView tvFirstGroup;
        @BindView(R.id.tv_second_group)
        TextView tvSecondGroup;
        @BindView(R.id.tv_match)
        TextView tvMatch;
        @BindView(R.id.rg)
        RadioGroup rg;
        @BindView(R.id.rb_team1)
        RadioButton rbTeam1;
        @BindView(R.id.rb_team2)
        RadioButton rbTeam2;
        MatchDatabase matchDatabase;

        Match match = null;


        ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }


        void bind(final int position) {

            match = data.get(position);

            tvFirstGroup.setText(match.getTeam1());

            tvSecondGroup.setText(match.getTeam2());

            tvMatch.setText((position + 1) + "");

            rbTeam1.setChecked(true); // set first team selected by default

            matchDatabase = Room.databaseBuilder(activity, MatchDatabase.class, "match_result")
                    .fallbackToDestructiveMigration()
                    .build();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    // match.setMatchId((position + 1) + 1);
                    // match.setTeam1((position + 1) + 1);
                    // match.setTeam2((position + 1) + 1);


                    // matchDatabase.matchDaoAccess().updateTeam1(tvFirstGroup.getText().toString(), getAdapterPosition() + 1);
                    // matchDatabase.matchDaoAccess().updateTeam2(tvSecondGroup.getText().toString(), getAdapterPosition() + 1);
                    // matchDatabase.matchDaoAccess().updateMatchLabel("Match" + tvMatch.getText().toString(), getAdapterPosition() + 1);

                }
            }).start();


            // Listeners
            rg.setOnCheckedChangeListener(onClickRadioButtonUpdateDatabase);

        }


        private RadioGroup.OnCheckedChangeListener onClickRadioButtonUpdateDatabase = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                final int selectedId = rg.getCheckedRadioButtonId();

                String teamWinner = null;

                if (selectedId == R.id.rb_team1) {
                    Toast.makeText(activity, "radio1", Toast.LENGTH_SHORT).show();

                    teamWinner = match.getTeam1();
                    rbTeam2.setChecked(false);

                } else if (selectedId == R.id.rb_team2) {
                    Toast.makeText(activity, "radio2", Toast.LENGTH_SHORT).show();

                    teamWinner = match.getTeam2();
                    rbTeam1.setChecked(false);
                }

                final String finalTeamWinner = teamWinner;
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        matchDatabase.matchDaoAccess().updateMatchWinner(finalTeamWinner, match.getMatchId());

                    }

                }).start();

            }
        };


    }

}