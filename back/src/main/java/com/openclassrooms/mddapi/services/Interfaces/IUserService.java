package com.openclassrooms.mddapi.services.Interfaces;
import com.openclassrooms.mddapi.dto.UserDTO;

public interface IUserService {
	
	UserDTO getUserById(Integer id);

}
