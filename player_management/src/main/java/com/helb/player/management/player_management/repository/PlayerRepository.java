package com.helb.player.management.player_management.repository;

import com.helb.player.management.player_management.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    
}
