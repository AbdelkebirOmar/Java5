package com.helb.game.management.game_management.dao;



import com.helb.game.management.game_management.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDAO extends JpaRepository<Game, Long> {
    
}
