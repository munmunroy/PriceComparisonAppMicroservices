package com.example.repository;

import com.example.model.EBayDealItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EBayDealItemRepository extends JpaRepository<EBayDealItem, String> {
    List<EBayDealItem> findByCategoryName(String categoryName);
}
