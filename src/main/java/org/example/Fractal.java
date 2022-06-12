package org.example;

public interface Fractal {

    PositionFr getZoom();

    int getFunction(double x, double y, int iterations);
}
