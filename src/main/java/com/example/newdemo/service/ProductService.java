package com.example.newdemo.service;

import com.example.newdemo.entity.Product;
import com.example.newdemo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getProductById(id);
        product.setSlug(updatedProduct.getSlug());
        product.setName(updatedProduct.getName());
        product.setReference(updatedProduct.getReference());
        product.setPrice(updatedProduct.getPrice());
        product.setVat(updatedProduct.getVat());
        product.setStockable(updatedProduct.isStockable());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
