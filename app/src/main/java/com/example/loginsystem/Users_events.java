package com.example.loginsystem;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class Users_events {
    @Embedded public User user;

    @Relation(
            parentColumn = "uid",
            entityColumn = "userID",
            entity = Event.class
    )

    public List<Event> events;

}
