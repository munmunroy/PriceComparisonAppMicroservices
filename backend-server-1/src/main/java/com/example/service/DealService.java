package com.example.service;

import com.example.model.DealItem;
import com.example.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealService {
    @Autowired
    private DealRepository dealRepository;

    public List<DealItem> getDeals(String categoryName) {
        // Implement logic to fetch deals from JPA repository
        return dealRepository.findByCategoryName(categoryName);
    }
    public void addDeal(DealItem dealItem) {
        // Implement logic to add a deal to the repository
        dealRepository.save(dealItem);
    }
}
