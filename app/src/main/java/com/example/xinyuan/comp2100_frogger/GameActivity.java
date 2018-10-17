package com.example.xinyuan.comp2100_frogger;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends AppCompatActivity implements GameOver{
    Dialog restart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        RoadView roadView = (RoadView) findViewById(R.id.roadView);
        roadView.registerGameOver(this);
    }


    @Override
    public void gameOver() {
        restart = new Dialog(this);
        restart.findViewById(R.id.restart);
        restart.setContentView(R.layout.restart_popup);
        restart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        restart.show();
    }

    public void restartClick(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }
}
