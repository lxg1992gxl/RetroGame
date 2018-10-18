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
import android.widget.TextView;
//This class is written by Zirui Tan
public class GameActivity extends AppCompatActivity implements GameOver{
    Dialog restart;
    Dialog help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        RoadView roadView = (RoadView) findViewById(R.id.roadView);
        roadView.registerGameOver(this);
        help = new Dialog(this);
    }

    @Override
    //A dialog shown when game over.
    public void gameOver() {
        restart = new Dialog(this);
        restart.findViewById(R.id.restart);
        restart.setContentView(R.layout.restart_popup);
        restart.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView textView = restart.findViewById(R.id.showScore);
        textView.setText("You've scored: " + Game.score.getScore());
        restart.show();
        BGM.stopPlaying(RoadView.mp);
        onStop();
    }
    //Return to welcome activity to restart the game.
    public void restartClick(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        restart.dismiss();
        startActivity(intent);
        finish();
    }
    // Help menu
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
