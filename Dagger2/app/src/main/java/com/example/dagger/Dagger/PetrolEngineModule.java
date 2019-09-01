package com.example.dagger.Dagger;

import com.example.dagger.Car.Engine;
import com.example.dagger.Car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {
    @Binds
    abstract Engine bindEngine(PetrolEngine engine);

}
