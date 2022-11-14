package com.obinna.FashionBlog.services.serviceImpl;

import com.obinna.FashionBlog.DTO.CommentDTO;
import com.obinna.FashionBlog.models.Comment;
import com.obinna.FashionBlog.models.PostModel;
import com.obinna.FashionBlog.models.UserModel;
import com.obinna.FashionBlog.respositories.CommentRepository;
import com.obinna.FashionBlog.services.CommentService;
import com.obinna.FashionBlog.services.PostService;
import com.obinna.FashionBlog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    @Override
    public Comment createComment(Long user_id, Long post_id, CommentDTO commentDTO) {
        Comment comment = new Comment();
        UserModel userModel = userService.findUserById(user_id);
        PostModel postModel = postService.findPostById(post_id);
        comment.setComment((commentDTO.getComment()));
        comment.setPostModel(postModel);
        comment.setUserModel(userModel);
        return commentRepository.save(comment);
    }
}
