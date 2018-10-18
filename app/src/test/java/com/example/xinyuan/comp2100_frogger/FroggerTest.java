package com.example.xinyuan.comp2100_frogger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FroggerTest {

    @Test
    public void testGenerateWoods() {
        assertEquals(9, Woods.generateWoods().size());
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

    @Test
    public void testReachGoal() {
        Frog testFrog;
        testFrog = new Frog();

        testFrog.pos.y -= 0.1f;   // emulate an UP jump
        assertFalse("Expected to get false, but got " + testFrog.reachGoal(),testFrog.reachGoal());

        testFrog.pos.x -= 0.1f;   // emulate an LEFT jump
        testFrog.pos.y -= 0.1f;   // emulate an UP jump
        assertFalse("Expected to get false, but got " + testFrog.reachGoal(),testFrog.reachGoal());

        testFrog.pos.x += 0.1f;   // emulate an RIGHT jump
        testFrog.pos.x += 0.1f;   // emulate an RIGHT jump
        assertFalse("Expected to get false, but got " + testFrog.reachGoal(),testFrog.reachGoal());

        testFrog.pos.y -= 0.1f;   // emulate an UP jump
        testFrog.pos.x -= 0.1f;   // emulate an LEFT jump
        testFrog.pos.y += 0.1f;   // emulate an DOWN jump
        testFrog.pos.y -= 0.1f;   // emulate an UP jump
        assertFalse("Expected to get false, but got " + testFrog.reachGoal(),testFrog.reachGoal());

        testFrog.pos.y -= 0.1f;   // emulate an UP jump
        testFrog.pos.y -= 0.1f;   // emulate an UP jump
        testFrog.pos.y -= 0.1f;   // emulate an UP jump
        testFrog.pos.y -= 0.1f;   // emulate an UP jump
        testFrog.pos.y -= 0.1f;   // emulate an UP jump
        assertTrue("Expected to get true, but got " + testFrog.reachGoal(), testFrog.reachGoal());



    }


}