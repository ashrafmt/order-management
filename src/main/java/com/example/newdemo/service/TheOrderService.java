package com.example.newdemo.service;

import com.example.newdemo.entity.TheOrder;
import com.example.newdemo.repository.TheOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TheOrderService {
    private final TheOrderRepository theOrderRepository;

    public TheOrderService(TheOrderRepository theOrderRepository) {
        this.theOrderRepository = theOrderRepository;
    }

    public List<TheOrder> getAllOrders() {
        return theOrderRepository.findAll();
    }

    public TheOrder getOrderById(Long id) {
        return theOrderRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("TheOrder not found with id: " + id));
    }

    public TheOrder createOrder(TheOrder theOrder) {
        return theOrderRepository.save(theOrder);
    }

    public TheOrder updateOrder(Long id, TheOrder updatedOrder) {
        TheOrder theOrder = getOrderById(id);
        theOrder.setCustomer(updatedOrder.getCustomer());
        theOrder.setOrderdAt(updatedOrder.getOrderdAt());
        return theOrderRepository.save(theOrder);
    }

    public void deleteOrder(Long id) {
        theOrderRepository.deleteById(id);
    }
}
