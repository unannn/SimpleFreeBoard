package com.unannn.freeBoard.service;

import com.unannn.freeBoard.domain.Post;
import com.unannn.freeBoard.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;

public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    //게시글 등록
    public Long registerPost(Post post){
        post.setViews(0);
        post.setCreationDate(getCurrentDatetime());

        return postRepository.save(post).getPostNo();
    }

    private String getCurrentDatetime(){
        Date currentDatetime = new Date(System.currentTimeMillis());
        SimpleDateFormat fourteen_format = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");

        return fourteen_format.format(currentDatetime);
    }

    //게시물 조회
    public Post getRequestPost(Long postNo){
        return postRepository.findByPostNo(postNo);
    }

    //게시글 찾기
    public List<Post> findPosts() {
        return postRepository.findAll();
    }
}
