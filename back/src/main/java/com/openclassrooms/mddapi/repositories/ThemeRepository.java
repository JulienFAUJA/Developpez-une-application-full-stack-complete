package com.openclassrooms.mddapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.models.ThemeModel;

import java.util.List;

/**
 * The interface Theme repository.
 */
@Repository
public interface ThemeRepository extends CrudRepository<ThemeModel, Integer> {
    /**
     * Find by theme theme model.
     *
     * @param theme the theme
     * @return the theme model
     */
    ThemeModel findByTheme(String theme);
    List<ThemeModel> findAll();

    /**
     * Find all by id in list.
     *
     * @param subscribedThemeIds the subscribed theme ids
     * @return the list
     */
    List<ThemeModel> findAllByIdIn(List<Integer> subscribedThemeIds);
}



