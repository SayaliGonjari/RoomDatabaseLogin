package com.project.roomdblogin;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.project.roomdblogin.model.Model;
import com.project.roomdblogin.model.UserData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONAPI {

    @GET("posts")
    Call<List<Model>> getInfo();



   // <List<Model>> getInfo(): Call;
}
