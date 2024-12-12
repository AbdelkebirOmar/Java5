package com.helb.player.management.player_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Friend")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long playerId;  // Identifiant du joueur

    @Column(nullable = false)
    private Long friendId;  // Identifiant de l'ami du joueur

    // Constructeur par défaut
    public Friend() {}

    // Constructeur avec paramètres
    public Friend(Long playerId, Long friendId) {
        this.playerId = playerId;
        this.friendId = friendId;
    }
}
