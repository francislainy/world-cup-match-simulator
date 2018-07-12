package com.francislainy.campos.worldcupmatchsimulator.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Francislainy on 04/07/2018.
 */

@Entity
public class Team {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int teamId;

    private String teamName;

    private String teamGroup;

    public Team() {

    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamGroup() {
        return teamGroup;
    }

    public void setTeamGroup(String teamGroup) {
        this.teamGroup = teamGroup;
    }

}