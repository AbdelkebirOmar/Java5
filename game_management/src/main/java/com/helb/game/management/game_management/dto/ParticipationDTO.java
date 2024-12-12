package com.helb.game.management.game_management.dto;
import lombok.Data;
@Data
public class ParticipationDTO {
    private Long id;
    private Long gameId;
    private Long playerId;
    private int score;
    private boolean Win;  
}