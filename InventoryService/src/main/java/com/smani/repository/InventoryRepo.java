package com.smani.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smani.model.Inventory;
import com.smani.model.InventoryResponse;

public interface InventoryRepo extends JpaRepository<Inventory, Long> {

	List<Inventory> findByskuCodeIn(List<String> skuCode);

}
