package com.example.demo.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.InventoryEvent;

@Repository
public interface InventoryEventRepository extends JpaRepository<InventoryEvent, Long>{

}
