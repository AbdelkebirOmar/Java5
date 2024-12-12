package com.helb.player.management.player_management.controller;

import com.helb.player.management.player_management.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friends")
public class FriendController {

    @Autowired
    private FriendService friendService;

    // Ajouter un ami
    @PostMapping("/add")
    public String addFriend(@RequestParam Long playerId, @RequestParam Long friendId) {
        friendService.addFriend(playerId, friendId);
        return "Ami ajouté avec succès!";
    }
}
