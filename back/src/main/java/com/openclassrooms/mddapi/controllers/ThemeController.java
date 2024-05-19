package com.openclassrooms.mddapi.controllers;


import com.openclassrooms.mddapi.services.Interfaces.IArticleService;
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
    public ResponseEntity<?> SubscribeTheme(@Valid @RequestBody ArticleRequestDTO articleRequestDTO) {
        ArticleResponseDTO articleResponseDTO = themeService.subscribeTheme(articleRequestDTO);
        if (articleResponseDTO.getMessage() == "Bad request: ") {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(articleResponseDTO);
        }
        else if (articleResponseDTO.getMessage() == "Unauthorized: ") {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(articleResponseDTO);
        }
        else {
            return ResponseEntity.ok(articleResponseDTO);
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<?> getThemeById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(themeService.getThemeById(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAllThemesByUserId(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(themeService.getAllThemesByUserId(id));
    }

}
