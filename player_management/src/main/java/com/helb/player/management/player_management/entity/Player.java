package com.helb.player.management.player_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "player") // Table de la base de données
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La valeur de l'id sera générée automatiquement par la base de données
    private Long id;

    @Column(nullable = false, unique = true) // Le username doit être unique et non nul
    private String username;

    @Column(nullable = false) // L'email doit être non nul
    private String email;

    @Column(nullable = false) // Niveau de départ du joueur
    private int level = 0;

    @Column(nullable = false) // Points de départ du joueur
    private int totalPoints = 0;

    private String nickname;

    private String name;

 
}
