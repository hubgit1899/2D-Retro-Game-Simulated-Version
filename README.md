# 2D Retro Adventure Game

## Description

This is a 2D retro-style adventure game developed in Java Swing. Explore different maps, interact with NPCs and objects, battle monsters, and uncover the secrets of the game world.

## Features

- Classic 2D top-down perspective
- Player movement and interaction
- Non-player characters (NPCs) and monsters
- Collectable objects and interactive tiles
- Collision detection
- User interface (UI) for game information and menus
- Sound effects and background music
- Multiple game states (title screen, gameplay, pause, dialogue, etc.)
- Basic save and load functionality
- Environmental effects and lighting
- Pathfinding for AI (based on directory name)

## Technologies Used

- Java
- Swing

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your system.

### Running the game

1.  Clone or download the repository.
2.  Navigate to the project directory in your terminal.
3.  Compile the Java files. From the root directory, you can use a command like:
    ```bash
    javac src/Main/Main.java
    ```
    _(Note: You may need to compile other `.java` files in the `src` directory depending on your environment and how the project is structured. An IDE like Eclipse or IntelliJ IDEA would handle this automatically.)_
4.  Run the main class:
    ```bash
    java src/Main/Main.java
    ```
    _(Note: If running from the command line, ensure your classpath is set correctly to include all compiled classes.)_

## Project Structure

- `src/`: Contains the main source code for the game logic, entities, tiles, UI, etc.
- `res/`: Contains game resources such as images, sounds, fonts, and maps.
- `lib/`: (If applicable) Contains any external libraries used by the project.
- `bin/`: (If applicable) Contains compiled class files or executables.
- `save.dat`: File used for saving and loading game progress.

---

Feel free to contribute or report issues!
