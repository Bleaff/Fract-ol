package org.example;

public class Complex {
    public double x;
    public double y;

    Complex() {
        this.x = 0;
        this.y = 0;
    }

    Complex(double X, double Y) {
        this.x = X;
        this.y = Y;
    }

    Complex add(Complex a, Complex b) {
        return new Complex(a.x + b.x, a.y + b.y);
    }
    Complex sub(Complex a, Complex b) {
        return new Complex(a.x - b.x, a.y - b.y);
    }

    public Complex multi(Complex b)
    {
        return new Complex(this.x * b.x - this.y*b.y, this.y* b.x + this.x * b.y);
    }

    @Override
    public String toString() {
        if (y == 0)
            return x + "";
        else{
            if ( y > 0)
                return x + " + " + y + "i";
            else{
                return x + "" + y + "i";
            }
        }
    }
    public void pow(int p)
    {
        Complex res = this;
        if (p == 0){
            this.x = 1;
            this.y = 1;
            return ;
        }
        for (int i = 1; i < p; i++)
        {
            res = res.multi(this);
        }
        this.x = res.x;
        this.y = res.y;
    }
}
