package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.AbonnementRequestDTO;
import com.openclassrooms.mddapi.dto.AbonnementResponseDTO;
import com.openclassrooms.mddapi.dto.ArticleResponseDTO;
import com.openclassrooms.mddapi.models.AbonnementModel;
import com.openclassrooms.mddapi.models.UserModel;
import com.openclassrooms.mddapi.repositories.AbonnementRepository;
import com.openclassrooms.mddapi.repositories.UserRepository;
import com.openclassrooms.mddapi.services.Interfaces.IAbonnementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AbonnementService implements IAbonnementService {


    @Autowired
    AbonnementRepository abonnementRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public AbonnementResponseDTO subscribeTheme(AbonnementRequestDTO abonnementRequestDTO, String userEmail) {
        UserModel user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email"));
        AbonnementModel abonnementModel = new AbonnementModel(abonnementRequestDTO.getThemeId(),user.getId());
        AbonnementModel abonnementModelSaved =  abonnementRepository.save(abonnementModel);
        return modelMapper.map(abonnementModelSaved, AbonnementResponseDTO.class);
    }

    @Override
    public boolean unsubscribeTheme(Integer id, String userEmail) {
        UserModel user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email"));
        AbonnementModel abonnementModel = abonnementRepository.findByUserIdAndThemeId(user.getId(), id)
                .orElseThrow(() ->
                        new RuntimeException("Subscription not found for user with email: " + userEmail + " and theme ID: " + id));

        abonnementRepository.delete(abonnementModel);
        return true;
    }
}

/*

if (request.getServletPath().contains("/api/auth/register")) {
    	      filterChain.doFilter(request, response);
    	      return;
    	    }
 */