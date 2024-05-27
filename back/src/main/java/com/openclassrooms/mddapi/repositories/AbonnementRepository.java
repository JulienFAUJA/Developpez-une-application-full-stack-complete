package com.openclassrooms.mddapi.repositories;

import com.openclassrooms.mddapi.models.AbonnementModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Abonnement repository.
 */
public interface AbonnementRepository extends CrudRepository<AbonnementModel, Integer> {
    /**
     * Find all by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<AbonnementModel> findAllByUserId(Integer userId);

    /**
     * Find by user id and theme id optional.
     *
     * @param user_id  the user id
     * @param theme_id the theme id
     * @return the optional
     */
    Optional<AbonnementModel> findByUserIdAndThemeId(Integer user_id, Integer theme_id);


    @Override
    void delete(AbonnementModel abonnementModel);
}
