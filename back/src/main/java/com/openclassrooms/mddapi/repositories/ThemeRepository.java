package com.openclassrooms.mddapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.models.ThemeModel;

import java.util.List;

@Repository
public interface ThemeRepository extends CrudRepository<ThemeModel, Integer> {
    ThemeModel findByTheme(String theme);
    List<ThemeModel> findAll();
    List<ThemeModel> findAllByIdIn(List<Integer> subscribedThemeIds);
}



