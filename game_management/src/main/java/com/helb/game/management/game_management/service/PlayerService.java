package com.helb.game.management.game_management.service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
@Service
public class PlayerService {

    private final WebClient webClient;

    public PlayerService(WebClient webClient) {
        this.webClient = webClient;
    }

    public boolean checkIfPlayerExists(Long playerId) {
        try {
            // Appelle l'API pour vérifier si le joueur existe
            webClient.get()
                     .uri("/players/{id}", playerId)
                     .retrieve()
                     .toBodilessEntity()
                     .block();  // Attendre la réponse de manière synchrone
            return true;  // Si le joueur existe, renvoie true
        } catch (WebClientResponseException.NotFound e) {
            // Si l'ID du joueur n'est pas trouvé
            return false;
        }
    }
}