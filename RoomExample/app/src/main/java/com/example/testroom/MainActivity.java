package com.example.testroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.testroom.database.AppDatabase;
import com.example.testroom.events.DataItemsEvent;
import com.example.testroom.model.DataItem;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static com.example.testroom.sample.SampleDataProvider.dataItemList;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    AppDatabase db;
    private Executor executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onResume() {
        super.onResume();
        /*List<String> itemNames = new ArrayList<>();
        for (DataItem item: dataItemList) {
            itemNames.add(item.getItemName());
        }
        Collections.sort(itemNames);
        Log.d("Sanil","itemNames size: "+dataItemList.size());

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemNames);
        lv.setAdapter(adapter);
*/
        executor.execute(new Runnable() {
            @Override
            public void run() {
                List<DataItem> d = db.dataItemDao().getAll();
                Log.d("Sanil1","size: "+d.size());
                EventBus.getDefault().post(new DataItemsEvent(d));
            }
        });

        EventBus.getDefault().register(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dataItemsEventHandler( DataItemsEvent event) {
        List<DataItem> temp = event.getItemList();
        int j = temp.size();

        List<String> itemNames = new ArrayList<>();
        int t1 = temp.size();
        for (int i=0;i<t1;i++) {
            itemNames.add(temp.get(i).getItemName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemNames);

        lv.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.list);
        db = AppDatabase.getInstance(this);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                int itemCount = db.dataItemDao().countItems();
                if (itemCount == 0) {
                    //call the insert method in Dao
                    db.dataItemDao().insertAll(dataItemList);
                    Log.d("Sanil","dataItemList: "+dataItemList.size());
                }
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.destroyInstance();
        EventBus.getDefault().unregister(this);

    }
}
