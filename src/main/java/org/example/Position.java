package org.example;
public class Position {
    private int x;
    private int y;
    Position(int X, int Y)
    {
        this.x = X;
        this.y = Y;
    }
    Position()
    {
        this.x = 0;
        this.y = 0;
    }
    public void move(int x_t, int y_t)
    {
        this.x += x_t;
        this.y += y_t;
    }
    public void move_to(int n_x, int n_y)
    {
        this.x = n_x;
        this.y = n_y;
    }
    public double getLength(Position b)
    {
        return Math.sqrt(Math.pow(this.getX() - b.getX(), 2) + Math.pow(this.getY() - b.getY(), 2));
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
