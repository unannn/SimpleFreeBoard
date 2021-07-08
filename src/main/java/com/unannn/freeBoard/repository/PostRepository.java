package com.unannn.freeBoard.repository;

import com.unannn.freeBoard.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);

    //Optional<Post> findById(Long id);
    //Optional<Post> findByName(String name);
    List<Post> findAll();
}
