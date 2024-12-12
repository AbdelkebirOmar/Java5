package com.helb.game.management.game_management.controller;

import com.helb.game.management.game_management.dto.GameDTO;
import com.helb.game.management.game_management.entity.Game;
import com.helb.game.management.game_management.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @PostMapping
    public Game createGame(@RequestBody GameDTO gameDTO) {
        return gameService.createGame(gameDTO);
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable Long id) {
        return gameService.getGameById(id);
    }
}
