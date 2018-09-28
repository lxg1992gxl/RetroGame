package com.example.xinyuan.comp2100_frogger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void startPressed(View view) {
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);
    }
}
