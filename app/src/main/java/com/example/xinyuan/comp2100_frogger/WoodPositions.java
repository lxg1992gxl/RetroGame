package com.example.xinyuan.comp2100_frogger;

import java.util.Random;

public class WoodPositions {
    static final float[][][] easyMode = {{{0.2f, 100}, {0.4f, 150}, {0.7f, 170},
            {0.1f, 170}, {0.5f, 130}, {0.8f, 100},
            {0.25f, 130}, {0.45f, 100}, {0.9f, 150}},

            {{0.1f, 180}, {0.4f, 140}, {0.8f, 150},
                    {0.25f, 180}, {0.5f, 130}, {0.8f, 150},
                    {0.1f, 200}, {0.35f, 150}, {0.9f, 150},},

            {{0.15f, 170}, {0.4f, 170}, {0.7f, 150},
                    {0.25f, 180}, {0.55f, 150}, {0.75f, 200},
                    {0.1f, 200}, {0.45f, 130}, {0.85f, 180}}};

    public static float[][] getPosition() {
        Random random = new Random();
        int i = random.nextInt(3);
        System.out.println(i);
        return easyMode[i];
    }
}
