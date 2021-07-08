package com.unannn.freeBoard.service;

import com.unannn.freeBoard.domain.Post;
import com.unannn.freeBoard.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    /**
     * 회원 가입
     */
//    public Long join(Post post) {
//
//        validateDuplicateMember(member); //중복 회원 검증
//        memberRepository.save(member);
//        return member.getId();
//    }
//
//    private void validateDuplicateMember(Member member) {
//        memberRepository.findByName(member.getName())
//                .ifPresent(m -> {
//                    throw new IllegalStateException("이미 존재하는 회원입니다");
//                });
//    }

    /**
     * 전체 회원 조회
     */
    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    //public Optional<Member> findOne(Long memberId) {
//        return memberRepository.findById(memberId);
//    }
}
