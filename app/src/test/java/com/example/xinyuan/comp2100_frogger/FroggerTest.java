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

    @Test
    public void testJumpedOnWoods() {
        Wood w = new Wood(0, 0.2f, 100, 1);
        w.xc = 0;
        w.yc = 0.2f * 1000;
        w.woodHeight = 60;
        w.woodWidth = 100;
        Frog f = new Frog();
        f.xc = 20;
        f.yc = 210;
        assertTrue(f.pos.jumpedOnWoods(f,w));
        f.xc = 0;
        assertFalse(f.pos.jumpedOnWoods(f,w));
        f.xc = 20;
        f.yc = 230;
        assertFalse(f.pos.jumpedOnWoods(f,w));
    }

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

    @Test
    public void testGenerateCars() {
        assertEquals(9, Cars.generateCar().size());
    }

    @Test
    public void testReplace() {
        Frog a = new Frog();
        a.pos.replace();
        assertTrue("The x position of frog a should be 0.5, but get",a.pos.x==0.5f);
        assertTrue("The y position of frog a should be 0.5, but get",a.pos.y==0.9f);
    }


}