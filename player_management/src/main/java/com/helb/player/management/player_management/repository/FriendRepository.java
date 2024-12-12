package com.helb.player.management.player_management.repository;

import com.helb.player.management.player_management.entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FriendRepository extends JpaRepository<Friend, Long> {

    // Requête personnalisée pour récupérer la liste des amis d'un joueur
    List<Friend> findByPlayerId(Long playerId);
}
