package com.project.roomdblogin;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.gson.Gson;
import com.project.roomdblogin.data.UserDao;
import com.project.roomdblogin.model.Model;
import com.project.roomdblogin.model.UserData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    private TextView tvUser;

    private UserData user;
    ArrayList<Model> userInfoList = new ArrayList<>();
    RecyclerView recycleView;
    TextView txtViewResult;
    UserDao db;
    UserDataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        dataBase = Room.databaseBuilder(HomeActivity.this,UserDataBase.class,"mi-database.db")
                .allowMainThreadQueries().build();

        user = (UserData) getIntent().getSerializableExtra("User");

        tvUser = findViewById(R.id.tvUser);
        txtViewResult = findViewById(R.id.txtViewResult);

        if (user != null) {
            tvUser.setText("WELCOME " + user.getUserName());
        }
       // List<UserData> userList = db.getAllData();
       // Log.e("UserList",userList.toString());



        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();
        JSONAPI jsonAPI = retrofit.create(JSONAPI.class);
       // val jsonAPI = retrofit.create(JsonAPI::class.java)
       // Call<Model> mCall = jsonAPI.getInfo();
   // listCall.enqueue(Callback<List<Model>);


        Call<List<Model>> mCall;
        mCall = jsonAPI.getInfo();
        mCall.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {

                if (response.isSuccessful()) {
                    Log.e("RESPONSE", response.toString());
                    List<Model> models = response.body();
                    for(Model model:models){
                        String details="";
                        details+="ID: "+model.getId()+"\n";
                        details+="User ID: "+model.getUserId()+"\n";
                        details+="Title: "+model.getTitle()+"\n\n\n";
                        txtViewResult.append(details);
                    }

                } else {
                    Toast.makeText(getApplication(), "No connection", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.e("RESPONSE", t.toString());
            }
        });





    }
}