package com.project.roomdblogin;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.project.roomdblogin.data.UserDao;
import com.project.roomdblogin.model.Model;
import com.project.roomdblogin.model.UserData;

import java.util.ArrayList;
import java.util.List;

public class UserDisplayActivity extends AppCompatActivity {

RecyclerView list;
UserAdapter userAdapter;

    UserDao db;
    UserDataBase dataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_user);

        list = findViewById(R.id.list);

        dataBase = Room.databaseBuilder(UserDisplayActivity.this,UserDataBase.class,"mi-database.db")
                .allowMainThreadQueries().build();
        db = dataBase.getUser();
        List<UserData> userData = db.getAllData();
        Log.e("Response",userData.toString());



        userAdapter = new UserAdapter(UserDisplayActivity.this, userData);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        list.setLayoutManager(mLayoutManager);
        list.setAdapter(userAdapter);








    }
}
