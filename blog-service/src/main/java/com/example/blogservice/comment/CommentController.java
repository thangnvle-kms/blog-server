package com.example.blogservice.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentServices commentServices;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@RequestBody CommentRequest commentRequest) {
        commentServices.createComment(commentRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CommentResponse> getAllComment() {
        return commentServices.getAllComment();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentModel getComment(@PathVariable("id") long id) {return commentServices.getOneComment(id);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteComment(@PathVariable("id") long id) {commentServices.deleteOneComment(id);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommentModel updateComment(@RequestBody CommentModel comment, @PathVariable long id) {
        return commentServices.updateOneComment(comment, id);
    }
}
