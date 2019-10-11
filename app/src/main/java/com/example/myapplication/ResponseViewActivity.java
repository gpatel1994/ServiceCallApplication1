package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ResponseViewActivity extends AppCompatActivity {
    private  RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_main_response_screen);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView = findViewById(R.id.main_response_recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator( new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        List<String> responseItem = new ArrayList<String>();
        responseItem.add("featureSplash");
        responseItem.add("startUpConfig");
        responseItem.add("inAuth");
        responseItem.add("mobileContentVersion");
        responseItem.add("eula");
        responseItem.add("inAuth");
        recyclerView.setAdapter(new MobileInitializeAdapter(responseItem));
    }
}
