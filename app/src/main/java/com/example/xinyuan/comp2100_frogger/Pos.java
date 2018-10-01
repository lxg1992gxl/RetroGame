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
        return (float) Math.sqrt(dx*dx + dy*dy);
    }

    public boolean rectCircleColliding(Frog f, Car c){
        float w = 100;
        float h = 50;
//        System.out.println("Frog has a radius of " + f.FROGRADIUS + ", x of " + f.xc + " and y of " + f.yc);
//        System.out.println("Car has a x of " + c.xc + ", y of " + c.yc + ", width of " + w + " and height of " + h);
        float distX = Math.abs(f.pos.x - c.pos.x - w/2);
        float distY = Math.abs(f.pos.y - c.pos.y - h/2);

        if (distX > (w/2 + f.FROGRADIUS)) {
            return false;
        }
        if (distY > (h/2 + f.FROGRADIUS)) {
            return false;
        }

        if (distX <= (w/2)) {
            return true;
        }
        if (distY <= (h/2)) {
            return true;
        }

        float dx = distX - w/2;
        float dy = distY - h/2;
        return (dx*dx+dy*dy<=(f.FROGRADIUS*f.FROGRADIUS));
    }

//    public static void main(String[] args) {
//        Frog f = new Frog();
//        Car c = new Car(0.5f,0.9f);
//        System.out.println(rectCircleColliding(f,c));
//    }

}
