package com.openclassrooms.mddapi.services.Interfaces;

import java.security.Principal;

import com.openclassrooms.mddapi.dto.*;

/**
 * The interface Auth service.
 */
public interface IAuthService {

	/**
	 * Me user profile response dto.
	 *
	 * @param user the user
	 * @return the user profile response dto
	 */
	UserProfileResponseDTO me(Principal user);

	/**
	 * Register token dto.
	 *
	 * @param request the request
	 * @return the token dto
	 */
	TokenDTO register(UserRegisterDTO request);

	/**
	 * Authenticating string.
	 *
	 * @param request the request
	 * @return the string
	 */
	String authenticating(UserLoginDTO request);

	/**
	 * Update user string.
	 *
	 * @param userUpdateDTO the user update dto
	 * @param userEmail     the user email
	 * @return the string
	 */
	String update_user(UserUpdateDTO userUpdateDTO, String userEmail);
}
