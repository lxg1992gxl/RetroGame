package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public class Woods extends ArrayList<Wood> {

    public static Woods manyWoods(int weight,int num){
        Woods res = new Woods();
        float gap1 = num;
        float gap2 = num + 1;
        float gap3 = num + 2;
        for (float x = 0;x < weight ; x += weight/gap1 ){
            res.add(new Wood(x, 100f));
        }
        for (float x = 0;x < weight; x += weight/gap2 ){
            res.add(new Wood(x, 200f));
        }
        for (float x = 0;x < weight; x += weight/gap3 ){
            res.add(new Wood(x, 300f));
        }
        return res;
    }

    public void draw(Canvas c, Paint p){
        for (Wood a:this) a.draw(c, p);
    }
}
