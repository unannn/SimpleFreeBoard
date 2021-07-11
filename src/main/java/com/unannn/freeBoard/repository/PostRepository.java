package com.unannn.freeBoard.repository;

import com.unannn.freeBoard.domain.Post;

import java.util.List;

public interface PostRepository {
    Post save(Post post);
    Post findByPostNo(Long postNo);
    List<Post> findAll();
}
