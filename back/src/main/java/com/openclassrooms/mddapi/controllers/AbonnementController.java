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
        //if (themeResponseDTO.getMessage() == "Bad request: ") {
        if (abonnementResponseDTO==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(abonnementResponseDTO);
        }
        //else if (themeResponseDTO.getMessage() == "Unauthorized: ") {
        else if (abonnementResponseDTO==null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(abonnementResponseDTO);
        }
        else {
            return ResponseEntity.ok(abonnementResponseDTO);
        }

    }

    @DeleteMapping("/unsubscribe/{id}")
    @ResponseBody
    public ResponseEntity<?> UnsubscribeTheme(@PathVariable("id") Integer id, Authentication authentication) {
        String userEmail = authentication.getName();
        boolean status = abonnementService.unsubscribeTheme(id, userEmail);
        if (status==false) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request: ");
        }
        /*
        else if (status==null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: ");
        }
        */

        else {
            return ResponseEntity.ok("désabonné avec succès...");
        }

    }
}
