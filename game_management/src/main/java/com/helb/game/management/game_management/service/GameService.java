package com.helb.game.management.game_management.service;

import com.helb.game.management.game_management.dto.*;
import com.helb.game.management.game_management.dao.*;
import com.helb.game.management.game_management.entity.Game;
import com.helb.game.management.game_management.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GameService {

    @Autowired
    private GameDAO gameDAO;

    // Create a new game entry
    public Game createGame(GameDTO gameDTO) {
        // Convert GameDTO to Game entity
        Game game = new Game();
        game.setDate(gameDTO.getDate());
        game.setGameType(gameDTO.getGameType());
        game.setHostId(gameDTO.getHostId());
        game.setMaxScore(gameDTO.getMaxScore());

        return gameDAO.save(game); // Save the game in the database
    }

    // Get a game by ID
    public Game getGameById(Long id) {
        Optional<Game> gameOptional = gameDAO.findById(id);
        if (gameOptional.isPresent()) {
            return gameOptional.get();
        } else{
            return null;
        }
    }

    // Optional: Update game (if needed)
    public Game updateGame(Long id, GameDTO gameDTO) {
        Optional<Game> gameOptional = gameDAO.findById(id);
        if (gameOptional.isPresent()) {
            Game game = gameOptional.get();
            game.setDate(gameDTO.getDate());
            game.setGameType(gameDTO.getGameType());
            game.setHostId(gameDTO.getHostId());

            return gameDAO.save(game);
        } else {
            return null;
            }
    }
    public List<Game> getAllGames() {
        return gameDAO.findAll();
    }
}