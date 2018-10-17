package com.example.xinyuan.comp2100_frogger;

import java.util.Random;

public class CarPositions {

    static final float[][][] easyMode = {   {{0.1f,100},{0.4f,150},{0.8f,170},
                                            {0.1f,170},{0.5f,130}, {0.7f,130},
                                            {0.2f,150},{0.45f,170}, {0.9f,100},},

                                            {{0.1f,180},{0.4f,140},{0.8f,150},
                                            {0.2f,180},{0.5f,130},{0.8f,120},
                                            {0.1f,200},{0.4f,150},{0.9f,180},},

                                            {{0.1f,190},{0.4f,170},{0.7f,150},
                                            {0.2f,180},{0.5f,110},{0.7f,190},
                                            {0.1f,230},{0.4f,150},{0.9f,180}}};



    public static float[][] getPosition() {
        Random random = new Random();
        int i = random.nextInt(3);
        System.out.println(i);
        return easyMode[i];
    }

    public static void main(String[] args) {
        System.out.println(easyMode[0][5][1]);
    }
}
