package com.example.blogservice.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {


    private final ICategoryRepository categoryRepository;

    public void createCategory(CategoryRequest categoryRequest) {
        CategoryModel category = CategoryModel.builder()
                .name(categoryRequest.getName())
                .createdAt(categoryRequest.getCreatedAt())
                .createdBy(categoryRequest.getCreatedBy())
                .deletedAt(categoryRequest.getDeletedAt())
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
                .createdAt(categoryModel.getCreatedAt())
                .createdBy(categoryModel.getCreatedBy())
                .deletedAt(categoryModel.getDeletedAt())
                .build();
    }

    public CategoryModel getOneCategory(@PathVariable long id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public void deleteOneCategory(@PathVariable long id) {
        categoryRepository.deleteById(id);
    }

    public CategoryModel updateOneCategory(CategoryModel category, long id) {
        CategoryModel existingCategory = categoryRepository.findById(id).orElseThrow();
        existingCategory.setName(category.getName());
        existingCategory.setCreatedAt(category.getCreatedAt());
        existingCategory.setCreatedBy(category.getCreatedBy());
        existingCategory.setDeletedAt(category.getDeletedAt());
        categoryRepository.save(existingCategory);
        return existingCategory;
    }
}
