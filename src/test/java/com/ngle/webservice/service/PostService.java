package com.ngle.webservice.service;

import com.ngle.webservice.domain.posts.Posts;
import com.ngle.webservice.domain.posts.PostsRepository;
import com.ngle.webservice.dto.posts.PostsSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostService {
    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void Dto파라미터_posts테이블_저장된다() {
        //given
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title("테스트 타이틀")
                .content("테스트 본문")
                .author("test@gmail.com")
                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
    }
}
