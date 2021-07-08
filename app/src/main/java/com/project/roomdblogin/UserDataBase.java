package com.project.roomdblogin;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.project.roomdblogin.data.UserDao;
import com.project.roomdblogin.model.UserData;

@Database(entities = {UserData.class},version = 1,exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {

    public abstract UserDao getUser();
}
