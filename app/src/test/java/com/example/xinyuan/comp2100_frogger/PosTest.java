package com.example.xinyuan.comp2100_frogger;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PosTest {

    @Test
    public void jumpedOnWoods() {
    }

    @Test
    public void hitByCar() {
        int cH = 1000;
        int cW = 500;
        Frog testFrog = new Frog();
        testFrog.xc = cW * testFrog.pos.x;
        testFrog.yc = cH * testFrog.pos.y;
        testFrog.pos.y -= 0.1f;           // emulate an UP jump
        testFrog.xc = cW * testFrog.pos.x;
        testFrog.yc = cH * testFrog.pos.y;
        Car testCar = new Car(0.5f,0.6f+0.1f+0.1f,120,3);
        testCar.xc = cW * testCar.pos.x;
        testCar.yc = cH * testCar.pos.y;
        assertTrue("Expected to get true, but got " + testFrog.pos.hitByCar(testFrog,testCar),
                testFrog.pos.hitByCar(testFrog,testCar) );

        Frog testFrog1 = new Frog();
        testFrog1.xc = cW * testFrog1.pos.x;
        testFrog1.yc = cH * testFrog1.pos.y;
        testFrog1.pos.y -= 0.1f;           // emulate an UP jump
        testFrog1.xc = cW * testFrog1.pos.x;
        testFrog1.yc = cH * testFrog1.pos.y;
        Car testCar1 = new Car(0.8f,0.6f+0.1f+0.1f,120,3);
        testCar1.xc = cW * testCar1.pos.x;
        testCar1.yc = cH * testCar1.pos.y;
        assertFalse("Expected to get false, but got " + testFrog1.pos.hitByCar(testFrog1,testCar1),
                testFrog1.pos.hitByCar(testFrog1,testCar1) );

        Frog testFrog2 = new Frog();
        testFrog2.xc = cW * testFrog2.pos.x;
        testFrog2.yc = cH * testFrog2.pos.y;
        testFrog2.pos.y -= 0.1f;           // emulate an UP jump
        testFrog2.pos.x -= 0.1f;           // emulate a LEFT jump
        testFrog2.pos.y -= 0.1f;            // emulate an UP jump
        testFrog2.xc = cW * testFrog2.pos.x;
        testFrog2.yc = cH * testFrog2.pos.y;
        Car testCar2 = new Car(0.4f,0.6f+0.1f,120,2);
        testCar2.xc = cW * testCar2.pos.x;
        testCar2.yc = cH * testCar2.pos.y;

        assertTrue("Expected to get true, but got " + testFrog2.pos.hitByCar(testFrog2,testCar2),
                testFrog2.pos.hitByCar(testFrog2,testCar2) );

        Frog testFrog3 = new Frog();
        testFrog3.xc = cW * testFrog3.pos.x;
        testFrog3.yc = cH * testFrog3.pos.y;
        testFrog3.pos.y -= 0.1f;           // emulate an UP jump
        testFrog3.pos.y -= 0.1f;           // emulate an UP jump
        testFrog3.pos.y -= 0.1f;           // emulate an UP jump
        testFrog3.pos.x += 0.1f;           // emulate a RIGHT jump
        testFrog3.pos.y += 0.1f;           // emualte a DOWN jump

        testFrog3.xc = cW * testFrog3.pos.x;
        testFrog3.yc = cH * testFrog3.pos.y;
        Car testCar3 = new Car(0.2f,0.6f+0.1f,120,2);
        testCar3.xc = cW * testCar3.pos.x;
        testCar3.yc = cH * testCar3.pos.y;
        assertFalse("Expected to get false, but got " + testFrog3.pos.hitByCar(testFrog3,testCar3),
                testFrog3.pos.hitByCar(testFrog3,testCar3) );

    }

}