package com.example.xinyuan.comp2100_frogger;


public class Pos {

    float x, y;

    public Pos(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float distance(Pos p) {
        float dx = x - p.x;
        float dy = y - p.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public boolean rectCircleIntersects(Frog f, Wood w) {
        float width = w.woodWidth;
        float height = w.woodHeight;

        float fLeft = f.xc - f.FROGRADIUS;
        float fRight = f.xc + f.FROGRADIUS;
        float fTop = f.yc - f.FROGRADIUS;
        float fBottom = f.yc + f.FROGRADIUS;

        return !(fLeft >= w.xc + width || fRight <= w.xc || fTop >= w.yc + height || fBottom <= w.yc);
    }

    //copied from upper
    //change arguments for car using
    //TODO anyone combine these two method together?
    public boolean rectCircleIntersect(Frog f, Car c) {
        float width = c.carWidth;
        float height = c.carHeight;

        float fLeft = f.xc - f.FROGRADIUS;
        float fRight = f.xc + f.FROGRADIUS;
        float fTop = f.yc - f.FROGRADIUS;
        float fBottom = f.yc + f.FROGRADIUS;

        return !(fLeft >= c.xc + width || fRight <= c.xc || fTop >= c.yc + height || fBottom <= c.yc);
    }

    //not used
    public boolean hitByCar(Frog f, Car c) {
        float w = c.carWidth;
        float h = c.carHeight;

        float distX = Math.abs(f.xc- c.xc - w / 2);
        float distY = Math.abs(f.yc - c.yc - h / 2);

        if (distX > (w / 2 + f.FROGRADIUS)) {
            return false;
        }
        if (distY > (h / 2 + f.FROGRADIUS)) {
            return false;
        }
        if (distX <= (w / 2)) {
            return true;
        }
        if (distY <= (h / 2)) {
            return true;
        }
        float dx = distX - w / 2;
        float dy = distY - h / 2;
        return (dx * dx + dy * dy <= (f.FROGRADIUS * f.FROGRADIUS));
    }

    //reposition to start point
    public void replace(){
        this.x = 0.5f;
        this.y = 0.9f;
        Game.frogDied = false;
    }

}
