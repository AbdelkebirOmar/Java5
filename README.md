
# README.md

## Project Title

A comprehensive project to manage games and player participation through well-structured modules and endpoints.

## Table of Contents
- [About](#about)
- [Project Structure](#project-structure)
- [Installation Guide](#installation-guide)
- [Endpoints](#endpoints)
- [Business Logic](#business-logic)
- [Database Structure](#database-structure)
- [Application Workflow](#application-workflow)
- [Player Management System](#player-management-system)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## About
This project allows the management of games and players, enabling CRUD operations for both entities. It provides a REST API with clearly defined endpoints to handle the interaction between the client and the server.

## Project Structure
```
root/
  |-- game_management/
  |   |-- src/main/java/com/helb/game/management/game_management/
  |       |-- controller/
  |       |-- service/
  |       |-- entity/
  |       |-- dto/
  |       |-- repository/
  |-- player_management/
      |-- src/main/java/com/helb/player/management/player_management/
          |-- controller/
          |-- service/
          |-- entity/
          |-- dto/
          |-- repository/
```

## Installation Guide

1. **Prérequis**:
   - **Java 17** ou supérieur
   - **Maven** (pour la gestion des dépendances et la compilation du projet)
   - **Git** (pour cloner le dépôt)
   - **IDE** (comme IntelliJ IDEA ou Eclipse) - optionnel mais recommandé

2. **Clonage du projet**:
   ```bash
   git clone [https://github.com/AbdelkebirOmar/Java5.git]
   ```

3. **Structure du projet**:
   Le projet est divisé en deux modules principaux :
   - **game_management** : Gestion des jeux et des participations.
   - **player_management** : Gestion des joueurs et des relations d'amis.

4. **Compilation et construction**:
   Accédez à chaque répertoire de module (`game_management` et `player_management`) et exécutez :
   ```bash
   mvn clean install
   ```

5. **Exécution de l'application**:
   Pour lancer l'application, exécutez le fichier **main** du module :
   - Pour **game_management** :
     ```bash
     cd game_management
     mvn spring-boot:run
     ```

   - Pour **player_management** :
     ```bash
     cd player_management
     mvn spring-boot:run
     ```

6. **Accès aux endpoints**:
   - Par défaut, l'API sera accessible à :
     - **Game Management** : `http://localhost:8080/games`
     - **Player Management** : `http://localhost:8081/api/players`

7. **Tests**:
   - Pour exécuter les tests unitaires :
     ```bash
     mvn test
     ```

8. **Accès à la base de données (H2 Database)**:
   - L'application utilise une base de données H2 (en mémoire) par défaut. 
   - Vous pouvez accéder à la console H2 à l'URL suivante :
     ```
     http://localhost:8080/h2-console
     ```

## Endpoints

... (The endpoints section from earlier will be here) ...

## Business Logic
This application is designed to manage relationships and interactions between players and games efficiently. It ensures robust data handling and validation through service layers.

## Database Structure
Entities include:
- **Game**: Stores game details.
- **Participation**: Tracks player participation in games.
- **Player**: Contains player information.
- **Friend**: Records friendships between players.

## Application Workflow
1. Clients send HTTP requests to the endpoints.
2. Controllers handle incoming requests and delegate tasks to services.
3. Services perform business logic and interact with repositories for data persistence.

## Player Management System
Enables players to register, update profiles, and interact with other players.

## Features
- Modular design for game and player management.
- RESTful APIs for seamless integration.
- Data persistence using repositories.
- Clean architecture with separate concerns.

## Technologies Used
- **Java**: Core programming language.
- **Spring Boot**: Framework for building the application.
- **Maven**: Build automation tool.
- **H2**: Embedded database for development and testing.

## Contributing
1. Fork the repository.
2. Create a feature branch.
3. Commit changes and open a pull request.

## License
This project is licensed under the MIT License.

## Contact
For inquiries, please contact [Your Name] at [Your Email].
