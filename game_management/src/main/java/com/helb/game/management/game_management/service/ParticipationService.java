package com.helb.game.management.game_management.service;

import com.helb.game.management.game_management.dao.ParticipationDAO;
import com.helb.game.management.game_management.dto.ParticipationDTO;
import com.helb.game.management.game_management.entity.Participation;
import org.springframework.stereotype.Service;

@Service
public class ParticipationService {

    private final ParticipationDAO participationDAO;
    private final PlayerService playerService;  // Injection du service PlayerService
    private final GameService gameService;

    public ParticipationService(ParticipationDAO participationDAO, PlayerService playerService, GameService gameService) {
        this.participationDAO = participationDAO;
        this.playerService = playerService;
        this.gameService = gameService;
    }

    public Participation createParticipation(ParticipationDTO participationDTO) {
        // Vérifier si le joueur existe
        if (!playerService.checkIfPlayerExists(participationDTO.getPlayerId())) {
            throw new RuntimeException("Player with ID " + participationDTO.getPlayerId() + " does not exist");
        }
    
        // Vérifier si le jeu existe
        if (!gameService.checkIfGameExists(participationDTO.getGameId())) {
            throw new RuntimeException("Game with ID " + participationDTO.getGameId() + " does not exist");
        }
    
        // Créer la participation si le joueur et le jeu existent
        Participation participation = new Participation();
        playerService.addPointsToPlayer(participationDTO.getPlayerId(), participationDTO.getScore());
        participation.setGameId(participationDTO.getGameId());
        participation.setPlayerId(participationDTO.getPlayerId());
        participation.setScore(participationDTO.getScore());
        participation.setWin(participationDTO.isWin());
    
        return participationDAO.save(participation);
    }
    

    public Participation getParticipationById(Long id) {
        return participationDAO.findById(id).orElseThrow(() -> new RuntimeException("Participation not found"));
    }

    public void deleteParticipation(Long id) {
        participationDAO.deleteById(id);
    }
}