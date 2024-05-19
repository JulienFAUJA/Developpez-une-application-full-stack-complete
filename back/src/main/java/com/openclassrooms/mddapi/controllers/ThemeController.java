package com.openclassrooms.mddapi.controllers;


import com.openclassrooms.mddapi.dto.ThemeRequestDTO;
import com.openclassrooms.mddapi.dto.ThemeResponseDTO;
import com.openclassrooms.mddapi.services.Interfaces.IThemeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/theme")
public class ThemeController {

    @Autowired
    private IThemeService themeService;


    @PostMapping
    @ResponseBody
    public ResponseEntity<?> SubscribeTheme(@Valid @RequestBody ThemeRequestDTO themeRequestDTO) {
        ThemeResponseDTO themeResponseDTO = themeService.subscribeTheme(themeRequestDTO);
        //if (themeResponseDTO.getMessage() == "Bad request: ") {
        if (themeResponseDTO==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(themeResponseDTO);
        }
        //else if (themeResponseDTO.getMessage() == "Unauthorized: ") {
        else if (themeResponseDTO==null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(themeResponseDTO);
        }
        else {
            return ResponseEntity.ok(themeResponseDTO);
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<?> getThemeById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(themeService.getThemeById(id));
    }

    @GetMapping("{user_id}")
    public ResponseEntity<?> getAllThemesByUserId(@PathVariable("user_id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(themeService.getAllThemesByUserId(id));
    }

}
