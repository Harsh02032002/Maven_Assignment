package com.geometry.app;

import com.geometry.shape2d.Circle;
import com.geometry.shape2d.Rectangle;
import com.geometry.shape2d.Triangle;
import com.geometry.shape2d.Shape;
import com.geometry.utils.GeometryUtils;
import com.geometry.shape3d.Cube;
import com.geometry.shape3d.Sphere;
import com.geometry.shape3d.ThreeDShape;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> calculationHistory = new ArrayList<>();
    
    public static void main(String[] args) {
        // Welcome Screen
        printWelcomeBanner();
        
        // Main menu loop
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = getIntInput("Enter your choice (1-4): ", 1, 4);
            
            switch (choice) {
                case 1:
                    handle2DShapes();
                    break;
                case 2:
                    handle3DShapes();
                    break;
                case 3:
                    handleUtils();
                    break;
                case 4:
                    running = false;
                    printSummary();
                    break;
            }
        }
        
        System.out.println("\nThank you for using Geometry Calculator! Goodbye!");
        scanner.close();
    }
    
    private static void printWelcomeBanner() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║           Welcome to Geometry Calculator v1.1.0            ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  This app calculates area, perimeter, and more for 2D/3D     ║");
        System.out.println("║  shapes. Follow prompts to input values.                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    private static void printMainMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("MAIN MENU");
        System.out.println("=".repeat(60));
        System.out.println("1. Calculate 2D Shape");
        System.out.println("2. Calculate 3D Shape");
        System.out.println("3. Use Utils");
        System.out.println("4. Exit");
        System.out.println("=".repeat(60));
    }
    
    private static void handle2DShapes() {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("2D SHAPES MENU");
        System.out.println("-".repeat(40));
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.println("4. Back to Main Menu");
        System.out.println("-".repeat(40));
        
        int choice = getIntInput("Choose a 2D shape (1-4): ", 1, 4);
        
        switch (choice) {
            case 1:
                calculateCircle();
                break;
            case 2:
                calculateRectangle();
                break;
            case 3:
                calculateTriangle();
                break;
        }
    }
    
    private static void calculateCircle() {
        System.out.println("\n" + "*".repeat(30));
        System.out.println("CIRCLE CALCULATION");
        System.out.println("*".repeat(30));
        
        double radius = getPositiveDoubleInput("Enter radius (in meters, e.g., 5.0): ");
        
        Shape circle = new Circle(radius);
        displayShapeResults("Circle", "radius " + radius + "m", circle);
        
        addToHistory("Circle (r=" + GeometryUtils.formatDouble(radius) + "m)", 
                    circle.calculateArea(), circle.calculatePerimeter(), 0);
        
        pauseForUser();
    }
    
    private static void calculateRectangle() {
        System.out.println("\n" + "*".repeat(30));
        System.out.println("RECTANGLE CALCULATION");
        System.out.println("*".repeat(30));
        
        double length = getPositiveDoubleInput("Enter length (in meters, e.g., 4.0): ");
        double width = getPositiveDoubleInput("Enter width (in meters, e.g., 6.0): ");
        
        Shape rectangle = new Rectangle(length, width);
        displayShapeResults("Rectangle", length + "m x " + width + "m", rectangle);
        
        addToHistory("Rectangle (" + GeometryUtils.formatDouble(length) + "x" + GeometryUtils.formatDouble(width) + "m)", 
                    rectangle.calculateArea(), rectangle.calculatePerimeter(), 0);
        
        pauseForUser();
    }
    
    private static void calculateTriangle() {
        System.out.println("\n" + "*".repeat(30));
        System.out.println("TRIANGLE CALCULATION");
        System.out.println("*".repeat(30));
        
        double side1, side2, side3;
        do {
            side1 = getPositiveDoubleInput("Enter side a (in meters, e.g., 3.0): ");
            side2 = getPositiveDoubleInput("Enter side b (in meters, e.g., 4.0): ");
            side3 = getPositiveDoubleInput("Enter side c (in meters, e.g., 5.0): ");
            
            if (!GeometryUtils.isValidTriangle(side1, side2, side3)) {
                System.out.println("❌ Sides can't form a triangle! Try different values.");
            }
        } while (!GeometryUtils.isValidTriangle(side1, side2, side3));
        
        Shape triangle = new Triangle(side1, side2, side3);
        displayShapeResults("Triangle", side1 + "-" + side2 + "-" + side3 + "m", triangle);
        
        addToHistory("Triangle (" + GeometryUtils.formatDouble(side1) + "-" + GeometryUtils.formatDouble(side2) + "-" + GeometryUtils.formatDouble(side3) + "m)", 
                    triangle.calculateArea(), triangle.calculatePerimeter(), 0);
        
        pauseForUser();
    }
    
    private static void handle3DShapes() {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("3D SHAPES MENU");
        System.out.println("-".repeat(40));
        System.out.println("1. Cube");
        System.out.println("2. Sphere");
        System.out.println("3. Back to Main Menu");
        System.out.println("-".repeat(40));
        
        int choice = getIntInput("Choose a 3D shape (1-3): ", 1, 3);
        
        switch (choice) {
            case 1:
                calculateCube();
                break;
            case 2:
                calculateSphere();
                break;
        }
    }
    
    private static void calculateCube() {
        System.out.println("\n" + "*".repeat(30));
        System.out.println("CUBE CALCULATION");
        System.out.println("*".repeat(30));
        
        double side = getPositiveDoubleInput("Enter side length (in meters, e.g., 2.0): ");
        
        ThreeDShape cube = new Cube(side);
        display3DShapeResults("Cube", "side " + side + "m", cube);
        
        addToHistory("Cube (s=" + GeometryUtils.formatDouble(side) + "m)", 
                    cube.calculateArea(), cube.calculatePerimeter(), cube.calculateVolume());
        
        pauseForUser();
    }
    
    private static void calculateSphere() {
        System.out.println("\n" + "*".repeat(30));
        System.out.println("SPHERE CALCULATION");
        System.out.println("*".repeat(30));
        
        double radius = getPositiveDoubleInput("Enter radius (in meters, e.g., 3.0): ");
        
        ThreeDShape sphere = new Sphere(radius);
        display3DShapeResults("Sphere", "radius " + radius + "m", sphere);
        
        addToHistory("Sphere (r=" + GeometryUtils.formatDouble(radius) + "m)", 
                    sphere.calculateArea(), sphere.calculatePerimeter(), sphere.calculateVolume());
        
        pauseForUser();
    }
    
    private static void handleUtils() {
        System.out.println("\n" + "-".repeat(40));
        System.out.println("UTILS MENU");
        System.out.println("-".repeat(40));
        System.out.println("1. Compare two shapes' areas");
        System.out.println("2. Convert area to cm²");
        System.out.println("3. Check triangle validity");
        System.out.println("4. Area difference");
        System.out.println("5. Back to Main Menu");
        System.out.println("-".repeat(40));
        
        int choice = getIntInput("Choose a utility (1-5): ", 1, 5);
        
        switch (choice) {
            case 1:
                compareAreas();
                break;
            case 2:
                convertToCm();
                break;
            case 3:
                checkTriangleValidity();
                break;
            case 4:
                calculateAreaDifference();
                break;
        }
    }
    
    private static void compareAreas() {
        System.out.println("\n" + "*".repeat(30));
        System.out.println("COMPARE AREAS");
        System.out.println("*".repeat(30));
        
        System.out.println("Create first shape:");
        Shape shape1 = createShapeFromUser();
        
        System.out.println("\nCreate second shape:");
        Shape shape2 = createShapeFromUser();
        
        String result = GeometryUtils.compareAreas(shape1, shape2);
        System.out.println("\n📊 Comparison Result:");
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.println("│ " + result + " │");
        System.out.println("└─────────────────────────────────────────────────┘");
        
        pauseForUser();
    }
    
    private static Shape createShapeFromUser() {
        System.out.println("\nAvailable shapes:");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        
        int choice = getIntInput("Choose shape type (1-3): ", 1, 3);
        
        switch (choice) {
            case 1:
                double radius = getPositiveDoubleInput("Enter radius (m): ");
                return new Circle(radius);
            case 2:
                double length = getPositiveDoubleInput("Enter length (m): ");
                double width = getPositiveDoubleInput("Enter width (m): ");
                return new Rectangle(length, width);
            case 3:
                double a, b, c;
                do {
                    a = getPositiveDoubleInput("Enter side a (m): ");
                    b = getPositiveDoubleInput("Enter side b (m): ");
                    c = getPositiveDoubleInput("Enter side c (m): ");
                    if (!GeometryUtils.isValidTriangle(a, b, c)) {
                        System.out.println("❌ Invalid triangle sides!");
                    }
                } while (!GeometryUtils.isValidTriangle(a, b, c));
                return new Triangle(a, b, c);
            default:
                return null;
        }
    }
    
    private static void convertToCm() {
        System.out.println("\n" + "*".repeat(30));
        System.out.println("CONVERT AREA TO CM²");
        System.out.println("*".repeat(30));
        
        double areaInMeters = getPositiveDoubleInput("Enter area in square meters: ");
        double areaInCm = GeometryUtils.convertMetersToCentimeters(areaInMeters);
        
        System.out.println("\n📏 Conversion Result:");
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.printf("│ %-20s: %12.2f m²         │%n", "Area in meters", areaInMeters);
        System.out.printf("│ %-20s: %12.2f cm²        │%n", "Area in centimeters", areaInCm);
        System.out.println("└─────────────────────────────────────────────────┘");
        
        pauseForUser();
    }
    
    private static void checkTriangleValidity() {
        System.out.println("\n" + "*".repeat(30));
        System.out.println("TRIANGLE VALIDITY CHECK");
        System.out.println("*".repeat(30));
        
        double a = getPositiveDoubleInput("Enter side a (m): ");
        double b = getPositiveDoubleInput("Enter side b (m): ");
        double c = getPositiveDoubleInput("Enter side c (m): ");
        
        boolean isValid = GeometryUtils.isValidTriangle(a, b, c);
        
        System.out.println("\n🔍 Triangle Validity:");
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.printf("│ Sides: %.1f, %.1f, %.1f                          │%n", a, b, c);
        System.out.printf("│ Result: %-40s │%n", isValid ? "✅ Valid Triangle" : "❌ Invalid Triangle");
        System.out.println("└─────────────────────────────────────────────────┘");
        
        pauseForUser();
    }
    
    private static void calculateAreaDifference() {
        System.out.println("\n" + "*".repeat(30));
        System.out.println("AREA DIFFERENCE");
        System.out.println("*".repeat(30));
        
        System.out.println("Create first shape:");
        Shape shape1 = createShapeFromUser();
        
        System.out.println("\nCreate second shape:");
        Shape shape2 = createShapeFromUser();
        
        double difference = GeometryUtils.areaDifference(shape1, shape2);
        
        System.out.println("\n📐 Area Difference:");
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.printf("│ %-20s: %12.2f m²         │%n", "Shape 1 Area", shape1.calculateArea());
        System.out.printf("│ %-20s: %12.2f m²         │%n", "Shape 2 Area", shape2.calculateArea());
        System.out.printf("│ %-20s: %12.2f m²         │%n", "Difference", difference);
        System.out.println("└─────────────────────────────────────────────────┘");
        
        pauseForUser();
    }
    
    private static void displayShapeResults(String shapeType, String description, Shape shape) {
        System.out.println("\n📊 " + shapeType + " Results:");
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.printf("│ %-20s: %-25s │%n", "Shape", shapeType + " (" + description + ")");
        System.out.printf("│ %-20s: %12.2f m²         │%n", "Area", shape.calculateArea());
        System.out.printf("│ %-20s: %12.2f m          │%n", "Perimeter", shape.calculatePerimeter());
        System.out.println("└─────────────────────────────────────────────────┘");
    }
    
    private static void display3DShapeResults(String shapeType, String description, ThreeDShape shape) {
        System.out.println("\n📊 " + shapeType + " Results:");
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.printf("│ %-20s: %-25s │%n", "Shape", shapeType + " (" + description + ")");
        System.out.printf("│ %-20s: %12.2f m²         │%n", "Surface Area", shape.calculateArea());
        System.out.printf("│ %-20s: %12.2f m          │%n", "Total Edge Length", shape.calculatePerimeter());
        System.out.printf("│ %-20s: %12.2f m³         │%n", "Volume", shape.calculateVolume());
        System.out.println("└─────────────────────────────────────────────────┘");
    }
    
    private static void addToHistory(String shapeName, double area, double perimeter, double volume) {
        String entry = String.format("%-20s | Area: %8.2f m² | Perimeter: %8.2f m", 
                                    shapeName, area, perimeter);
        if (volume > 0) {
            entry += String.format(" | Volume: %8.2f m³", volume);
        }
        calculationHistory.add(entry);
    }
    
    private static void printSummary() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("CALCULATION SUMMARY");
        System.out.println("=".repeat(80));
        
        if (calculationHistory.isEmpty()) {
            System.out.println("No calculations performed yet.");
        } else {
            System.out.println("┌──────────────────────────────────────────────────────────────────────────────┐");
            System.out.println("│ Shape                | Area (m²)   | Perimeter (m) | Volume (m³)           │");
            System.out.println("├──────────────────────────────────────────────────────────────────────────────┤");
            for (String entry : calculationHistory) {
                System.out.println("│ " + entry + " │");
            }
            System.out.println("└──────────────────────────────────────────────────────────────────────────────┘");
            System.out.println("\nTotal calculations: " + calculationHistory.size());
        }
        
        System.out.println("=".repeat(80));
    }
    
    private static double getPositiveDoubleInput(String prompt) {
        double value;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.print("❌ Invalid input! Enter a number: ");
                scanner.next();
            }
            value = scanner.nextDouble();
            if (value <= 0) {
                System.out.print("❌ Invalid! Value must be positive. Try again: ");
            }
        } while (value <= 0);
        scanner.nextLine(); // Consume newline
        return value;
    }
    
    private static int getIntInput(String prompt, int min, int max) {
        int value;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.print("❌ Invalid input! Enter a number: ");
                scanner.next();
            }
            value = scanner.nextInt();
            if (value < min || value > max) {
                System.out.printf("❌ Invalid! Enter a number between %d and %d: ", min, max);
            }
        } while (value < min || value > max);
        scanner.nextLine(); // Consume newline
        return value;
    }
    
    private static void pauseForUser() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }
}
