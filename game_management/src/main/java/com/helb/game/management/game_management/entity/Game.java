package com.helb.game.management.game_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String gameType;

    private Integer maxScore;

    private Long hostId;

    public Game() {}

    public Game(LocalDate date, String gameType, Integer maxScore, Long hostId) {
        this.date = date;
        this.gameType = gameType;
        this.maxScore = maxScore;
        this.hostId = hostId;
    }
}