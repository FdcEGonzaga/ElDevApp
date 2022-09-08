package com.example.devapp.BucketList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.devapp.BucketList.Adapter.BucketListAdapter;
import com.example.devapp.BucketList.Model.BucketListEntry;
import com.example.devapp.R;

public class PlacesToGoActivity extends AppCompatActivity {

    private BucketListAdapter adapter;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_to_go);


        BucketListEntry[] placesToGo = {
                new BucketListEntry("Iceland", "I want to climb this mountain and make an adventurous memory.", R.drawable.places_iceland, 4),
                new BucketListEntry("Amazon", "I want to see and have a picture with the Northern Lights.", R.drawable.places_amazon, 4.5f),
                new BucketListEntry("Japan", "I want to go around the east and west of USA for a week.", R.drawable.places_japan, 5),
                new BucketListEntry("Kerala", "I want to dive with the sardines and take photos.", R.drawable.places_kerala, 4),
                new BucketListEntry("Vietnam", "I want to jump off the plane and face my fear of height.", R.drawable.places_vietnam, 4),
                new BucketListEntry("Iceland", "I want to climb this mountain and make an adventurous memory.", R.drawable.places_iceland, 4),
                new BucketListEntry("Amazon", "I want to see and have a picture with the Northern Lights.", R.drawable.places_amazon, 4.5f),
                new BucketListEntry("Japan", "I want to go around the east and west of USA for a week.", R.drawable.places_japan, 5),
                new BucketListEntry("Kerala", "I want to dive with the sardines and take photos.", R.drawable.places_kerala, 4),
                new BucketListEntry("Vietnam", "I want to jump off the plane and face my fear of height.", R.drawable.places_vietnam, 4)
        };

        rv = findViewById(R.id.rv_places_to_go);
        adapter = new BucketListAdapter(placesToGo);
        rv.setAdapter(adapter);
    }
}