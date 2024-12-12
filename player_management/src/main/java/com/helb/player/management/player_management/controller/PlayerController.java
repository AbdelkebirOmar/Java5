package com.helb.player.management.player_management.controller;

import com.helb.player.management.player_management.dto.PlayerProfileDTO;
import com.helb.player.management.player_management.entity.Player;
import com.helb.player.management.player_management.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.List;



@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // Ajouter un joueur
    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        return new ResponseEntity<>(playerService.addPlayer(player), HttpStatus.CREATED);
    }

    // Obtenir tous les joueurs
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    // Obtenir un joueur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Optional<Player> player = playerService.getPlayerById(id);
        return player.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Mettre à jour uniquement le score et augmenter le niveau du joueur
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        try {
            // Mettre à jour les stats du joueur : score et niveau
            Player updated = playerService.updatePlayerStats(id, updatedPlayer.getTotalPoints());
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Supprimer un joueur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }

    // Récupérer le profil d'un joueur
    @GetMapping("/{id}/profile")
    public ResponseEntity<PlayerProfileDTO> getPlayerProfile(@PathVariable Long id) {
        try {
            PlayerProfileDTO playerProfile = playerService.getPlayerProfile(id);
            return ResponseEntity.ok(playerProfile);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
