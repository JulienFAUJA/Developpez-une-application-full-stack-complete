package com.openclassrooms.mddapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.models.CommentaireModel;

import java.util.List;
import java.util.Optional;

/**
 * The interface Commentaire repository.
 */
@Repository
public interface CommentaireRepository extends CrudRepository<CommentaireModel, Integer> {
    /**
     * Find all by article id list.
     *
     * @param id the id
     * @return the list
     */
    List<CommentaireModel> findAllByArticleId(Integer id);

}



