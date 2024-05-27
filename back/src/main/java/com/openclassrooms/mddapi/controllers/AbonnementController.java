package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.services.Interfaces.IAbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * The type Abonnement controller.
 */
@RestController
@RequestMapping("/api/abonnement")
public class AbonnementController {

    @Autowired
    private IAbonnementService abonnementService;




    /**
     * Toggle subscription response entity.
     *
     * @param id             the id
     * @param authentication the authentication
     * @return the response entity
     */
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
