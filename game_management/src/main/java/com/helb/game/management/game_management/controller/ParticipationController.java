package com.helb.game.management.game_management.controller;
import com.helb.game.management.game_management.dto.ParticipationDTO;
import com.helb.game.management.game_management.entity.Participation;
import com.helb.game.management.game_management.service.ParticipationService;
import com.helb.game.management.game_management.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participations")
public class ParticipationController {

    private final ParticipationService participationService;
    @Autowired
    private PlayerService playerService;  // Suppose que tu as un service pour vérifier l'existence du joueur

    public ParticipationController(ParticipationService participationService) {
        this.participationService = participationService;
    }

    @PostMapping
    public Participation createParticipation(@RequestBody ParticipationDTO participationDTO) {
        return participationService.createParticipation(participationDTO);
    }

    @GetMapping("/{id}")
    public Participation getParticipationById(@PathVariable Long id) {
        return participationService.getParticipationById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteParticipation(@PathVariable Long id) {
        participationService.deleteParticipation(id);
    }
        @PostMapping("/check-player/{playerId}")
    public ResponseEntity<String> checkIfPlayerExists(@PathVariable Long playerId) {
        boolean playerExists = playerService.checkIfPlayerExists(playerId);  // Vérification via ton service
        
        if (playerExists) {
            return ResponseEntity.ok("Player exists");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player does not exist");
        }
    }
}