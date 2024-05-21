package com.openclassrooms.mddapi.services.Interfaces;

import java.security.Principal;

import com.openclassrooms.mddapi.dto.*;

public interface IAuthService {

	UserProfileResponseDTO me(Principal user);
	
	TokenDTO register(UserRegisterDTO request);
	
	TokenDTO authenticating(UserLoginDTO request);

}
