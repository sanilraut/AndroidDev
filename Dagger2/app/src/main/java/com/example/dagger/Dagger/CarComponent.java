package com.example.dagger.Dagger;

import com.example.dagger.Car.Car;
import com.example.dagger.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {WheelModule.class,DieselEngineModule.class})
    public interface CarComponent {

    Car getCar();
    //Change1: INJECT HERE - important
    void inject(MainActivity mainActivity);
}
