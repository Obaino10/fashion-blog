package com.obinna.FashionBlog.services;

import com.obinna.FashionBlog.DTO.PostDTO;
import com.obinna.FashionBlog.models.PostModel;

public interface PostService  {
    PostModel createPost(Long user_id, PostDTO postDTO);
    String deletePost(Long id);
    PostModel updatePost(Long id, PostDTO postDTO);
    PostModel findPostById(Long id);

}
