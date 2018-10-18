package com.example.xinyuan.comp2100_frogger;


import android.content.Context;
import android.media.MediaPlayer;

public class BGM {

    // play bgm
    public static MediaPlayer play(Context c, String bgm) {
        MediaPlayer mp;
        if (bgm == "ROAD") {
            mp = MediaPlayer.create(c, R.raw.road);
            return mp;
        }
        else if (bgm == "RIVER") {
            mp = MediaPlayer.create(c, R.raw.river);
            return mp;
        }
        else if (bgm == "VIC") {
            mp = MediaPlayer.create(c, R.raw.victory);
            return mp;
        }
        else if (bgm == "GG") {
            mp = MediaPlayer.create(c, R.raw.gg);
            return mp;
        }
        return null;
    }

    // reset the bgm
    public static void stopPlaying(MediaPlayer mp) {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
