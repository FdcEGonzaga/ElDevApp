package com.example.devapp.BucketList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.devapp.BucketList.Adapter.BucketListAdapter;
import com.example.devapp.BucketList.Model.BucketListEntry;
import com.example.devapp.R;

import java.util.ArrayList;

public class ThingsToDoActivity extends AppCompatActivity {

    private BucketListAdapter adapter;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_things_to_do);

        BucketListEntry[] thingsToDo = {
                new BucketListEntry("Kilimanjaro", "I want to climb this mountain and make an adventurous memory.", R.drawable.todo_kilimanjaro, 4),
                new BucketListEntry("Northern Lights", "I want to see and have a picture with the Northern Lights.", R.drawable.todo_northern_lights, 4.5f),
                new BucketListEntry("USA Road Trip", "I want to go around the east and west of USA for a week.", R.drawable.todo_road_trip, 5),
                new BucketListEntry("Scuba Diving", "I want to dive with the sardines and take photos.", R.drawable.todo_scubadive, 4),
                new BucketListEntry("Sky Diving", "I want to jump off the plane and face my fear of height.", R.drawable.todo_skydive, 4),
                new BucketListEntry("Kilimanjaro", "I want to climb this mountain and make an adventurous memory.", R.drawable.todo_kilimanjaro, 4),
                new BucketListEntry("Northern Lights", "I want to see and have a picture with the Northern Lights.", R.drawable.todo_northern_lights, 4.5f),
                new BucketListEntry("USA Road Trip", "I want to go around the east and west of USA for a week.", R.drawable.todo_road_trip, 5),
                new BucketListEntry("Scuba Diving", "I want to dive with the sardines and take photos.", R.drawable.todo_scubadive, 4)
        };

        rv = findViewById(R.id.rv_things_to_do);
        adapter = new BucketListAdapter(thingsToDo);
        rv.setAdapter(adapter);
        
    }
}