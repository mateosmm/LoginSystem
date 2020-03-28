package com.example.loginsystem;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface EventDao {
    @Query("SELECT * FROM events")
    List<Event> getAll();

    @Query("SELECT * FROM events WHERE eid IN (:eventIds)")
    List<Event> loadAllByIds(int[] eventIds);

    @Query("SELECT * FROM events WHERE title LIKE :first LIMIT 1")
    Event findByName(String first);

    @Transaction
    @Query("SELECT * FROM Users")
    public List<Users_events> getUsersWithEvents();

    @Transaction
    @Query("SELECT * FROM Users WHERE uid LIKE :user_id LIMIT 1")
    public List<Users_events> getUsersEventsByuID(String user_id);

    //@Transaction
    //@Query("SELECT * FROM events WHERE userID LIKE :user_id LIMIT 1")
    //public List<Users_events> getUsersEventsByuserID(String user_id);

    @Insert
    void insertAll(Event event);

    @Delete
    void delete(Event event);
}
