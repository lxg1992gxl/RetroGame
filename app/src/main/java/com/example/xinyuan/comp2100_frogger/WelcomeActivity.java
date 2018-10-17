package com.example.xinyuan.comp2100_frogger;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    Dialog difficultLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        difficultLevel = new Dialog(this);
    }

    public void showPopup(View view) {
        Button btneasy;
        Button btnmedium;
        Button btnhard;
        btneasy = difficultLevel.findViewById(R.id.easy);
        btnmedium = difficultLevel.findViewById(R.id.medium);
        btnhard = difficultLevel.findViewById(R.id.hard);
        difficultLevel.setContentView(R.layout.difficult_level_popup);
        difficultLevel.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        difficultLevel.show();
    }

    public void easyClick(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void mediumClick(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void hardClick(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }


}
