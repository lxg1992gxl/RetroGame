package com.example.xinyuan.comp2100_frogger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        RoadView roadView = (RoadView) findViewById(R.id.roadView);
    }
}