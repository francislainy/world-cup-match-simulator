package com.francislainy.campos.worldcupmatchsimulator;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Francislainy on 04/07/2018.
 */

public class App extends Application {

    public void onCreate() {

        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }

}
