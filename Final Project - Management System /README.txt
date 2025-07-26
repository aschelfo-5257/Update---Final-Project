Final Project – [Aaron Schelfo]
JavaFX Application with SQL

How to Run:
1. Open in [IDE Name: IntelliJ, Eclipse, etc.]
2. Add JavaFX and JDBC libraries to the classpath
3. Run Main.java

Description:
This application allows users to [describe app function briefly]

UML Diagram:
See UML_Diagram.png

Notes:
- Requires Java 11+
- Database file located in /data/

Block Game Management System:

1. The game operates on a continuous loop that updates the game state and renders graphics.
2. The game world is typically represented as a 3D array or similar data structure storing information about each block.
3. A Block class defines properties of each block type (e.g., texture, solidity).
4. Graphics libraries like LWJGL (Lightweight Java Game Library) or JOGL are commonly used for 3D rendering in Java. This involves setting up a camera, drawing cubes (representing blocks), and applying textures.
5. Player interaction (movement, placing/breaking blocks) is handled by listening for keyboard and mouse input.
6. Basic physics for player movement and block interaction may involve collision detection with solid blocks.
7. This includes inventory management, crafting systems, and other game-specific mechanics.
