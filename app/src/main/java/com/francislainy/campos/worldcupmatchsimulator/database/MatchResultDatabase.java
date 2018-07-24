package com.francislainy.campos.worldcupmatchsimulator.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


/**
 * Created by Francislainy on 24/07/2018.
 */

@Database(entities = {MatchResult.class}, version = 2, exportSchema = false)
public abstract class MatchResultDatabase extends RoomDatabase {

    public abstract MatchDaoAccess matchDaoAccess();
}