package com.example.blogservice.post;

import com.example.blogservice.category.CategoryModel;
import com.example.blogservice.comment.CommentModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PostModel {

    @Id
    @GeneratedValue
    public Long id;

    @ManyToOne(optional=false)
    @JsonIgnore
    @JoinColumn(name="categoryId",referencedColumnName="id")
    public CategoryModel categoryId;

    public Long userId;
    public String title;
    public String shortDesc;
    public String content;
    public String img;
    public Date createdAt;
    public String createdBy;
    public Date deleteAt;


    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL)
    private Collection<CommentModel> comment;
}
