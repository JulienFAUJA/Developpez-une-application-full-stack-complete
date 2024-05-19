package com.openclassrooms.mddapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.models.ThemeModel;

@Repository
public interface ThemeRepository extends CrudRepository<ThemeModel, Integer> {
}



