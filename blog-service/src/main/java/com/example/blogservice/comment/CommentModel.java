package com.example.blogservice.comment;

import com.example.blogservice.post.PostModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CommentModel {

    @Id
    @GeneratedValue
    @Column(nullable=false)
    public Long id;
    public Long userId;

    @ManyToOne(optional=false)
    @JsonIgnore
    @JoinColumn(name="postId",referencedColumnName="id")
    public PostModel postId;

    public String content;
    public Date createdAt;
    public String createdBy;
    public Date deleteAt;
}
