package com.example.blogservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CategoryModel {
    @Id
    private Long id;
    private String name;
    private Date created_at;
    private String created_by;
    private Date deleted_at;
}
