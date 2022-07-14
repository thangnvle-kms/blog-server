package com.example.blogservice.comment;

import com.example.blogservice.post.PostModel;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {

    public Long id;
    public Long userId;
    public PostModel postId;
    public String content;
    public Date createdAt;
    public String createdBy;
    public Date deleteAt;
}
