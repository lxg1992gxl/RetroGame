package com.example.xinyuan.comp2100_frogger;

public class Pos {

    float x, y;

    public Pos(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Pos(Pos p) {
        this.x = p.x;
        this.y = p.y;
    }
}
