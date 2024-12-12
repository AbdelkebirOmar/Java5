
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

## Endpoints

### **Game Endpoints**

#### **Create a new game**
- **URL**: `/games`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "date": "2024-12-12",
    "gameType": "classic",
    "maxScore": 100,
    "hostId": 1
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "date": "2024-12-12",
    "gameType": "classic",
    "maxScore": 100,
    "hostId": 1
  }
  ```

---

#### **Get all games**
- **URL**: `/games`
- **Method**: `GET`
- **Response**:
  ```json
  [
    {
      "id": 1,
      "date": "2024-12-12",
      "gameType": "classic",
      "maxScore": 100,
      "hostId": 1
    },
    {
      "id": 2,
      "date": "2024-12-15",
      "gameType": "rapid",
      "maxScore": 150,
      "hostId": 2
    }
  ]
  ```

---

#### **Get a game by ID**
- **URL**: `/games/{id}`
- **Method**: `GET`
- **Response**:
  ```json
  {
    "id": 1,
    "date": "2024-12-12",
    "gameType": "classic",
    "maxScore": 100,
    "hostId": 1
  }
  ```

---

### **Participation Endpoints**

#### **Create a new participation**
- **URL**: `/participations`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "gameId": 1,
    "playerId": 1,
    "score": 150,
    "win": true
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "gameId": 1,
    "playerId": 1,
    "score": 150,
    "win": true
  }
  ```

---

#### **Get participation by ID**
- **URL**: `/participations/{id}`
- **Method**: `GET`
- **Response**:
  ```json
  {
    "id": 1,
    "gameId": 1,
    "playerId": 1,
    "score": 150,
    "win": true
  }
  ```

---

#### **Delete participation by ID**
- **URL**: `/participations/{id}`
- **Method**: `DELETE`
- **Response**: 
  ```
  204 No Content
  ```

---

#### **Check if a player exists**
- **URL**: `/participations/check-player/{playerId}`
- **Method**: `POST`
- **Response**:
  ```json
  "Player exists"
  ```
  **OR**
  ```json
  "Player does not exist"
  ```

---

### **Player Endpoints**

#### **Create a new player**
- **URL**: `/api/players`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "username": "player1",
    "email": "player1@example.com",
    "nickname": "player1_nick",
    "name": "John Doe"
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "username": "player1",
    "email": "player1@example.com",
    "nickname": "player1_nick",
    "name": "John Doe"
  }
  ```

---

#### **Get all players**
- **URL**: `/api/players`
- **Method**: `GET`
- **Response**:
  ```json
  [
    {
      "id": 1,
      "username": "player1",
      "email": "player1@example.com",
      "nickname": "player1_nick",
      "name": "John Doe",
      "level": 2,
      "totalPoints": 300
    },
    {
      "id": 2,
      "username": "player2",
      "email": "player2@example.com",
      "nickname": "player2_nick",
      "name": "Jane Smith",
      "level": 5,
      "totalPoints": 500
    }
  ]
  ```



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
