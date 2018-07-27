package com.francislainy.campos.worldcupmatchsimulator.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

/**
 * Created by Francislainy on 04/07/2018.
 */

@Dao
public interface MatchDaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSingleMatchWinner(Match match);

    @Query("UPDATE `Match` set matchWinner = :matchWinner where matchId = :matchId")
            void updateMatchWinner(String matchWinner, int matchId);

    @Query("UPDATE `Match` set team1 = :team1 where matchId = :matchId")
    void updateTeam1(String team1, int matchId);

    @Query("UPDATE `Match` set team2 = :team2 where matchId = :matchId")
    void updateTeam2(String team2, int matchId);

    @Query("UPDATE `Match` set matchLabel = :matchLabel where matchId = :matchId")
    void updateMatchLabel(String matchLabel, int matchId);

    @Query("DELETE FROM `Match` WHERE matchId = :matchId")
    void delete(int matchId);


}
