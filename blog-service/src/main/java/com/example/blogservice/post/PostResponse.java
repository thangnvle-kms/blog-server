package com.example.blogservice.post;

import com.example.blogservice.category.CategoryModel;
import com.example.blogservice.comment.CommentModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

    public Long id;
    public CategoryModel categoryId;
    public Long userId;
    public String title;
    public String shortDesc;
    public String content;
    public String img;
    public Date createdAt;
    public String createdBy;
    public Date deleteAt;
    private Collection<CommentModel> comment;
}
