package com.helb.game.management.game_management.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
@Configuration
public class WebClientConfig {

    @Value("${player.manager.api.url}")
    private String playerManagerApiUrl;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(playerManagerApiUrl)
                .build();
    }
}