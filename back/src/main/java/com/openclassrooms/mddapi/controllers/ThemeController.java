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

/**
 * The type Theme controller.
 */
@RestController
@RequestMapping("/api/theme")
public class ThemeController {

    @Autowired
    private IThemeService themeService;


    /**
     * Gets theme by id.
     *
     * @param id the id
     * @return the theme by id
     */
    @GetMapping("{id}")
    public ResponseEntity<?> getThemeById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(themeService.getThemeById(id));
    }

    /**
     * Gets all themes.
     *
     * @param authentication the authentication
     * @return the all themes
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllThemes(Authentication authentication) {
        String userEmail = authentication.getName();
        return ResponseEntity.status(HttpStatus.OK).body(themeService.getAllThemes(userEmail));
    }

    /**
     * Gets all themes for user.
     *
     * @param authentication the authentication
     * @return the all themes for user
     */
    @GetMapping("/user")
    public ResponseEntity<?> getAllThemesForUser(Authentication authentication) {
        String userEmail = authentication.getName();
        return ResponseEntity.status(HttpStatus.OK).body(themeService.getAllThemesForUser(userEmail));
    }

}
