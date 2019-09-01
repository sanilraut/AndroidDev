package com.example.dagger.Car;

import javax.inject.Inject;
import android.util.Log;
public class Car {
    @Inject Engine engine;
    private Wheel wheel;
    Driver driver;

    @Inject
    public Car(Driver d,Wheel w) {
        driver = d;
        wheel = w;
    }

    @Inject // METHOD-INJECTION - this method gets called after the constructor
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }

    public void drive(){
        engine.start();
        Log.d("Car11",driver + "  DRIVING  "+this);
    }
}

//IMPORTANT SEQUENCE - CONSTRUCTOR THEN FIELD THEN METHOD - IN ABOVE CASE - Car constructor then
//                     Field Engine, then method enableRemote();

