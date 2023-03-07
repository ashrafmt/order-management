package com.example.newdemo.repository;

import com.example.newdemo.entity.TheOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheOrderRepository extends JpaRepository<TheOrder, Long> {
}
