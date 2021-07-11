package com.unannn.freeBoard.repository;

import com.unannn.freeBoard.domain.Post;
import java.util.*;

public class MemoryPostRepository implements PostRepository {

    private static Map<Long, Post> postStore = new HashMap<>();
    private static long sequence = 0L;

    //더미 게시물 메모리에 등록
    public MemoryPostRepository(){
        for(int i = 0;i < 10;i++){
            Post post = getAnyPost();
            postStore.put(post.getPostNo(),post);
        }
    }

    private Post getAnyPost(){
        Post post = new Post();
        post.setPostNo(++sequence);
        post.setTitle("title " + sequence);
        post.setWriterId("writer " + sequence);
        post.setViews(0);
        post.setCreationDate("2021/07/10 00:28:02");

        return post;
    }

    //게시물 등록
    @Override
    public Post save(Post post) {
        post.setPostNo(++sequence);
        postStore.put(post.getPostNo(),post);

        return post;
    }

    //게시물 번호로 게시글 찾기
    @Override
    public Post findByPostNo(Long postNo) {
        return postStore.get(postNo);
    }
    
    //게시물 전체 불러오기
    @Override
    public List<Post> findAll() {
        ArrayList<Post> allPost = new ArrayList<>(postStore.values());
        Collections.reverse(allPost);

        return allPost;
    }
}
