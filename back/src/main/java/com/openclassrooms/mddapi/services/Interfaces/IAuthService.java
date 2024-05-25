package com.openclassrooms.mddapi.services.Interfaces;

import java.security.Principal;

import com.openclassrooms.mddapi.dto.*;

public interface IAuthService {

	UserProfileResponseDTO me(Principal user);
	
	TokenDTO register(UserRegisterDTO request);

	String authenticating(UserLoginDTO request);

	String update_user(UserUpdateDTO userUpdateDTO, String userEmail);
}
