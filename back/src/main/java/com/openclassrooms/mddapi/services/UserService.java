package com.openclassrooms.mddapi.services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.dto.UserDTO;
import com.openclassrooms.mddapi.dto.UserLoginDTO;
import com.openclassrooms.mddapi.dto.UserRegisterDTO;
import com.openclassrooms.mddapi.models.UserModel;
import com.openclassrooms.mddapi.repositories.UserRepository;
import com.openclassrooms.mddapi.services.Interfaces.IUserService;

@Service
public class UserService implements UserDetailsService, IUserService {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return  userRepository.findByEmail(username).map(user -> new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.emptyList()))
				.orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé..."));
	}



	private List<GrantedAuthority> getGrantedAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		return authorities;
	}


	public UserDTO getUserById(Integer id){
		Optional<UserModel> user = this.userRepository.findById(id);
		return modelMapper.map(user.orElseThrow(), UserDTO.class);
	}




}