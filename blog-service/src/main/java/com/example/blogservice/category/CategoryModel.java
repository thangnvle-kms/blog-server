package com.example.blogservice.category;

import com.example.blogservice.post.PostModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryModel {

    @Id
    @GeneratedValue
    @Column(nullable=false)
    private Long id;

    private String name;
    private Date createdAt;
    private String createdBy;
    private Date deletedAt;

    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL)
    private Collection<PostModel> post;
}
