package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.AbonnementRequestDTO;
import com.openclassrooms.mddapi.dto.AbonnementResponseDTO;
import com.openclassrooms.mddapi.services.Interfaces.IAbonnementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/abonnement")
public class AbonnementController {

    @Autowired
    private IAbonnementService abonnementService;


    @PostMapping("/subscribe")
    @ResponseBody
    public ResponseEntity<?> SubscribeTheme(@Valid @RequestBody AbonnementRequestDTO abonnementRequestDTO, Authentication authentication) {
        String userEmail = authentication.getName();
        AbonnementResponseDTO abonnementResponseDTO = abonnementService.subscribeTheme(abonnementRequestDTO,userEmail);
        if (abonnementResponseDTO==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(abonnementResponseDTO);
        }

        else {
            return ResponseEntity.ok(abonnementResponseDTO);
        }

    }

    @GetMapping("/subscription/{id}")
    @ResponseBody
    public ResponseEntity<?> toggleSubscription(@PathVariable("id") Integer id, Authentication authentication) {
        String userEmail = authentication.getName();

        String response = abonnementService.toggleSubscription(id, userEmail);
        if (response=="") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request: ");
        }

        else {
            return ResponseEntity.ok(response);
        }

    }
}
