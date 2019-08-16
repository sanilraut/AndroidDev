package com.example.testroom.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import androidx.annotation.NonNull;

//import android.support.annotation.NonNull;

@Entity
public class DataItem {
    @ColumnInfo
    private String itemId;

    @PrimaryKey
    @NonNull
    private String itemName;
    @ColumnInfo
    private String description;
    @ColumnInfo
    private String category;
    @ColumnInfo
    private int sortPosition;
    @ColumnInfo
    private double price;
    @ColumnInfo
    private String image;

    public DataItem(String itemId, String itemName, String description, String category, int sortPosition, double price, String image) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.sortPosition = sortPosition;
        this.price = price;
        this.image = image;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSortPosition(int sortPosition) {
        this.sortPosition = sortPosition;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public int getSortPosition() {
        return sortPosition;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
