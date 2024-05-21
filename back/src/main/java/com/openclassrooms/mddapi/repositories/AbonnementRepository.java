package com.openclassrooms.mddapi.repositories;

import com.openclassrooms.mddapi.dto.AbonnementRequestDTO;
import com.openclassrooms.mddapi.models.AbonnementModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface AbonnementRepository extends CrudRepository<AbonnementModel, Integer> {
    List<AbonnementModel> findAllByUserId(Integer userId);
    Optional<AbonnementModel> findByUserIdAndThemeId(Integer user_id, Integer theme_id);


}

