package com.blessing333.boardapi.entity;

import com.blessing333.boardapi.exception.PostCreateFailException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PostTest {
    private static final User user = User.createUser("minjae",28);
    private static final String title = "제목";
    private static final String content = "내용";

    @DisplayName("제목, 내용, 작성자로 Post 생성")
    @Test
    void testCreatePost(){
        Post post = Post.createNewPost(title,content,user);

        assertThat(post.getCreatedBy()).isEqualTo(user);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

    @DisplayName("제목의 길이가 2미만이면 IllegalArgumentException 생성")
    @Test
    void testCreatePostWithShortTittle(){
        String invalidTitle ="제";
        assertThrows(PostCreateFailException.class,()->Post.createNewPost(invalidTitle,content,user));
    }
}