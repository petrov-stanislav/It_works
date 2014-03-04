package com.cgsg.it_works;

/**
 * Created with IntelliJ IDEA.
 * User: Yaroslav
 * Date: 04.03.14
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class Vec2 {
    public double x, y;

    public Vec2() {
    }

    public Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    final public Vec2 Add(Vec2 v) {
        return new Vec2(v.x + x, v.y + y);
    }

    public Vec2 Adding(Vec2 v) {
        x += v.x;
        y += v.y;

        return this;
    }

    final public Vec2 Subtract(Vec2 v) {
        return new Vec2(x - v.x, y - v.y);
    }

    public Vec2 Subtracting(Vec2 v) {
        x -= v.x;
        y -= v.y;

        return this;
    }

    final public Vec2 Multiply(double k) {
        return new Vec2(x * k, y * k);
    }

    public Vec2 Multiplying(double k) {
        x *= k;
        y *= k;

        return this;
    }

    final public Vec2 Multiply(Matr3 m) {
        return new Vec2(x * m.a11 + y * m.a21 + m.a31, x * m.a12 + y * m.a22 + m.a32);
    }

    public Vec2 Multiplying(Matr3 m) {
        double x0 = x, y0 = y;
        x = x0 * m.a11 + y0 * m.a21 + m.a31;
        y = x0 * m.a12 + y0 * m.a22 + m.a32;

        return this;
    }

    final public double Multiply(Vec2 v) {
        return x * v.x + y * v.y;
    }

    final public double Lenght2() {
        return x * x + y * y;
    }

    final public double Lenght() {
        return Math.sqrt(Lenght2());
    }

    final public Vec2 Normalize() {
        double l =  1 / Lenght();

        return new Vec2(x * l, y * l);
    }

    public Vec2 Normalizeing(double k) {
        double l =  1 / Lenght();

        x *= l;
        y *= l;

        return this;
    }
}
