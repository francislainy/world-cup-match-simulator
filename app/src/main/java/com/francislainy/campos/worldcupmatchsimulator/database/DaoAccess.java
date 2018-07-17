package com.francislainy.campos.worldcupmatchsimulator.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Francislainy on 04/07/2018.
 */

@Dao
public interface DaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSingleTeam(Team team);

    @Insert
    void insertMultipleTeams(List<Team> teamList);

    @Query("SELECT * FROM Team WHERE teamId = :teamId")
    Team selectTeamById(int teamId);

    @Query("UPDATE Team SET teamPosition = :teamPosition WHERE teamId = :teamId")
    int updateTeam(int teamId, int teamPosition);

}
