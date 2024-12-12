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

    // Mettre à jour un joueur
    @Override
    public Player updatePlayer(Long id, Player updatedPlayer) {
        return playerRepository.findById(id)
                .map(player -> {
                    player.setName(updatedPlayer.getName());
                    player.setNickname(updatedPlayer.getNickname());
                    player.setEmail(updatedPlayer.getEmail());
                    player.setLevel(updatedPlayer.getLevel());
                    player.setTotalPoints(updatedPlayer.getTotalPoints());
                    return playerRepository.save(player);  // Sauvegarder les modifications
                })
                .orElseThrow(() -> new RuntimeException("Player not found"));
    }

    // Supprimer un joueur
    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
