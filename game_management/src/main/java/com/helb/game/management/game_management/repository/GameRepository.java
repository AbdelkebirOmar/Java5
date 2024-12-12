package com.helb.game.management.game_management.repository;

import com.helb.game.management.game_management.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}