package com.example.loginsystem;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM users WHERE username LIKE :first LIMIT 1")
    User findByName(String first);

    @Query("SELECT count(*) FROM users WHERE username LIKE :username AND password LIKE :password LIMIT 1")
    int validateLogin(String username, String password);

    @Transaction
    @Query("SELECT * FROM Users")
    public List<Users_events> getUsersWithEvents();

    @Transaction
    @Query("SELECT * FROM Users WHERE uid LIKE :user_id LIMIT 1")
    public List<Users_events> getUsersEventsByID(String user_id);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
