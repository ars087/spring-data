package com.javaCodeSpringMVC.SpringMvcProjectMapper.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaCodeSpringMVC.SpringMvcProjectMapper.controller.exception.CustomBedRequestException;
import com.javaCodeSpringMVC.SpringMvcProjectMapper.model.Product;
import com.javaCodeSpringMVC.SpringMvcProjectMapper.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {


    private final ProductService productService;
    public ObjectMapper objectMapper = new ObjectMapper();

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Long productId) {

        Product product = productService.getProductById(productId);

        String jsonString;
        try {
            jsonString = objectMapper.writeValueAsString(product);
        } catch (JsonProcessingException e) {
            throw new CustomBedRequestException(e.getMessage());
        }
        return ResponseEntity.ok(jsonString);

    }

    @PostMapping
    public String createProduct(@RequestBody String productRequest) {

        if (productRequest == null) {
            return ResponseEntity.badRequest().body("Отсутствует значение").toString();
        }
        Product product;
        try {
            product = objectMapper.readValue(productRequest, Product.class);
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body("Ошибка десеарелизации").toString();
        }
        productService.createProduct(product);
        return ResponseEntity.ok().body("Продукт создан").toString();
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @Valid @RequestBody Product product) {
        try {
            Product updatedProduct = productService.updateProduct(productId, product);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);

    }
}