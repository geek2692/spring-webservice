package com.ngle.webservice.web;

import com.ngle.webservice.domain.posts.PostsRepository;
import com.ngle.webservice.dto.posts.PostsSaveRequestDto;
import com.ngle.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsService.save(dto);
    }
}
