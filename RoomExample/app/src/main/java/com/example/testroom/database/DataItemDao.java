package com.example.testroom.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.testroom.model.DataItem;

import java.util.List;

@Dao
public interface DataItemDao {
    @Insert
    void insertAll(List<DataItem> items);

    @Insert
    void insertAll(DataItem... items);

    @Query("SELECT COUNT(*) from dataitem")
    int countItems();

    @Query("SELECT * FROM dataitem ORDER BY itemName")
    List<DataItem> getAll();

    @Query("SELECT * FROM dataitem WHERE itemId = :itemId") // IMPORTANT How is data passed to query
    DataItem findById(String itemId);
}
