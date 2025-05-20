# 2D Retro Game Simulated Version 🎮

## Overview

This project is a 2D retro-style game simulation built in Java. It features a player character, NPCs, monsters, interactive objects, and a dynamic game environment. The game uses a tile-based system for rendering the world and includes various game states such as title, play, pause, dialogue, and more.

## Project Structure

- **src/**: Contains the main source code for the game.
  - **Main/**: Core game logic and entry point.
  - **ai/**: AI-related files, including pathfinding and neural network implementations.
  - **data/**: Data management and persistence files.
  - **entity/**: Player, NPC, and other entity logic.
  - **environment/**: Game world and environment management.
  - **monster/**: Enemy or monster logic.
  - **object/**: In-game objects and their logic.
  - **tile/**: Game map and tile management.
  - **tile_interactive/**: Interactive tile logic.
- **res/**: Contains resources such as images, audio, and fonts.
  - **font/**: Custom fonts used in the game.
  - **maps/**: Map files for the game world.
  - **monster/**: Monster assets.
  - **npc/**: NPC assets.
  - **objects/**: Object assets.
  - **player/**: Player character assets.
  - **projectile/**: Projectile assets.
  - **sound/**: Audio assets.
  - **tiles/**: Tile assets.
  - **tiles_interactive/**: Interactive tile assets.
- **bin/**: Contains executables or scripts.
- **lib/**: Libraries or modules used in the project.

## Getting Started

1. Ensure you have Java installed on your system.
2. Clone the repository to your local machine.
3. Navigate to the project directory and run the main class to start the game.

## Features

- **Player Character**: Control a character with various actions like movement, attacking, and interacting with objects.
- **NPCs and Monsters**: Interact with non-player characters and battle monsters.
- **Interactive Objects**: Collect items, open chests, and use various objects throughout the game.
- **Dynamic Environment**: Experience a changing game environment with day and night cycles.
- **AI Pathfinding**: Monsters and NPCs use AI to navigate the game world.

## AI Mode

The game includes an AI mode that utilizes Deep Q-Network (DQN) for decision-making. The AI agent can interact with the game environment, making decisions based on the current state of the game. The AI functionality is implemented in the following files:

- **DQNagent.java**: Implements the Deep Q-Network agent that learns to make decisions based on rewards and penalties.
- **GameEnvironment.java**: Manages the game environment for the AI, including player position, monsters, rewards, and goals.

### How to Use AI Mode

1. Ensure the AI mode is enabled in the game settings.
2. The AI agent will automatically take control of the player character, making decisions based on its learned behavior.
3. Observe the AI's performance and adjust parameters as needed for optimal gameplay.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
