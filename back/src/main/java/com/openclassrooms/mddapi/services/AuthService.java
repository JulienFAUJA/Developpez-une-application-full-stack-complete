package com.openclassrooms.mddapi.services;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
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

import javax.security.auth.login.LoginException;

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
		 System.out.println(request.toString());
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

     public String authenticating(UserLoginDTO request) {

		/*
		 List<UserModel> users = (List<UserModel>) userRepository.findAll();
		 for (UserModel user : users) {
			 user.setPassword(passwordEncoder.encode("F1x3m61@"));
			 userRepository.save(user);
		 }
			System.out.println("OK");

		 //*/

    	    try {
				System.out.println("user:"+request.toString());
				Optional<UserModel> userOptional = userRepository.findByEmail(request.getEmail());

				if (userOptional.isPresent()) {

					UserModel user = userOptional.get();

					if  (passwordEncoder.matches(request.getPassword(), user.getPassword())) {

						return jwtService.generateToken(user.getEmail());
					} else {
						System.out.println("Mauvais password...");
						return null;
					}
				} else {
					System.out.println("Mauvais email...");
					return null;
				}


    	    }
			catch (AuthenticationException e) {
				System.out.println("Authentication failed for user " + request.getEmail() +" / "+request.getPassword() + ": " + e.getMessage());
				e.printStackTrace(); // Pour obtenir plus de détails sur l'erreur
				return null;
			}

     }
}
