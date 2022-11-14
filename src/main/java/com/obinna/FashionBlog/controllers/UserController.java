package com.obinna.FashionBlog.controllers;

import com.obinna.FashionBlog.DTO.CommentDTO;
import com.obinna.FashionBlog.DTO.LoginDTO;
import com.obinna.FashionBlog.DTO.PostDTO;
import com.obinna.FashionBlog.DTO.UserDTO;
import com.obinna.FashionBlog.responses.APIResponse;
import com.obinna.FashionBlog.services.CommentService;
import com.obinna.FashionBlog.services.PostService;
import com.obinna.FashionBlog.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")

public class UserController {

    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;


    @PostMapping("/createUser")
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO){
        return APIResponse.generateResponse("Request Successful", HttpStatus.OK, userService.createUser(userDTO));
    }

    @PostMapping("/post/{user_id}")
    public ResponseEntity<Object> createPost(@PathVariable (value = "user_id") Long user_id,
                                             @RequestBody PostDTO postDTO){
        return APIResponse.generateResponse(" Request Successful", HttpStatus.OK, postService.createPost(user_id, postDTO));
    }

    @PostMapping("/comment/{user_id}/{post_id}")
    public ResponseEntity<Object> createComment(@PathVariable (value = "user_id") Long user_id,
                                                @PathVariable (value = "post_id") Long post_id,
                                                @RequestBody CommentDTO commentDTO){
        return APIResponse.generateResponse(" Request Successful", HttpStatus.OK, commentService.createComment(user_id, post_id, commentDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable(value = "id")Long id){
        return APIResponse.generateResponse("Delete Successful", HttpStatus.OK, postService.deletePost(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updatePost(@PathVariable(value = "id")Long id,
                                             @RequestBody PostDTO postDTO){
        return APIResponse.generateResponse("Update Successful", HttpStatus.OK, postService.updatePost(id, postDTO));
    }

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<Object> loginUser(@PathVariable(value = "email")String email,
                                            @PathVariable(value = "password") String password,
                                            @RequestBody LoginDTO loginDTO){
        return APIResponse.generateResponse("Successfully Logged In", HttpStatus.OK, userService.loginUser(loginDTO));
    }

}
