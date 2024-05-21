package com.openclassrooms.mddapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.models.CommentaireModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentaireRepository extends CrudRepository<CommentaireModel, Integer> {
    public List<CommentaireModel> findAllByArticleId(Integer id);

}



