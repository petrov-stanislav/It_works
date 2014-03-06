package com.cgsg.it_works;

/**
 * Created with IntelliJ IDEA.
 * User: Yaroslav
 * Date: 04.03.14
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 */
public class Matr3 {
    public double
            a11, a12, a13,
            a21, a22, a23,
            a31, a32, a33;

    public Matr3() {
    }

    public Matr3(double a11, double a12,
                 double a21, double a22,
                 double a31, double a32) {
        this.a11 = a11;
        this.a12 = a12;
        this.a13 = 0;
        this.a21 = a21;
        this.a22 = a22;
        this.a23 = 0;
        this.a31 = a31;
        this.a32 = a32;
        this.a33 = 1;
    }

    public Matr3(double a11, double a12, double a13,
                 double a21, double a22, double a23,
                 double a31, double a32, double a33) {
        this.a11 = a11;
        this.a12 = a12;
        this.a13 = a13;
        this.a21 = a21;
        this.a22 = a22;
        this.a23 = a23;
        this.a31 = a31;
        this.a32 = a32;
        this.a33 = a33;
    }

    public Matr3(Matr3 m) {
        this.a11 = m.a11;
        this.a12 = m.a12;
        this.a13 = m.a13;
        this.a21 = m.a21;
        this.a22 = m.a22;
        this.a23 = m.a23;
        this.a31 = m.a31;
        this.a32 = m.a32;
        this.a33 = m.a33;
    }

    public Matr3 SetUnit() {
        this.a11 = 1;
        this.a12 = 0;
        this.a13 = 0;

        this.a21 = 0;
        this.a22 = 1;
        this.a23 = 0;

        this.a31 = 0;
        this.a32 = 0;
        this.a33 = 1;

        return this;
    }

    public Matr3 SetRotate(double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);

        this.a11 = cos;
        this.a12 = -sin;
        this.a13 = 0;

        this.a21 = sin;
        this.a22 = cos;
        this.a23 = 0;

        this.a31 = 0;
        this.a32 = 0;
        this.a33 = 1;

        return this;
    }

    public Matr3 SetTranslate(Vec2 v) {
        this.a11 = 1;
        this.a12 = 0;
        this.a13 = 0;

        this.a21 = 0;
        this.a22 = 1;
        this.a23 = 0;

        this.a31 = v.x;
        this.a32 = v.y;
        this.a33 = 1;

        return this;
    }

    public Matr3 Multiply(Matr3 m) {
        Matr3 r = new Matr3();

        r.a11 = a11 * m.a11 + a12 * m.a21;
        r.a12 = a11 * m.a12 + a12 * m.a22;
        r.a13 = 0;

        r.a21 = a21 * m.a11 + a22 * m.a21;
        r.a22 = a21 * m.a12 + a22 * m.a22;
        r.a23 = 0;

        r.a31 = a31 * m.a11 + a32 * m.a21 + m.a31;
        r.a32 = a31 * m.a12 + a32 * m.a22 + m.a32;
        r.a33 = 1;

        return r;
    }

    public Matr3 Multiplying(Matr3 m) {
        Matr3 r = new Matr3(this);

        a11 = r.a11 * m.a11 + r.a12 * m.a21;
        a12 = r.a11 * m.a12 + r.a12 * m.a22;
        a13 = 0;

        a21 = r.a21 * m.a11 + r.a22 * m.a21;
        a22 = r.a21 * m.a12 + r.a22 * m.a22;
        a23 = 0;

        a31 = r.a31 * m.a11 + r.a32 * m.a21 + m.a31;
        a32 = r.a31 * m.a12 + r.a32 * m.a22 + m.a32;
        a33 = 1;

        return this;
    }

    public double Determ() {
        return a11 * a22 * a33 + a12 * a23 * a31 + a13 * a21 * a32 - a13 * a22 * a31 - a12 * a21 * a33 - a11 * a23 * a32;
    }
}
