package com.boot.product.controller;

import com.boot.product.dto.ProductDTO;
import com.boot.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;
//    Create Product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }
//    Get Product
    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }
//    Get All Products
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getProducts();
    }
//    Update Product
    @PutMapping()
    public String updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }
//    Delete Product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }
}
