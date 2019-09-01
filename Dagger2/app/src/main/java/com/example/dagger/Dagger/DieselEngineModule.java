package com.example.dagger.Dagger;

import com.example.dagger.Car.DieselEngine;
import com.example.dagger.Car.Engine;

import dagger.Module;
import dagger.Provides;

@Module
public  class DieselEngineModule {

    private int horsePower;

    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @Provides
     Engine provideEngine() {
        return new DieselEngine(horsePower);
    }
}
