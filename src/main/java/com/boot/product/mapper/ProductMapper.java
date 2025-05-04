package com.boot.product.mapper;

import com.boot.product.dto.ProductDTO;
import com.boot.product.entity.Category;
import com.boot.product.entity.Product;

public class ProductMapper {
//    Entity to DTO
    public static ProductDTO toProductDTO(Product product) {
        if(product == null) {return null;}
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }
//    DTO to Entity
    public static Product toProductEntity(ProductDTO productDTO, Category category) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;
    }
}
