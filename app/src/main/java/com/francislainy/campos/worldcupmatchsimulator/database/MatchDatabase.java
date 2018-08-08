package com.francislainy.campos.worldcupmatchsimulator.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Francislainy on 24/07/2018.
 */

@Database(entities = {Match.class}, version = 3, exportSchema = false)
public abstract class MatchDatabase extends RoomDatabase {

    public abstract MatchDaoAccess matchDaoAccess();
}