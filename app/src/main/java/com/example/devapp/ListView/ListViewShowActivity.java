package com.example.devapp.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.devapp.R;
import com.example.devapp.databinding.ActivityListViewShowBinding;

import java.sql.Array;
import java.util.ArrayList;

public class ListViewShowActivity extends AppCompatActivity {

    ActivityListViewShowBinding binding;
    Intent intent;
    ListView listViewHobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        intent = getIntent();

        if (intent != null) {
            int image = intent.getIntExtra("image", R.drawable.download);
            String name = intent.getStringExtra("name");
            String number = intent.getStringExtra("number");
            String country = intent.getStringExtra("country");

            binding.profileImage.setImageResource(image);
            binding.profileName.setText(name);
            binding.profileNumber.setText(number);
            binding.profileCountry.setText(country);

        }

        // creating a simple listview of hobbies
        listViewHobbies = findViewById(R.id.listview_hobbies);
        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("Basketball");
        hobbies.add("Table Tennis");
        hobbies.add("Coding");
        hobbies.add("Playing Guitar");
        ArrayAdapter myAdapter = new ArrayAdapter(this, android.R.layout. simple_list_item_1, hobbies);
        listViewHobbies.setAdapter(myAdapter);


    }
}