package com.example.dagger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.dagger.Car.Car;
import com.example.dagger.Dagger.CarComponent;
import com.example.dagger.Dagger.DaggerCarComponent;
import com.example.dagger.Dagger.DieselEngineModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Car car1,car2; //CHANGE1: FIELD INJECTION THIS VARIABLE IS NOT INJECTED AUTOMATICALLY - see changes in CarComponent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CarComponent carComponent = DaggerCarComponent.builder()
                .dieselEngineModule(new DieselEngineModule(100))
                .build();

        //car = carComponent.getCar();
        carComponent.inject(this); // CHANGE1: FIELD inject method called here

        car1.drive();
        car2.drive();
    }
}
