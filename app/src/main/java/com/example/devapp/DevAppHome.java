package com.example.devapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.devapp.BottomNavigation.BottomNavMainActivity;
import com.example.devapp.BucketList.BucketListActivity;
import com.example.devapp.ListView.ListViewActivity;
import com.example.devapp.TopNavigation.TopNavMainActivity;
import com.example.devapp.myJsonAPI.MyJsonAPIActivity;

public class DevAppHome extends AppCompatActivity {

    Button gotoTopNavBtn, gotoBottomNavBtn, gotoListView, gotoMyJsonApi, gotoBucketList;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev_app_home);

        gotoTopNavBtn = findViewById(R.id.gotoTopNavBtn);
        gotoBottomNavBtn = findViewById(R.id.gotoBottomNavBtn);
        gotoListView = findViewById(R.id.gotoListView);
        gotoMyJsonApi = findViewById(R.id.gotoMyJsonApi);
        gotoBucketList = findViewById(R.id.gotoBucketList);

        gotoTopNavBtn.setOnClickListener(v-> {
            intent = new Intent(DevAppHome.this, TopNavMainActivity.class);
            startActivity(intent);
        });

        gotoBottomNavBtn.setOnClickListener(v-> {
            intent = new Intent(DevAppHome.this, BottomNavMainActivity.class);
            startActivity(intent);
        });

        gotoListView.setOnClickListener(v-> {
            intent = new Intent(DevAppHome.this, ListViewActivity.class);
            startActivity(intent);
        });

        gotoMyJsonApi.setOnClickListener(v-> {
            intent = new Intent(DevAppHome.this, MyJsonAPIActivity.class);
            startActivity(intent);
        });

        gotoBucketList.setOnClickListener(v-> {
            intent = new Intent(DevAppHome.this, BucketListActivity.class);
            startActivity(intent);
        });
    }
}