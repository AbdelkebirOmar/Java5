package com.helb.player.management.player_management.service;

import com.helb.player.management.player_management.dao.IPlayerDAO;
import com.helb.player.management.player_management.entity.Friend;
import com.helb.player.management.player_management.entity.Player;
import com.helb.player.management.player_management.dto.PlayerProfileDTO;
import com.helb.player.management.player_management.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private IPlayerDAO playerDAO;

    @Autowired
    private FriendRepository friendRepository;

    // Ajouter un joueur
    public Player addPlayer(Player player) {
        return playerDAO.addPlayer(player);
    }

    // Obtenir tous les joueurs
    public List<Player> getAllPlayers() {
        return playerDAO.getAllPlayers();
    }

    // Obtenir un joueur par son ID
    public Optional<Player> getPlayerById(Long id) {
        return playerDAO.getPlayerById(id);
    }

    // Mettre à jour le score et augmenter le niveau
    public Player updatePlayerStats(Long playerId, int scoreToAdd) {
        // Récupérer le joueur par son ID
        Player player = playerDAO.getPlayerById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found with ID: " + playerId));

        // Ajouter le score
        player.setTotalPoints(player.getTotalPoints() + scoreToAdd);

        // Incrémenter le niveau
        player.setLevel(player.getLevel() + 1);

        // Enregistrer les modifications
        return playerDAO.updatePlayer(playerId, player);
    }
    // Supprimer un joueur
    public void deletePlayer(Long id) {
        playerDAO.deletePlayer(id);
    }

    // Récupérer le profil du joueur avec ses amis
    public PlayerProfileDTO getPlayerProfile(Long playerId) {
        // Récupérer le joueur
        Optional<Player> playerOpt = playerDAO.getPlayerById(playerId);
        if (playerOpt.isEmpty()) {
            throw new RuntimeException("Player not found");
        }

        Player player = playerOpt.get();

        // Récupérer les amis du joueur
        List<Friend> friends = friendRepository.findByPlayerId(playerId);
        List<Long> friendIds = friends.stream()
                .map(Friend::getFriendId)
                .collect(Collectors.toList());

        // Créer un DTO pour retourner les informations du joueur et de ses amis
        PlayerProfileDTO playerProfile = new PlayerProfileDTO();
        playerProfile.setPlayerId(player.getId());
        playerProfile.setUsername(player.getUsername());
        playerProfile.setEmail(player.getEmail());
        playerProfile.setLevel(player.getLevel());
        playerProfile.setTotalPoints(player.getTotalPoints());
        playerProfile.setFriendIds(friendIds);

        return playerProfile;
    }
}
