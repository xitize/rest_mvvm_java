package com.example.requesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.requesapp.adapter.UserListAdapter;
import com.example.requesapp.viewmodal.MainViewModal;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MainViewModal mainViewModal;
    UserListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.usersRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setLayoutManager(layoutManager);
        listAdapter = new UserListAdapter();
        mRecyclerView.setAdapter(listAdapter);
        mainViewModal = ViewModelProviders.of(this).get(MainViewModal.class);

        listAdapter.ItemOnClickListnererPosition(userID -> {
            Toast.makeText(this, "get the position : " + userID, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, UserActivity.class);
            intent.putExtra("userID", userID);
            startActivity(intent);
        });

        mainViewModal.getListOfUsers(1).observe(this, users -> {
            listAdapter.setUserList(users);
            listAdapter.notifyDataSetChanged();
        });
    }
}
