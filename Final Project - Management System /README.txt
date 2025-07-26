# Block Game Management System
**Final Project – Aaron Schelfo**  
JavaFX Application with SQL Integration

## Description
This JavaFX application simulates a block-based game management system. Users can interact with a block environment, perform basic movement, place or remove blocks, and manage resources through a simple inventory interface. Data persistence is handled via SQL.

## How to Run
1. Open the project in your IDE (recommended: IntelliJ IDEA).
2. Ensure Java 11 or later is installed.
3. Add JavaFX SDK and JDBC (e.g., SQLite or MySQL) libraries to your project's classpath.
4. Run `Main.java` to launch the application.

## UML Diagram
See `UML_Diagram.png` for a class diagram overview.

## Technical Overview
- The game loop updates the state continuously and renders changes using JavaFX.
- The world is represented using a 3D array structure.
- Each block is defined using a `Block` class that includes properties like texture and solidity.
- Player interaction is handled through keyboard and mouse input.
- Basic physics and collision detection are implemented to allow realistic movement.
- An inventory system allows resource collection, crafting, and block placement.

## Requirements
- Java 11 or higher
- JavaFX SDK (tested with version XX)
- JDBC driver (e.g., SQLite JDBC)
- Database file located at `/data/`

## Notes
- Ensure JavaFX VM options are set if using IntelliJ (e.g., `--module-path` and `--add-modules`).
- For database persistence, make sure the `/data/` directory is writable.
