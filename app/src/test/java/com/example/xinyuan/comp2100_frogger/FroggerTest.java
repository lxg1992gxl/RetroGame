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
}