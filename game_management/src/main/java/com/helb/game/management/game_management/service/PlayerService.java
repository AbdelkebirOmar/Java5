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
                     .uri("/api/players/{id}", playerId)
                     .retrieve()
                     .toBodilessEntity()
                     .block();  // Attendre la réponse de manière synchrone
            return true;  // Si le joueur existe, renvoie true
        } catch (WebClientResponseException.NotFound e) {
            // Si l'ID du joueur n'est pas trouvé
            return false;
        }
    }
    public void addPointsToPlayer(Long playerId, int pointsToAdd) {
        String url = "/api/players/" + playerId;
        // Créez un objet JSON contenant "totalPoints" et la valeur des points à ajouter
        String jsonBody = "{\"totalPoints\": " + pointsToAdd + "}";
    
        webClient.put()
                .uri(url)
                .header("Content-Type", "application/json")  // Assurez-vous que le type de contenu est JSON
                .bodyValue(jsonBody)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
    
}