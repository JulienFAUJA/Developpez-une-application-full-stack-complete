package com.openclassrooms.mddapi.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.openclassrooms.mddapi.models.UserModel;

@Repository
public interface UserRepository  extends CrudRepository<UserModel, Integer> {
	public Optional<UserModel> findByEmail(String email);
	public Optional<UserModel> findByName(String name);
	public Optional<UserModel> findById(Integer id);

}
