package com.example.mydairy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class main extends AppCompatActivity {
    List<notesDataObject> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseHelper db = new DataBaseHelper(this);
        list = db.getNotes();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecycleView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter mAdapter = new recycleAdapter(list);
        recyclerView.setAdapter(mAdapter);

        final Context context = this;

        FloatingActionButton fab = findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , creat.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {

        super.onStart();

        DataBaseHelper db = new DataBaseHelper(this);
        list = db.getNotes();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecycleView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter mAdapter = new recycleAdapter(list);
        recyclerView.setAdapter(mAdapter);

    }

    public void onEdit(View view){

    }



}
