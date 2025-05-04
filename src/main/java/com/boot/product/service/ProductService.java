package com.boot.product.service;

import com.boot.product.dto.ProductDTO;
import com.boot.product.entity.Category;
import com.boot.product.entity.Product;
import com.boot.product.mapper.ProductMapper;
import com.boot.product.repository.CategoryRepository;
import com.boot.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public ProductDTO createProduct(ProductDTO productDTO){
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new IllegalArgumentException("Invalid Category"));
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }
    public ProductDTO getProduct(long id) {
        Product product = productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Product"));
        return ProductMapper.toProductDTO(product);
    }

}
