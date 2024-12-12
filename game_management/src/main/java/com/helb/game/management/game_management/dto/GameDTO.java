package com.helb.game.management.game_management.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GameDTO {
    private Long id;
    private LocalDate date;
    private String gameType;
    private Integer maxScore;
    private Long hostId;

}