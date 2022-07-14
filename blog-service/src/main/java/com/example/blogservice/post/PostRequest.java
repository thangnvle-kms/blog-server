package com.example.blogservice.post;

import com.example.blogservice.category.CategoryModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {

    public CategoryModel categoryId;
    public Long userId;
    public String title;
    public String shortDesc;
    public String content;
    public String img;
    public Date creadtedAt;
    public String createdBy;
    public Date deleteAt;

}
