package com.geometry.threed;

public class Cube extends ThreeDShape {
    private double side;

    public Cube(double side) { this.side = side; }

    @Override
    public double calculateArea() { return 6 * side * side; }  // Surface area

    @Override
    public double calculatePerimeter() { return 12 * side; }  // Edge length total

    @Override
    public double calculateVolume() { return side * side * side; }
}