package com.bintangr.githubuserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bintangr.githubuserapp.adapter.userAdapter;
import com.bintangr.githubuserapp.model.userModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMain;
    ArrayList<userModel> userList;
    userAdapter adapter;
    private String[] username;
    private String[] name;
    private String[] company;
    private String[] location;
    private int[] repository;
    private int[] follower;
    private int[] following;
    private TypedArray avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.main_recycler);
        rvMain.setHasFixedSize(true);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        adapter = new userAdapter(this);
        rvMain.setAdapter(adapter);
        rvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        username = getResources().getStringArray(R.array.username);
        name = getResources().getStringArray(R.array.name);
        avatar = getResources().obtainTypedArray(R.array.avatar);
        company = getResources().getStringArray(R.array.company);
        location = getResources().getStringArray(R.array.location);
        repository = getResources().getIntArray(R.array.repository);
        follower = getResources().getIntArray(R.array.followers);
        following = getResources().getIntArray(R.array.following);


        userList = new ArrayList<>();

        for (int i = 0; i<username.length; i++){
            userModel userModel = new userModel();
            userModel.setAvatar(avatar.getResourceId(i, -1));
            userModel.setUsername(username[i]);
            userModel.setName(name[i]);
            userModel.setCompany(company[i]);
            userModel.setLocation(location[i]);
            userModel.setRepository(repository.length);
            userModel.setFollower(follower.length);
            userModel.setFollowing(following.length);
            userList.add(userModel);
        }
        adapter.setUser(userList);
    }
}