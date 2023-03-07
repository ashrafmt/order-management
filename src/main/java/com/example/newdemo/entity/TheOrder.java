package com.example.newdemo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "the_order")
public class TheOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "orderd_at")
    private LocalDateTime orderdAt;

    public TheOrder() {
    }

    public TheOrder(Customer customer, LocalDateTime orderdAt) {
        this.customer = customer;
        this.orderdAt = orderdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderdAt() {
        return orderdAt;
    }

    public void setOrderdAt(LocalDateTime orderdAt) {
        this.orderdAt = orderdAt;
    }
}
