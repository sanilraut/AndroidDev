package com.example.dagger.Car;

import javax.inject.Inject;
import android.util.Log;
class Remote {
    private static final String TAG = "Car";
    @Inject
    public Remote() {
    }

    public void setListener(Car car) {
        Log.d(TAG,"IN REMOTE SET LISTENER");
    }
}
