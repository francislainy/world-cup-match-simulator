package com.francislainy.campos.worldcupmatchsimulator.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Francislainy on 04/07/2018.
 */

@Database(entities = {Team.class}, version = 4, exportSchema = false)
public abstract class TeamDatabase extends RoomDatabase{

    public abstract DaoAccess daoAccess();
}
