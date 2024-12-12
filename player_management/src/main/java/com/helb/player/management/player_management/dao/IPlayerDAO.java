package com.helb.player.management.player_management.dao;

import com.helb.player.management.player_management.entity.Player;
import com.helb.player.management.player_management.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface IPlayerDAO {
       // Ajouter un joueur
       Player addPlayer(Player player);

       // Obtenir tous les joueurs
       List<Player> getAllPlayers();
   
       // Obtenir un joueur par son ID
       Optional<Player> getPlayerById(Long id);
   
       // Mettre à jour un joueur
       Player updatePlayer(Long id, Player updatedPlayer);
   
       // Supprimer un joueur
       void deletePlayer(Long id);
}
