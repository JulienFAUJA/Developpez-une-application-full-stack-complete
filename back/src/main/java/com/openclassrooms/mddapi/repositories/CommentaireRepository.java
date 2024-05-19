package com.openclassrooms.mddapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.models.CommentaireModel;

@Repository
public interface CommentaireRepository extends CrudRepository<CommentaireModel, Integer> {
}



