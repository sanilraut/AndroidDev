package com.example.dagger.Car;
import android.util.Log;

public class DieselEngine implements Engine {
    private static final String TAG = "Car";

    private int horsePower;

    public DieselEngine(int hp) {
        horsePower = hp;
    }

    @Override
    public void start() {
        Log.d(TAG,"Diesel Engine HORSE POWER: "+horsePower);
    }
}
