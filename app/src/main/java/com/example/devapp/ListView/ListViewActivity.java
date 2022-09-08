package com.example.devapp.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.devapp.R;
import com.example.devapp.databinding.ActivityListViewBinding;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;
    ActivityListViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listView = findViewById(R.id.listView);

        String[] names = {"Zia", "Venice", "Damer"};
        String[] msgs = {""+R.string.sample_msg, ""+R.string.sample_msg, ""+R.string.sample_msg};
        String[] msgTimes = {"08:12 PM", "09:43 PM", "02:54PM"};
        String[] phoneNums = {"09123123123", "09324324324", "09890890890"};
        String[] countries = {"Bulgaria", "Belgium", "Basak"};
        int[] imageIds = {R.drawable.download, R.drawable.downloadd, R.drawable.downloaddd};

        ArrayList<User> arrayListUsers = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            User user = new User(names[i], msgs[i], msgTimes[i], phoneNums[i], countries[i], imageIds[i]);
            arrayListUsers.add(user);
        }

        ListAdapter myAdapter = new ListAdapter(ListViewActivity.this, arrayListUsers);
        binding.listView.setAdapter(myAdapter);
        binding.listView.setClickable(true);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListViewActivity.this, ListViewShowActivity.class);
                intent.putExtra("image", imageIds[position]);
                intent.putExtra("name", names[position]);
                intent.putExtra("number", phoneNums[position]);
                intent.putExtra("country", countries[position]);
                startActivity(intent);
            }
        });

    }
}