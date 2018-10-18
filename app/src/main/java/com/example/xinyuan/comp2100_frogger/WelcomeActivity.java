package com.example.xinyuan.comp2100_frogger;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    Dialog difficultLevel;
    Dialog help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        difficultLevel = new Dialog(this);
        help = new Dialog(this);
    }
    // A dialog to choose what difficult levels

    public void showPopup(View view) {
        difficultLevel.findViewById(R.id.easy);
        difficultLevel.findViewById(R.id.medium);
        difficultLevel.findViewById(R.id.hard);
        difficultLevel.setContentView(R.layout.difficult_level_popup);
        difficultLevel.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        difficultLevel.show();
    }
    // Button clicks on dialog
    public void easyClick(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        Game.gameMode = "EASY";
        difficultLevel.dismiss();
        startActivity(intent);
        finish();
    }

    public void mediumClick(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        Game.gameMode = "MEDIUM";
        difficultLevel.dismiss();
        startActivity(intent);
        finish();
    }

    public void hardClick(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        Game.gameMode = "HARD";
        difficultLevel.dismiss();
        startActivity(intent);
        finish();
    }

    // Create a help menu

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Help:
                help.findViewById(R.id.close);
                help.setContentView(R.layout.help_popup);
                help.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                help.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void closeClick(View view) {
        help.dismiss();
    }



}
