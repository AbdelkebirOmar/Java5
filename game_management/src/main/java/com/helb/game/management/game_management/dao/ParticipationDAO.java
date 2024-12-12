package com.helb.game.management.game_management.dao;

import com.helb.game.management.game_management.entity.Participation;
import com.helb.game.management.game_management.repository.*;

import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class ParticipationDAO {

    private final ParticipationRepository participationRepository;

    public ParticipationDAO(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    public Participation save(Participation participation) {
        return participationRepository.save(participation);
    }

    public Optional<Participation> findById(Long id) {
        return participationRepository.findById(id);
    }

    public void deleteById(Long id) {
        participationRepository.deleteById(id);
    }

    public boolean existsByGameIdAndPlayerId(Long gameId, Long playerId) {
        return participationRepository.existsByGameIdAndPlayerId(gameId, playerId);
    }

    
}