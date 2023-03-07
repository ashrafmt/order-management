package com.example.newdemo.service;

import com.example.newdemo.entity.ProductOrder;
import com.example.newdemo.repository.ProductOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductOrderService {
    private final ProductOrderRepository productOrderRepository;

    public ProductOrderService(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }

    public List<ProductOrder> getAllProductOrders() {
        return productOrderRepository.findAll();
    }

    public ProductOrder getProductOrderById(Long id) {
        return productOrderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("ProductOrder not found with id: " + id));
    }

    public ProductOrder createProductOrder(ProductOrder productOrder) {
        return productOrderRepository.save(productOrder);
    }

    public ProductOrder updateProductOrder(Long id, ProductOrder updatedProductOrder) {
        ProductOrder productOrder = getProductOrderById(id);
        productOrder.setProduct(updatedProductOrder.getProduct());
        productOrder.setOrder(updatedProductOrder.getOrder());
        productOrder.setQuantity(updatedProductOrder.getQuantity());
        productOrder.setPrice(updatedProductOrder.getPrice());
        productOrder.setVat(updatedProductOrder.getVat());
        return productOrderRepository.save(productOrder);
    }

    public void deleteProductOrder(Long id) {
        productOrderRepository.deleteById(id);
    }
}
