package com.obinna.FashionBlog.services;

import com.obinna.FashionBlog.DTO.CommentDTO;
import com.obinna.FashionBlog.models.Comment;

public interface CommentService {
    Comment createComment(Long user_id, Long post_id, CommentDTO commentDTODTO);


}
