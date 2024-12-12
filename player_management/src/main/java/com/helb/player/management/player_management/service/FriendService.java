package com.helb.player.management.player_management.service;

import com.helb.player.management.player_management.entity.Friend;
import com.helb.player.management.player_management.repository.FriendRepository;
import com.helb.player.management.player_management.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private FriendRepository friendRepository;

    // Ajouter un ami
    public void addFriend(Long playerId, Long friendId) {
        // Vérifier si les deux joueurs existent
        if (playerRepository.existsById(playerId) && playerRepository.existsById(friendId)) {
            // Ajouter une relation d'amitié entre les joueurs
            Friend friend = new Friend(playerId, friendId);
            friendRepository.save(friend);
        } else {
            throw new RuntimeException("Les joueurs doivent exister pour être amis.");
        }
    }
}
