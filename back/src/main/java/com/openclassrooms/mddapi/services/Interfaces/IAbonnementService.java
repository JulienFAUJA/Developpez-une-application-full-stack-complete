package com.openclassrooms.mddapi.services.Interfaces;

import com.openclassrooms.mddapi.dto.AbonnementRequestDTO;
import com.openclassrooms.mddapi.dto.AbonnementResponseDTO;

public interface IAbonnementService {
    AbonnementResponseDTO subscribeTheme(AbonnementRequestDTO abonnementRequestDTO, String userEmail);

    String toggleSubscription(Integer id, String userEmail);

}




