package com.openclassrooms.mddapi.services.Interfaces;

import java.security.Principal;

import com.openclassrooms.mddapi.dto.TokenDTO;
import com.openclassrooms.mddapi.dto.UserLoggedDTO;
import com.openclassrooms.mddapi.dto.UserLoginDTO;
import com.openclassrooms.mddapi.dto.UserRegisterDTO;

public interface IAuthService {
		
	UserLoggedDTO me(Principal user);
	
	TokenDTO register(UserRegisterDTO request);
	
	TokenDTO authenticating(UserLoginDTO request);

}
