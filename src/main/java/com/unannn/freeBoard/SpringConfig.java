package com.unannn.freeBoard;

import com.unannn.freeBoard.repository.MemoryPostRepository;
import com.unannn.freeBoard.repository.PostRepository;
import com.unannn.freeBoard.service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public PostService postService(){
        return new PostService(postRepository());
    }

    @Bean
    public PostRepository postRepository(){
        return new MemoryPostRepository();
    }
}
