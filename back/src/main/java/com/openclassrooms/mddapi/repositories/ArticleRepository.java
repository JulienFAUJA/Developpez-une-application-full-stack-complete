package com.openclassrooms.mddapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.models.ArticleModel;

@Repository
public interface ArticleRepository extends CrudRepository<ArticleModel, Integer> {
}
