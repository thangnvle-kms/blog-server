package com.example.blogservice.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final IPostRepository postRepository;
    public void createPost(PostRequest postRequest) {
        PostModel post = PostModel.builder()
                .categoryId(postRequest.getCategoryId())
                .userId(postRequest.getUserId())
                .title(postRequest.getTitle())
                .shortDesc(postRequest.getShortDesc())
                .content(postRequest.getContent())
                .img(postRequest.getImg())
                .createdAt(postRequest.getCreadtedAt())
                .createdBy(postRequest.getCreatedBy())
                .deleteAt(postRequest.getDeleteAt())
                .build();
        postRepository.save(post);
        log.info("Post {} is created", post.getId());
    }

    public List<PostResponse> getAllPost() {
        List<PostModel> posts = postRepository.findAll();
        return  posts.stream().map(this::mapToPostResponse).toList();
    }

    private PostResponse mapToPostResponse(PostModel postModel) {
        return  PostResponse.builder()
                .id(postModel.getId())
                .categoryId(postModel.getCategoryId())
                .userId(postModel.getUserId())
                .title(postModel.getTitle())
                .shortDesc(postModel.getShortDesc())
                .content(postModel.getContent())
                .img(postModel.getImg())
                .createdAt(postModel.getCreatedAt())
                .createdBy(postModel.getCreatedBy())
                .deleteAt(postModel.getDeleteAt())
                .build();
    }

    public PostModel getOnePost(@PathVariable long id) {
        return postRepository.findById(id).orElseThrow();
    }

    public PostModel updateOnePost(PostModel post, long id) {
        PostModel existingPost = postRepository.findById(id).orElseThrow();
        existingPost.setCategoryId(post.getCategoryId());
        existingPost.setUserId(post.getUserId());
        existingPost.setTitle(post.getTitle());
        existingPost.setShortDesc(post.getShortDesc());
        existingPost.setContent(post.getContent());
        existingPost.setImg(post.getImg());
        existingPost.setCreatedAt(post.getCreatedAt());
        existingPost.setCreatedBy(post.getCreatedBy());
        existingPost.setDeleteAt(post.getDeleteAt());
        return existingPost;
    }

    public void deleteOnePost(@PathVariable long id) {
        postRepository.deleteById(id);
    }

//    public List<PostResponse> findPost(String keyword) {
//       List<PostModel> posts = postRepository.findAll(keyword);
//    }
}
