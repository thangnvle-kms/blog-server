package com.example.blogservice.repository;

import com.example.blogservice.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryModel, Long> {
}
