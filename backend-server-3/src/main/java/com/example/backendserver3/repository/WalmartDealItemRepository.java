package com.example.backendserver3.repository;

import com.example.backendserver3.model.WalmartDealItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalmartDealItemRepository extends JpaRepository<WalmartDealItem, String> {
    List<WalmartDealItem> findByCategoryName(String categoryName);
}