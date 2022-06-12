package org.example;

public class PositionFr {
    private double mx;
    private double bx;
    private double my;
    private double by;
    PositionFr(double Mx, double Bx, double My, double By)
    {
        this.mx = Mx;
        this.mx = Bx;
        this.mx = My;
        this.mx = By;
    }
    PositionFr()
    {
        this.mx = 0;
        this.bx = 0;
        this.my = 0;
        this.by = 0;
    }
    public double getBx() {
        return bx;
    }
    public double getBy() {
        return by;
    }
    public double getMx() {
        return mx;
    }
    public double getMy() {
        return my;
    }

    public PositionFr zoom(double zoom) {
        double lx = (bx - mx)*(zoom-1)/(2*zoom);
        double ly = (by - my)*(zoom-1)/(2*zoom);
        double xMin = mx + lx;
        double xMax = bx - lx;
        double yMin = my + ly;
        double yMax = by - ly;

        return new PositionFr(xMin, xMax, yMin, yMax);
    }
    public PositionFr move(double dx, double dy) {
        double xMin = mx + (bx - mx)*dx;
        double xMax = bx + (bx - mx)*dx;
        double yMin = my + (by - my)*dy;
        double yMax = by + (by - my)*dy;

        return new PositionFr(xMin, xMax, yMin, yMax);
    }
    public PositionFr resize(double width, double height) {
        if (width/height > 1) {
            double dx = (bx - mx)*(width/height - 1)/2;
            double xMin = mx - dx;
            double xMax = bx + dx;
            double yMin = my;
            double yMax = by;
            return new PositionFr(mx, bx, my, by);
        } if (width/height < 1) {
            double dy = (by - mx)*(height/width - 1)/2;
            double xMin = mx;
            double xMax = bx;
            double yMin = my - dy;
            double yMax = by + dy;
            return new PositionFr(mx, bx, my, by);
        } else {
            return this;
        }
    }
}
