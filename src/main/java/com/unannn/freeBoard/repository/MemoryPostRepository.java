package com.unannn.freeBoard.repository;

import com.unannn.freeBoard.domain.Post;

import java.util.*;

public class MemoryPostRepository implements PostRepository {
    private static Map<Long, Post> postStore = new HashMap<>();
    private static long sequence = 0L;
    private ArrayList<Post> initPost = new ArrayList<>();

    public MemoryPostRepository(){

        for(int i = 0;i < 12;i++){
            Post post = getAnyPost();
            postStore.put(post.getPostNo(),post);
        }
    }

    private Post getAnyPost(){
        Post post = new Post();
        post.setPostNo(++sequence);
        post.setTitle("ㅁㄴㅇㄻㅇㄴㄹ");
        post.setWriterId("하마");
        post.setViews(1);

        return post;
    }

    @Override
    public Post save(Post post) {

        post.setPostNo(++sequence);

        postStore.put(post.getPostNo(),post);

        return post;
    }

    @Override
    public List<Post> findAll() {
        ArrayList<Post> allPost = new ArrayList<>(postStore.values());
        Collections.reverse(allPost);
        return allPost;
    }
}
