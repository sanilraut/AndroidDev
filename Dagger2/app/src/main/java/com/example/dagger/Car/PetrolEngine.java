package com.example.dagger.Car;
import android.util.Log;

import javax.inject.Inject;

public class PetrolEngine implements Engine {
    private static final String TAG = "Car";

    //Constructor

    @Inject
    public PetrolEngine() {
    }

    @Override
    public void start() {
        Log.d(TAG,"Petrol Engine");
    }
}
