package com.example.blogservice.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<PostModel, Long> {
}
