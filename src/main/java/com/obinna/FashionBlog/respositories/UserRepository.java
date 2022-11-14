package com.obinna.FashionBlog.respositories;

import com.obinna.FashionBlog.DTO.UserDTO;
import com.obinna.FashionBlog.models.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel>findUserModelByEmail(String email);

}
