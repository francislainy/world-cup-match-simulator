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

}
