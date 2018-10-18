package com.example.xinyuan.comp2100_frogger;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarTest {

    @Test
    public void outOfTheRoad() {
        Car carInRoad = new Car(0.1f, 0.6f,180,1);
        carInRoad.movingleft = true;
        assertFalse("Expected to get false, but got " + carInRoad.outOfTheRoad(), carInRoad.outOfTheRoad());

        Car carInRoad1 = new Car(0.9f, 0.8f,180,3);
        carInRoad1.movingleft = false;
        assertFalse("Expected to get false, but got " + carInRoad1.outOfTheRoad(), carInRoad1.outOfTheRoad());

        Car carOutOfRoad = new Car(-0.1f, 0.6f,180,1);
        carOutOfRoad.movingleft = true;
        assertTrue("Expected to get true, but got " + carOutOfRoad.outOfTheRoad(), carOutOfRoad.outOfTheRoad());

        Car carOutOfRoad1 = new Car(1.1f, 0.7f,180,2);
        carOutOfRoad1.movingleft = false;
        assertTrue("Expected to get true, but got " + carOutOfRoad1.outOfTheRoad(), carOutOfRoad1.outOfTheRoad());
    }
}