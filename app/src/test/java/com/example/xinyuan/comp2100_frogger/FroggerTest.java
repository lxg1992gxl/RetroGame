package com.example.xinyuan.comp2100_frogger;

import android.graphics.Canvas;
import android.graphics.Paint;

import org.junit.Test;

import static org.junit.Assert.*;

public class FroggerTest {

    @Test
    public void testGenerateWoods() {
        assertEquals(9, Woods.generateWoods().size());
    }
//    @Test
//    public void testJumpedOnWoods() {
//        Wood w = new Wood(1.0f, 0.2f, 100, 1);
//        Frog f = new Frog();
//        Canvas c = new Canvas();
//        Paint p = new Paint();
//
//        assertTrue(f.pos.jumpedOnWoods(f,w));
//    }
    @Test
    public void testCheckRegion(){
        RoadView.canvasH = 1000;
        RoadView.canvasW = 500;
        float x = 0;
        float y = 350;
        assertEquals("GOUP", RoadView.checkRegion(x, y));
        x = 0;
        y = 650;
        assertEquals("GODOWN", RoadView.checkRegion(x, y));
        x = 0;
        y = 550;
        assertEquals("GOLEFT", RoadView.checkRegion(x, y));
        x = 300;
        y = 550;
        assertEquals("GORIGHT", RoadView.checkRegion(x, y));
    }
}