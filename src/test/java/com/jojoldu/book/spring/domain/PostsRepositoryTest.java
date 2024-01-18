package com.jojoldu.book.spring.domain;


import com.jojoldu.book.spring.domain.posts.Posts;
import com.jojoldu.book.spring.domain.posts.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder().title(title)
                .content(content).author("rovin054@gmail.com").build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void time_등록테스트(){
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder().title("title")
                .content("content").author("author").build());

        List<Posts> postsList=postsRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());
        assertThat(posts.getModifiedDate()).isAfter(now);
        assertThat(posts.getCreatedDate()).isAfter(now);
    }
}
