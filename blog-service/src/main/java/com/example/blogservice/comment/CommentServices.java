package com.example.blogservice.comment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServices {

    private final ICommentRepository commentRepository;
    public void createComment(CommentRequest commentRequest) {
        CommentModel comment = CommentModel.builder()
                .userId(commentRequest.getUserId())
                .postId(commentRequest.getPostId())
                .content(commentRequest.getContent())
                .createdAt(commentRequest.getCreatedAt())
                .createdBy(commentRequest.getCreatedBy())
                .deleteAt(commentRequest.getDeleteAt())
                .build();

        commentRepository.save(comment);
        log.info("Comment {} is created", comment.getId());
    }

    public List<CommentResponse> getAllComment() {
        List<CommentModel> categories = commentRepository.findAll();
        return categories.stream().map(this::mapToCommentResponse).toList();
    }

    private CommentResponse mapToCommentResponse(CommentModel commentModel) {
        return CommentResponse.builder()
                .id(commentModel.getId())
                .userId(commentModel.getUserId())
                .postId(commentModel.getPostId())
                .content(commentModel.getContent())
                .createdAt(commentModel.getCreatedAt())
                .createdBy(commentModel.getCreatedBy())
                .deleteAt(commentModel.getDeleteAt())
                .build();
    }

    public CommentModel getOneComment(long id) {
        return commentRepository.findById(id).orElseThrow();
    }

    public void deleteOneComment(long id) {
        commentRepository.deleteById(id);
    }

    public CommentModel updateOneComment(CommentModel comment, long id) {
        CommentModel existingComment = commentRepository.findById(id).orElseThrow();
        existingComment.setUserId(comment.getUserId());
        existingComment.setPostId(comment.getPostId());
        existingComment.setContent(comment.getContent());
        existingComment.setCreatedAt(comment.getCreatedAt());
        existingComment.setCreatedBy(comment.getCreatedBy());
        existingComment.setDeleteAt(comment.getDeleteAt());
        return existingComment;
    }
}
