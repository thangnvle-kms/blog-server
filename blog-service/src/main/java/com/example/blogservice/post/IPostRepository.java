package com.example.blogservice.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPostRepository extends JpaRepository<PostModel, Long> {
    @Query ("SELECT p FROM Post p WHERE p.name LIKE %?1%")
    public List<PostModel> findPost(String keyword);

}
