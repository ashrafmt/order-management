package com.example.newdemo.controller;

import com.example.newdemo.entity.TheOrder;
import com.example.newdemo.service.TheOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class TheOrderController {
    private final TheOrderService theOrderService;

    public TheOrderController(TheOrderService theOrderService) {
        this.theOrderService = theOrderService;
    }

    @GetMapping
    public List<TheOrder> getAllOrders() {
        return theOrderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public TheOrder getOrderById(@PathVariable Long id) {
        return theOrderService.getOrderById(id);
    }

    @PostMapping
    public TheOrder createOrder(@RequestBody TheOrder theOrder) {
        return theOrderService.createOrder(theOrder);
    }

    @PutMapping("/{id}")
    public TheOrder updateOrder(@PathVariable Long id, @RequestBody TheOrder theOrder) {
        return theOrderService.updateOrder(id, theOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        theOrderService.deleteOrder(id);
    }
}
