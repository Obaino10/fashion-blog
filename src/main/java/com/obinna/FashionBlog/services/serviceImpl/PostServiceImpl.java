package com.obinna.FashionBlog.services.serviceImpl;

import com.obinna.FashionBlog.DTO.PostDTO;
import com.obinna.FashionBlog.exceptionHandler.PostNotFoundException;
import com.obinna.FashionBlog.exceptionHandler.UserNotFindException;
import com.obinna.FashionBlog.models.PostModel;
import com.obinna.FashionBlog.models.UserModel;
import com.obinna.FashionBlog.respositories.PostRepository;
import com.obinna.FashionBlog.services.PostService;
import com.obinna.FashionBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private UserService userService;


    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }


    @Override
    public PostModel createPost(Long user_id, PostDTO postDTO) {
        UserModel userModel = userService.findUserById(user_id);
        PostModel postModel = new PostModel();
        postModel.setTitle(postDTO.getTitle());
        postModel.setDescription(postDTO.getDescription());
        postModel.setCreatedDate(LocalDate.now());
        postModel.setUserModel(userModel);
        return postRepository.save(postModel);
    }

    @Override
    public String deletePost(Long id) {
        this.postRepository.deleteById(id);
        return "";
    }

    @Override
    public PostModel updatePost(Long id, PostDTO postDTO) {
        Optional<PostModel> optional = postRepository.findById(id);
        PostModel post = null;
        if(optional.isPresent()){
            post = optional.get();
        }
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setUpdatedDate(LocalDate.now());
        return postRepository.save(post);
    }

    @Override
    public PostModel findPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("This post does not exist: "+id));
    }
}
