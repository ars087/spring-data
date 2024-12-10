package com.javaCodeSpringMVC.SpringMvcProjectMapper.service;

import com.javaCodeSpringMVC.SpringMvcProjectMapper.controller.exception.CustomNotFoundException;
import com.javaCodeSpringMVC.SpringMvcProjectMapper.model.Product;
import com.javaCodeSpringMVC.SpringMvcProjectMapper.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
            .orElseThrow(() -> new CustomNotFoundException("Продукт не найден"));
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product product) {
        Product existingProduct = getProductById(productId);
        product.setProductId(existingProduct.getProductId());
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}