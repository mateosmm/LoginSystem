package com.example.loginsystem;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "events")
public class Event {
    @PrimaryKey(autoGenerate = true)
    public int eid;

    @ColumnInfo(name = "userID")
    public int userID;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "year")
    public int year;

    @ColumnInfo(name = "day")
    public int day;

    @ColumnInfo(name = "month")
    public int month;

    @ColumnInfo(name = "time")
    public int time;

    @ColumnInfo(name = "lat")
    public double lat;

    @ColumnInfo(name = "lng")
    public double lng;

    public Event(String title, String description, int month, int day, int year, int time, double lat, double lng){
        this.title = title;
        this.description = description;
        this.month = month;
        this.time = time;
        this.year = year;
        this.day = day;
        this.lat = lat;
        this.lng = lng;
    }
}
