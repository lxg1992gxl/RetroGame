package com.example.xinyuan.comp2100_frogger;

import java.util.Random;

public class Positions {

    static final float[][][] carPos = {   {{0.1f,100},{0.4f,150},{0.8f,170},
                                            {0.1f,170},{0.5f,130}, {0.7f,130},
                                            {0.2f,150},{0.45f,170}, {0.9f,100}},

                                             {{0.1f,180},{0.4f,140},{0.8f,150},
                                             {0.2f,180},{0.5f,130},{0.8f,120},
                                             {0.1f,200},{0.4f,150},{0.9f,180}},

                                             {{0.1f,190},{0.4f,170},{0.7f,150},
                                             {0.2f,180},{0.5f,110},{0.7f,190},
                                             {0.1f,230},{0.4f,150},{0.9f,180}}};


    static final float[][][] woodPos = {{{0.2f, 100}, {0.4f, 150}, {0.7f, 170},
                                        {0.1f, 170}, {0.5f, 130}, {0.8f, 100},
                                        {0.25f, 130}, {0.45f, 100}, {0.9f, 150}},

                                        {{0.1f, 180}, {0.4f, 140}, {0.8f, 150},
                                        {0.25f, 180}, {0.5f, 130}, {0.8f, 150},
                                        {0.1f, 200}, {0.35f, 150}, {0.9f, 150},},

                                        {{0.15f, 170}, {0.4f, 170}, {0.7f, 150},
                                        {0.25f, 180}, {0.55f, 150}, {0.75f, 200},
                                        {0.1f, 200}, {0.45f, 130}, {0.85f, 180}}};



    public static float[][] getPosition(String object) {
        if (object != "CAR" && object != "WOOD") throw new Error("no positions available for " + object);
        Random random = new Random();
        int i = random.nextInt(3);
        return (object == "CAR") ? carPos[i] : woodPos[i];
    }
}
