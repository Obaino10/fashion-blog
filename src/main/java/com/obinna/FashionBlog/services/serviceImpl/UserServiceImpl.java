package com.obinna.FashionBlog.services.serviceImpl;

import com.obinna.FashionBlog.DTO.LoginDTO;
import com.obinna.FashionBlog.DTO.UserDTO;
import com.obinna.FashionBlog.exceptionHandler.UserNotFindException;
import com.obinna.FashionBlog.models.UserModel;
import com.obinna.FashionBlog.responses.APIResponse;
import com.obinna.FashionBlog.respositories.UserRepository;
import com.obinna.FashionBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserModel createUser(UserDTO userDTO) {
        UserModel userModel = new UserModel();
        userModel.setFirstName(userDTO.getFirstName());
        userModel.setLastName(userDTO.getLastName());
        userModel.setEmail(userDTO.getEmail());
        userModel.setPassword(userDTO.getPassword());
        return userRepository.save(userModel);
    }

    @Override
    public UserModel findUserByEmail(String email) {
        return userRepository.findUserModelByEmail(email).orElseThrow(() -> new UserNotFindException("This user does not exist: "+email));
    }

    @Override
    public UserModel findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFindException("This user does not exist: "+id));
    }

    @Override
    public String loginUser(LoginDTO loginDTO) {
        UserModel person = findUserByEmail(loginDTO.getEmail());
        if (person != null && person.getPassword().equals(loginDTO.getPassword())) return "Successfully Logged In";
        return "Invalid Login Details";
    }
}
