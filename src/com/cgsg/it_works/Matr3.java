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
}
