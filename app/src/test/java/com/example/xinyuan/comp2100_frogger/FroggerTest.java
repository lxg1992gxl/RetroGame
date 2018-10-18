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
    public void testGenerateCars() {
        assertEquals(9, Cars.generateCar().size());
    }

    @Test
    public void testRrplace() {
        Frog a = new Frog();
        a.pos.replace();
        assertTrue("The x position of frog a should be 0.5, but get",a.pos.x==0.5f);
        assertTrue("The y position of frog a should be 0.5, but get",a.pos.y==0.9f);
    }


}