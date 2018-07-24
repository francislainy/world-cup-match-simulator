package com.francislainy.campos.worldcupmatchsimulator.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Francislainy on 24/07/2018.
 */

@Entity
public class MatchResult {

    @PrimaryKey(autoGenerate = true)
    private int matchId;
    private String matchLabel;
    private int matchWinner;

    public MatchResult() {

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

    public int getMatchWinner() {
        return matchWinner;
    }

    public void setMatchWinner(int matchWinner) {
        this.matchWinner = matchWinner;
    }
}
