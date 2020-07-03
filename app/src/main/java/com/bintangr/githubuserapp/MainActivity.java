package com.bintangr.githubuserapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bintangr.githubuserapp.adapter.userAdapter;
import com.bintangr.githubuserapp.model.userModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar mainTools;
    RecyclerView rvMain;
    ArrayList<userModel> userList;
    userAdapter adapter;
    private String[] username;
    private String[] name;
    private String[] company;
    private String[] location;
    private String[] repository;
    private String[] follower;
    private String[] following;
    private TypedArray avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarSet();
        recyclerSet();
        listResourceSet();
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.actionBar);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setQueryHint("Username or Name");
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void listResourceSet() {
        username = getResources().getStringArray(R.array.username);
        name = getResources().getStringArray(R.array.name);
        avatar = getResources().obtainTypedArray(R.array.avatar);
        company = getResources().getStringArray(R.array.company);
        location = getResources().getStringArray(R.array.location);
        repository = getResources().getStringArray(R.array.repository);
        follower = getResources().getStringArray(R.array.followers);
        following = getResources().getStringArray(R.array.following);
        userList = new ArrayList<>();

        for (int i = 0; i < username.length; i++){
            userModel userModel = new userModel();
            userModel.setAvatar(avatar.getResourceId(i, -1));
            userModel.setUsername(username[i]);
            userModel.setName(name[i]);
            userModel.setCompany(company[i]);
            userModel.setLocation(location[i]);
            userModel.setRepository(repository[i]);
            userModel.setFollower(Integer.parseInt(follower[i]));
            userModel.setFollowing(Integer.parseInt(following[i]));
            userList.add(userModel);
        }
        adapter.setUser(userList);

    }

    private void recyclerSet() {
        rvMain = findViewById(R.id.main_recycler);
        rvMain.setHasFixedSize(true);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        adapter = new userAdapter(this);
        rvMain.setAdapter(adapter);
    }

    private void toolbarSet() {
        mainTools = findViewById(R.id.main_toolbar);
        mainTools.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mainTools);
        getSupportActionBar().setTitle("Main List");

    }
}