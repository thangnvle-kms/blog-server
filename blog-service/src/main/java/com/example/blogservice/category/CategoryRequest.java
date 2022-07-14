package com.example.blogservice.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    private String name;
    private Date createdAt;
    private String createdBy;
    private Date deletedAt;
}
