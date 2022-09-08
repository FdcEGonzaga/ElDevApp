package com.example.devapp.BucketList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.example.devapp.DevAppHome;
import com.example.devapp.R;

public class BucketListActivity extends AppCompatActivity {
    private CardView thingsToDo, placesToGo;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket_list);

        castView();
        setListeners();
    }

    private void castView() {
        thingsToDo = findViewById(R.id.card_things_to_do);
        placesToGo = findViewById(R.id.card_places_to_go);
    }

    private void setListeners() {
        thingsToDo.setOnClickListener(v -> {
            intent = new Intent(BucketListActivity.this, ThingsToDoActivity.class);
            startActivity(intent);
        });

        placesToGo.setOnClickListener(v -> {
            intent = new Intent(BucketListActivity.this, PlacesToGoActivity.class);
            startActivity(intent);
        });
    }
}