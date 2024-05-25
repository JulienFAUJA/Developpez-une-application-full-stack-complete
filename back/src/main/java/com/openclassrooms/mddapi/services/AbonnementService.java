package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.AbonnementRequestDTO;
import com.openclassrooms.mddapi.dto.AbonnementResponseDTO;
import com.openclassrooms.mddapi.dto.ThemeResponseDTO;
import com.openclassrooms.mddapi.models.AbonnementModel;
import com.openclassrooms.mddapi.models.ThemeModel;
import com.openclassrooms.mddapi.models.UserModel;
import com.openclassrooms.mddapi.repositories.AbonnementRepository;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import com.openclassrooms.mddapi.repositories.UserRepository;
import com.openclassrooms.mddapi.services.Interfaces.IAbonnementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AbonnementService implements IAbonnementService {


    @Autowired
    AbonnementRepository abonnementRepository;

    @Autowired
    ThemeRepository themeRepository;

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
    public String toggleSubscription(Integer id, String userEmail) {
        UserModel user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email"));
        Optional<AbonnementModel> abonnementModel = abonnementRepository.findByUserIdAndThemeId(user.getId(), id);
        Optional<ThemeModel> themeModel = themeRepository.findById(id);
        String responseSubjet = "ce thème";
        String responseVerb = "";


        if(themeModel.isPresent()){
            ThemeResponseDTO themeResponseDTO  = modelMapper.map(themeModel, ThemeResponseDTO.class);
            responseSubjet = themeResponseDTO.getTheme();
        }

        if(abonnementModel.isPresent()){
            abonnementRepository.delete(abonnementModel.get());
            responseVerb = "Désabonné de ";
            return responseVerb+responseSubjet;
        }
        else{
            AbonnementModel newSubscription  = new AbonnementModel(id, user.getId());
            abonnementRepository.save(newSubscription );
            responseVerb = "Abonné à ";
            return responseVerb+responseSubjet;
        }
    }
}

/*

if (request.getServletPath().contains("/api/auth/register")) {
    	      filterChain.doFilter(request, response);
    	      return;
    	    }
 */
