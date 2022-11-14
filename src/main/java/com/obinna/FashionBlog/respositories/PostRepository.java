package com.obinna.FashionBlog.respositories;

import com.obinna.FashionBlog.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {

}
