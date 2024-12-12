package com.helb.game.management.game_management.repository;

import com.helb.game.management.game_management.entity.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {

    // Méthode pour vérifier si une participation existe pour un jeu et un joueur donnés
    boolean existsByGameIdAndPlayerId(Long gameId, Long playerId);

    // Rechercher une participation par son ID (automatiquement fourni par JpaRepository)
    Optional<Participation> findById(Long id);
    
    // Rechercher toutes les participations d'un joueur spécifique (par exemple, toutes les participations d'un joueur à un jeu spécifique)
    List<Participation> findByPlayerId(Long playerId);
    
    // Rechercher toutes les participations d'un jeu spécifique (par exemple, tous les participants d'un jeu)
    List<Participation> findByGameId(Long gameId);

    // Si tu as besoin d'autres méthodes personnalisées, tu peux les ajouter ici
}