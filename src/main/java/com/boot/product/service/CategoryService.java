package com.boot.product.service;

import com.boot.product.dto.CategoryDTO;
import com.boot.product.entity.Category;
import com.boot.product.mapper.CategoryMapper;
import com.boot.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    public CategoryDTO getCategory(Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return CategoryMapper.toCategoryDTO(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

}
