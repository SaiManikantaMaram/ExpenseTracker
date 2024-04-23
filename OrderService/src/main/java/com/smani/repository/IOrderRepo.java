package com.smani.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smani.model.Order;

public interface IOrderRepo extends JpaRepository<Order, Long> {

}
