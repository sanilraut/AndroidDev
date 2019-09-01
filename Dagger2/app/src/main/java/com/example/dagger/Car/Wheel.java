package com.example.dagger.Car;

import javax.inject.Inject;

public class Wheel {
    private Rims rims;
    private Tires tires;

    @Inject
    public Wheel(Rims r,Tires t) {
        this.rims = r;
        this.tires = t;
    }
}
