package com.francislainy.campos.worldcupmatchsimulator.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Francislainy on 24/07/2018.
 */

@Entity(tableName = "Match")
public class Match {

    @PrimaryKey(autoGenerate = true)
    private int matchId;
    private String matchLabel;
    private String matchWinner;
    private String team1;
    private String team2;

    public Match() {

    }

    public Match(String team1, String team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getMatchLabel() {
        return matchLabel;
    }

    public void setMatchLabel(String matchLabel) {
        this.matchLabel = matchLabel;
    }

    public String getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(String matchWinner) {
        this.matchWinner = matchWinner;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }
}
