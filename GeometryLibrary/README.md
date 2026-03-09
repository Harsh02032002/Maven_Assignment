# Geometry Calculator v1.1.0

A fully interactive console application for calculating geometric properties of 2D and 3D shapes.

## Features

### 2D Shapes
- **Circle**: Calculate area and perimeter from radius
- **Rectangle**: Calculate area and perimeter from length and width  
- **Triangle**: Calculate area and perimeter from three sides (with validation using triangle inequality)

### 3D Shapes
- **Cube**: Calculate surface area, total edge length, and volume from side length

### Utilities
- **Compare Areas**: Compare areas of two shapes and show the difference
- **Convert Units**: Convert area from square meters to square centimeters
- **Triangle Validity**: Check if three sides can form a valid triangle
- **Area Difference**: Calculate the absolute difference between areas of two shapes

## How to Run

### Using Maven (Recommended)
```bash
cd GeometryLibrary
mvn compile exec:java
```

### Alternative: Compile and Run Manually
```bash
cd GeometryLibrary
mvn compile
java -cp target/classes com.geometry.App
```

## Interactive Features

### Welcome Screen
- Beautiful ASCII art banner with app information
- Clear instructions for users

### Menu-Driven Interface
- Main menu with numbered options
- Sub-menus for each category
- Input validation with helpful error messages
- "Press Enter to continue..." pauses for better user experience

### Input Validation
- All numeric inputs must be positive
- Triangle sides validated using triangle inequality theorem
- Clear error messages guide users to correct input
- Robust handling of invalid input types

### Output Formatting
- Boxed results with aligned columns
- Clear labels for all measurements
- Units displayed (meters, square meters, cubic meters)
- Professional table formatting

### Calculation History
- All calculations stored in memory
- Summary table displayed on exit
- Shows shape type, area, perimeter, and volume (for 3D shapes)

## Educational Value

This application demonstrates:
- **Object-Oriented Programming**: Abstract classes, inheritance, polymorphism
- **Java Collections**: Using ArrayList to store calculation history
- **Input/Output**: Scanner for user input, formatted output with printf
- **Mathematical Concepts**: Geometry formulas, unit conversion, triangle validation
- **Error Handling**: Robust input validation and user-friendly error messages
- **Software Architecture**: Clean separation of concerns, modular design

## Code Structure

```
src/main/java/com/geometry/
├── App.java              # Main interactive application
├── Shape.java            # Abstract base class for 2D shapes
├── Circle.java           # Circle implementation
├── Rectangle.java        # Rectangle implementation
├── Triangle.java         # Triangle implementation (Heron's formula)
├── threed/
│   ├── ThreeDShape.java  # Abstract base class for 3D shapes
│   └── Cube.java         # Cube implementation
└── utils/
    └── Utils.java        # Utility methods for comparisons and conversions
```

## Sample Session

```
╔══════════════════════════════════════════════════════════════╗
║           Welcome to Geometry Calculator v1.1.0            ║
╠══════════════════════════════════════════════════════════════╣
║  This app calculates area, perimeter, and more for 2D/3D     ║
║  shapes. Follow prompts to input values.                      ║
╚══════════════════════════════════════════════════════════════╝

============================================================
MAIN MENU
============================================================
1. Calculate 2D Shape
2. Calculate 3D Shape
3. Use Utils
4. Exit
============================================================

Enter your choice (1-4): 1

----------------------------------------
2D SHAPES MENU
----------------------------------------
1. Circle
2. Rectangle
3. Triangle
4. Back to Main Menu
----------------------------------------

Choose a 2D shape (1-4): 1

******************************
CIRCLE CALCULATION
******************************

Enter radius (in meters, e.g., 5.0): 5

📊 Circle Results:
┌─────────────────────────────────────────────────┐
│ Shape               : Circle (radius 5.0m)       │
│ Area               :        78.54 m²         │
│ Perimeter          :        31.42 m          │
└─────────────────────────────────────────────────┘

Press Enter to continue...
```

## Requirements

- Java 17 or higher
- Maven 3.6 or higher

## Dependencies

- No external dependencies required
- Uses only Java standard library
- JUnit 5 included for testing (test scope)

## License

This project is for educational purposes to demonstrate Java programming concepts and geometric calculations.
