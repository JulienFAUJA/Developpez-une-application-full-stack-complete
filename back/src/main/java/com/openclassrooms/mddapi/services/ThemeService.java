package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.ThemeRequestDTO;
import com.openclassrooms.mddapi.dto.ThemeResponseDTO;
import com.openclassrooms.mddapi.services.Interfaces.IThemeService;
import org.springframework.stereotype.Service;

@Service
public class ThemeService implements IThemeService {
    @Override
    public ThemeResponseDTO subscribeTheme(ThemeRequestDTO themeRequestDTO) {
        return null;
    }

    @Override
    public ThemeResponseDTO unsubscribeTheme(ThemeRequestDTO themeRequestDTO) {
        return null;
    }

    @Override
    public ThemeResponseDTO getThemeById(Integer id) {
        return null;
    }

    @Override
    public ThemeResponseDTO getAllThemesForUser() {
        return null;
    }
}
