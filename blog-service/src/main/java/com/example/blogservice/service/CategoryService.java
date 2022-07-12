package com.example.blogservice.service;

import com.example.blogservice.dto.CategoryRequest;
import com.example.blogservice.dto.CategoryResponse;
import com.example.blogservice.model.CategoryModel;
import com.example.blogservice.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {


    private final ICategoryRepository categoryRepository;

    public void createCategory(CategoryRequest categoryRequest) {
        CategoryModel category = CategoryModel.builder()
                .name(categoryRequest.getName())
                .created_at(categoryRequest.getCreated_at())
                .created_by(categoryRequest.getCreated_by())
                .deleted_at(categoryRequest.getDeleted_at())
                .build();

        categoryRepository.save(category);
        log.info("Category {} is created", category.getId());
    }

    public List<CategoryResponse> getAllCategory() {
        List<CategoryModel> categories = categoryRepository.findAll();
        return categories.stream().map(this::mapToCategoryResponse).toList();
    }

    private CategoryResponse mapToCategoryResponse(CategoryModel categoryModel) {
        return CategoryResponse.builder()
                .id(categoryModel.getId())
                .name(categoryModel.getName())
                .created_at(categoryModel.getCreated_at())
                .created_by(categoryModel.getCreated_by())
                .deleted_at(categoryModel.getDeleted_at())
                .build();
    }
}
