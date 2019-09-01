package com.example.dagger.Dagger;

import com.example.dagger.Car.Rims;
import com.example.dagger.Car.Tires;
import com.example.dagger.Car.Wheel;

import dagger.Module;
import dagger.Provides;

@Module
public class WheelModule {

    @Provides
    Rims provideRims() {
        return new Rims();
    }

    @Provides
    Tires provideTires() {
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    @Provides
    Wheel provideWheel(Rims rims, Tires tires) {
        return new Wheel(rims,tires);
    }

}
