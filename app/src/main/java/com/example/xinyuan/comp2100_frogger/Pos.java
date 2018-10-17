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


    //reposition to start point
    public void replace(){
        this.x = 0.5f;
        this.y = 0.9f;
        Game.frogDied = false;
    }

//    public static void main(String[] args) {
//        Frog f = new Frog();
//        Car c = new Car(0.5f,0.9f);
//        System.out.println(rectCircleColliding(f,c));
//    }

}
