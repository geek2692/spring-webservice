package com.ngle.webservice.service;

import com.ngle.webservice.domain.posts.PostsRepository;
import com.ngle.webservice.dto.posts.PostsMainResponseDto;
import com.ngle.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jojoldu@gmail.com on 2017. 12. 27.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}