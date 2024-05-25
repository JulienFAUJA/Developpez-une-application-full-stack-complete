package com.openclassrooms.mddapi.controllers;


import com.openclassrooms.mddapi.dto.ThemeRequestDTO;
import com.openclassrooms.mddapi.dto.ThemeResponseDTO;
import com.openclassrooms.mddapi.services.Interfaces.IThemeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/theme")
public class ThemeController {

    @Autowired
    private IThemeService themeService;


    @GetMapping("{id}")
    public ResponseEntity<?> getThemeById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(themeService.getThemeById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllThemes(Authentication authentication) {
        String userEmail = authentication.getName();
        return ResponseEntity.status(HttpStatus.OK).body(themeService.getAllThemes(userEmail));
    }

    @GetMapping("/user")
    public ResponseEntity<?> getAllThemesForUser(Authentication authentication) {
        String userEmail = authentication.getName();
        return ResponseEntity.status(HttpStatus.OK).body(themeService.getAllThemesForUser(userEmail));
    }

}
