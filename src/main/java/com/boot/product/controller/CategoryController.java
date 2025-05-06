package com.boot.product.controller;

import com.boot.product.dto.CategoryDTO;
import com.boot.product.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    @GetMapping( "/{id}")
    public CategoryDTO getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
