package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.ThemeRequestDTO;
import com.openclassrooms.mddapi.dto.ThemeResponseDTO;
import com.openclassrooms.mddapi.models.AbonnementModel;
import com.openclassrooms.mddapi.models.CommentaireModel;
import com.openclassrooms.mddapi.models.ThemeModel;
import com.openclassrooms.mddapi.models.UserModel;
import com.openclassrooms.mddapi.repositories.AbonnementRepository;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import com.openclassrooms.mddapi.repositories.UserRepository;
import com.openclassrooms.mddapi.services.Interfaces.IThemeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThemeService implements IThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private AbonnementRepository abonnementRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ThemeResponseDTO getThemeById(Integer id) {
        return null;
    }

    /**
     * Récupère tous les thèmes pour la page utilisateur connecté
     * @param userEmail L'email de l'utilisateur connecté
     * @return Les thèmes concernés
     */
    @Override
    public List<ThemeResponseDTO> getAllThemesForUser(String userEmail) {
        // Récupérer l'utilisateur par email
        UserModel user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + userEmail));

        // Récupérer tous les theme_id des abonnements de l'utilisateur
        List<Integer> subscribedThemeIds = abonnementRepository.findAllByUserId(user.getId())
                .stream()
                .map(AbonnementModel::getThemeId)
                .collect(Collectors.toList());

        // Récupérer les thèmes auxquels l'utilisateur est abonné
        List<ThemeModel> subscribedThemes = themeRepository.findAllByIdIn(subscribedThemeIds);

        // Mapper les thèmes récupérés à ThemeResponseDTO
        return subscribedThemes.stream()
                .map(theme -> {
                    ThemeResponseDTO themeResponseDTO = modelMapper.map(theme, ThemeResponseDTO.class);
                    themeResponseDTO.setIsSubscribed(true);  // Définir isSubscribed à true pour tous les thèmes abonnés
                    return themeResponseDTO;
                })
                .collect(Collectors.toList());
    }

    /**
     * Récupère tous les thèmes mais stocke une distinction pour savoir si l'utilisateur connecté
     * y est abonné ou pas. Cette distinction c'est un booléen dans les DTOs de retour
     * @param userEmail L'email de l'utilisateur connecté
     * @return Les thèmes concernés
     */
    @Override
    public List<ThemeResponseDTO> getAllThemes(String userEmail) {
        // Récupérer l'utilisateur par email
        UserModel user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + userEmail));

        // Récupérer tous les theme_id des abonnements de l'utilisateur
        List<Integer> subscribedThemeIds = abonnementRepository.findAllByUserId(user.getId())
                .stream()
                .map(AbonnementModel::getThemeId) // Utilisez le modèle d'abonnement ici
                .collect(Collectors.toList());

        // Récupérer tous les thèmes
        Iterable<ThemeModel> allThemesIterable = themeRepository.findAll();

        // Convertir Iterable en List
        List<ThemeModel> allThemes = new ArrayList<>();
        allThemesIterable.forEach(allThemes::add);

        // Mapper les thèmes récupérés à ThemeResponseDTO en ajoutant l'information d'abonnement
        List<ThemeResponseDTO> themeResponseDTOs = allThemes.stream()
                .map(theme -> {
                    ThemeResponseDTO themeResponseDTO = modelMapper.map(theme, ThemeResponseDTO.class);
                    themeResponseDTO.setIsSubscribed(subscribedThemeIds.contains(theme.getId()));
                    return themeResponseDTO;
                })
                .collect(Collectors.toList());
        System.out.println("ALL THEMES:"+themeResponseDTOs.toString());
        return themeResponseDTOs;
    }




}
