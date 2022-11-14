package com.obinna.FashionBlog.services;

import com.obinna.FashionBlog.DTO.LoginDTO;
import com.obinna.FashionBlog.DTO.UserDTO;
import com.obinna.FashionBlog.models.UserModel;
import com.obinna.FashionBlog.responses.APIResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserModel createUser(UserDTO userDTO);
    UserModel findUserByEmail(String email);
    UserModel findUserById(Long id);
    String loginUser(LoginDTO loginDTO);

}
