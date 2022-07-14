package com.example.blogservice.comment;

import com.example.blogservice.post.PostModel;
import lombok.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {

    public Long userId;
    public PostModel postId;
    public String content;
    public Date createdAt;
    public String createdBy;
    public Date deleteAt;
}
