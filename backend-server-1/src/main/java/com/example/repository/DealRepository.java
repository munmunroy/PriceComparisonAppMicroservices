package com.example.repository;

import com.example.model.DealItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRepository extends JpaRepository<DealItem, Long> {
    List<DealItem> findByCategoryName(String categoryName);
}
