package com.project.roomdblogin.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.project.roomdblogin.model.UserData;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM UserData WHERE email=:email and password=:password")
    UserData getUser(String email,String password);

    @Insert
    void insert(UserData userData);

    @Query("SELECT * FROM UserData")
    List<UserData> getAllData();

    @Update
    void updateData(UserData userData);



}
