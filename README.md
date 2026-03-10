This is a basic explanation of the Maven Geometry Library project without any icons or emojis.

Project Overview
This project is a math library built using Maven. It uses a multi-module structure, which means the project is split into different folders that work together. This makes the code easier to organize and update.

Project Structure
The project is divided into two main parts:

1. GeometryLibrary (The Logic)
This is the main library where all the math calculations are stored. It contains three modules:

geometry-2d: This module handles flat shapes like circles, triangles, and rectangles. It is version 1.1.0, which is a stable release.

geometry-utils: This module contains extra tools, like converting meters to centimeters or comparing the areas of two shapes. It is currently a SNAPSHOT version.

geometry-3d: This module handles 3D shapes like cubes and spheres. It calculates volume and surface area. It is also a SNAPSHOT version.

2. GeometryApp (The User Interface)
This is a separate application that uses the library. It provides a menu in the terminal so a user can pick a shape and get the results of a calculation.

Key Maven Concepts
Multi-Module Architecture
Instead of having one giant folder with all the code, we use a parent project that manages smaller sub-projects (modules). The parent folder has a file called a POM that controls the settings for everything inside it.

Release vs. SNAPSHOT Versions
Release (1.1.0): This is a finished, stable version of the code. It does not change once it is published.

SNAPSHOT (1.1.0-SNAPSHOT): This is a version that is still under development. It allows developers to make frequent changes without changing the version number every time.

How to Build and Run the Project
To get the project working, you need to follow these steps in your terminal:

Build the Library:
Navigate to the GeometryLibrary folder and run:
mvn clean install
This compiles all the modules and prepares them for use.

Run the Application:
Navigate to the GeometryApp folder and run:
mvn exec:java
This starts the interactive menu for the user.

Summary of Features
2D Shapes: Area and perimeter for circles, rectangles, and triangles.

3D Shapes: Volume and surface area for cubes and spheres.

Utilities: Unit conversion and math comparison tools.

Interface: A simple menu-driven console app.