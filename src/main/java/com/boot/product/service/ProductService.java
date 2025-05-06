package com.boot.product.service;

import com.boot.product.dto.ProductDTO;
import com.boot.product.entity.Category;
import com.boot.product.entity.Product;
import com.boot.product.mapper.ProductMapper;
import com.boot.product.repository.CategoryRepository;
import com.boot.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

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

    public List<ProductDTO> getProducts() {
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    public String updateProduct(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId()).orElseThrow(()->new IllegalArgumentException("Invalid Product"));
        boolean categoryExists = categoryRepository.existsById(productDTO.getCategoryId());
        if(!categoryExists) {throw new IllegalArgumentException("Invalid Category");}
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new IllegalArgumentException("Invalid Category")));
        productRepository.save(product);
        return "Product Updated Successfully";
    }

    public String deleteProduct(long id) {
        productRepository.deleteById(id);
        return "Product Deleted Successfully";
    }
}
