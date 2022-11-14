package com.obinna.FashionBlog.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
