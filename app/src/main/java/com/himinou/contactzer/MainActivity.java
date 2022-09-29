package com.himinou.contactzer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static String contactArrayList;
    ListView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton bt_add =  findViewById(R.id.bt_add);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callForm = new Intent(MainActivity.this, FormActivity.class);
                MainActivity.this.startActivity(callForm);
            }
        });

        //on va afficher les nos contacts maintenant
        if(contactArrayList != null){
            contactListView = findViewById(R.id.lv);
            ArrayAdapter ad = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, Collections.singletonList(contactArrayList));
            contactListView.setAdapter(ad);
            ad.notifyDataSetChanged();
        }


    }
}