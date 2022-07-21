package com.example.blogservice.post;

import com.example.blogservice.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
@CrossOrigin()
public class PostController extends BaseController {

    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostRequest postRequest) {
        postService.createPost(postRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostResponse> getAllComment() {
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostModel getPost(@PathVariable("id") long id) { return postService.getOnePost(id);}

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostModel updatePost(@RequestBody PostModel post, @PathVariable long id) {
        return postService.updateOnePost(post, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable("id") long id) {
        postService.deleteOnePost(id);
    }
}
