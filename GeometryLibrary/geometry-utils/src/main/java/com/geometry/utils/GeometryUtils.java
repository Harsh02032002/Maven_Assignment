package com.geometry.utils;

import com.geometry.shape2d.Shape;

public class GeometryUtils {
    
    public static double convertMetersToCentimeters(double meters) {
        return meters * 100;
    }
    
    public static String compareAreas(Shape s1, Shape s2) {
        double area1 = s1.calculateArea();
        double area2 = s2.calculateArea();
        if (area1 > area2) {
            return String.format("First shape has larger area by %.2f sq m", area1 - area2);
        } else if (area2 > area1) {
            return String.format("Second shape has larger area by %.2f sq m", area2 - area1);
        } else {
            return "Both shapes have equal area";
        }
    }
    
    public static boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && 
               a + b > c && a + c > b && b + c > a;
    }
    
    public static double areaDifference(Shape s1, Shape s2) {
        return Math.abs(s1.calculateArea() - s2.calculateArea());
    }
    
    public static String formatDouble(double value) {
        return String.format("%.2f", value);
    }
}
