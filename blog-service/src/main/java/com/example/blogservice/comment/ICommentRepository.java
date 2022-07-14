package com.example.blogservice.comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<CommentModel, Long> {
}
