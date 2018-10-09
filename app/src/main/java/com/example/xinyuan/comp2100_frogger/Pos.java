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

    public boolean rectCircleColliding(Frog f, Car c) {
        float w = c.carWidth;
        float h = c.carHeight;

        float distX = Math.abs(f.pos.x - c.pos.x - w / 2);
        float distY = Math.abs(f.pos.y - c.pos.y - h / 2);

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
    }

//    public static void main(String[] args) {
//        Frog f = new Frog();
//        Car c = new Car(0.5f,0.9f);
//        System.out.println(rectCircleColliding(f,c));
//    }

}
