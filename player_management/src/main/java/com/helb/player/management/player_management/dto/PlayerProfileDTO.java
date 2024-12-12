package com.helb.player.management.player_management.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlayerProfileDTO {
    private Long playerId;
    private String username;
    private String email;
    private int level;
    private int totalPoints;
    private List<Long> friendIds; // Liste des IDs des amis du joueur
}
