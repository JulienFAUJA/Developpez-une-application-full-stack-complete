package com.openclassrooms.mddapi.services.Interfaces;

import com.openclassrooms.mddapi.dto.ThemeRequestDTO;
import com.openclassrooms.mddapi.dto.ThemeResponseDTO;

public interface IThemeService {
    ThemeResponseDTO subscribeTheme(ThemeRequestDTO themeRequestDTO);

    ThemeResponseDTO getThemeById(Integer id);

    ThemeResponseDTO getAllThemesByUserId(Integer id);
}
