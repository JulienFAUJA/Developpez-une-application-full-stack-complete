package com.openclassrooms.mddapi.services;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import com.openclassrooms.mddapi.dto.*;
import com.openclassrooms.mddapi.models.AbonnementModel;
import com.openclassrooms.mddapi.models.ThemeModel;
import com.openclassrooms.mddapi.repositories.AbonnementRepository;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.models.UserModel;
import com.openclassrooms.mddapi.repositories.UserRepository;
import com.openclassrooms.mddapi.services.Interfaces.IAuthService;

@Service
public class AuthService implements IAuthService{
	
	 @Autowired
	 private UserRepository userRepository;

	@Autowired
	private ThemeRepository themeRepository;

	@Autowired
	private AbonnementRepository abonnementRepository;
	
	 @Autowired
	 private ModelMapper modelMapper;
	
	 private final PasswordEncoder passwordEncoder;
	 private final JWTokenService jwtService;
	 private final AuthenticationManager authenticationManager;

	 public AuthService(PasswordEncoder passwordEncoder, JWTokenService jwtService, AuthenticationManager authenticationManager) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
	 }
    
     public UserProfileResponseDTO me(Principal user){
		 UserLoggedDTO userLoggedDTO = modelMapper.map(this.userRepository.findByEmail(user.getName()), UserLoggedDTO.class);
		 // Récupérer tous les theme_id des abonnements de l'utilisateur
		 List<Integer> subscribedThemeIds = abonnementRepository.findAllByUserId(userLoggedDTO.getId())
				 .stream()
				 .map(AbonnementModel::getThemeId)
				 .collect(Collectors.toList());

		 // Récupérer les thèmes auxquels l'utilisateur est abonné
		 List<ThemeModel> subscribedThemes = themeRepository.findAllByIdIn(subscribedThemeIds);

		 // Mapper les thèmes récupérés à ThemeResponseDTO et définir isSubscribed à true
		 List<ThemeResponseDTO> subscribedThemesDTO = subscribedThemes.stream()
				 .map(theme -> {
					 ThemeResponseDTO themeResponseDTO = modelMapper.map(theme, ThemeResponseDTO.class);
					 themeResponseDTO.setIsSubscribed(true);
					 return themeResponseDTO;
				 })
				 .collect(Collectors.toList());

		 UserProfileResponseDTO userProfile = new UserProfileResponseDTO();
		 userProfile.setUser(userLoggedDTO);
		 userProfile.setSubscribedThemes(subscribedThemesDTO);

		 return userProfile;

     }
    
     public TokenDTO register(UserRegisterDTO request) {
    	UserModel user = new UserModel(request.getEmail(), request.getName(), passwordEncoder.encode(request.getPassword()));
    	String jwt = jwtService.generateToken(request.getEmail());
        // vérifie si existe déjà
        if(userRepository.findByEmail(request.getEmail()).isPresent()) {
	        return null;
        }
        else {
        	user = userRepository.save(user);
        }
        TokenDTO token = new TokenDTO(jwt);
	    return token;
     }

     public TokenDTO authenticating(UserLoginDTO request) {
    	    	Authentication authentication;
    	    try {
    	    	UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                );
    	    	authentication = authenticationManager.authenticate(authToken);
    	    }
    	    catch (AuthenticationException e) {
    	        return null;
    	    }
    	    SecurityContextHolder.getContext().setAuthentication(authentication);
    	    UserModel user = (UserModel)authentication.getPrincipal();
    	    String email = user.getUsername();
    	    String jwt = jwtService.generateToken(email);
    	    TokenDTO token = new TokenDTO(jwt);
    	    return token;
     }
}
