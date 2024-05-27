package com.openclassrooms.mddapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.models.ArticleModel;

import java.util.List;

/**
 * The interface Article repository.
 */
@Repository
public interface ArticleRepository extends CrudRepository<ArticleModel, Integer> {
    /**
     * Find all by theme id in list.
     *
     * @param themeIds the theme ids
     * @return the list
     */
    List<ArticleModel> findAllByThemeIdIn(List<Integer> themeIds);
}
