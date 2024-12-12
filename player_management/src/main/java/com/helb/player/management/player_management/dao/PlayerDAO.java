package com.helb.player.management.player_management.dao;

import com.helb.player.management.player_management.entity.Player;
import com.helb.player.management.player_management.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository  // Annotation pour indiquer que cette classe est un DAO qui interagit avec la base de données
public class PlayerDAO implements IPlayerDAO {

    @Autowired
    private PlayerRepository playerRepository;  // Injection du PlayerRepository pour l'accès aux données

    // Ajouter un joueur
    @Override
    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    // Obtenir tous les joueurs
    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    // Obtenir un joueur par son ID
    @Override
    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public Player updatePlayer(Long id, Player updatedPlayer) {
        // Trouver le joueur existant
        Player existingPlayer = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        // Mettre à jour seulement les champs nécessaires : le score et le niveau
        existingPlayer.setTotalPoints(updatedPlayer.getTotalPoints());
        existingPlayer.setLevel(updatedPlayer.getLevel());

        // Sauvegarder les changements
        return playerRepository.save(existingPlayer);
    }
    // Supprimer un joueur
    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
