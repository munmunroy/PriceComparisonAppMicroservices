package com.example.controller;

import com.example.model.EBayDealItem;
import com.example.repository.EBayDealItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/backendserver2/ebay/deals")
public class EBayDealItemController {
    @Autowired
    private EBayDealItemRepository eBayDealItemRepository;

    @GetMapping("/{categoryName}")
    public Map<String, Object> getDealsByCategory(@PathVariable String categoryName) {
        List<EBayDealItem> deals = eBayDealItemRepository.findByCategoryName(categoryName);

        // Set the categoryName for each deal item
        deals.forEach(eBayDealItem -> eBayDealItem.setCategoryName(categoryName));

        // Create the response structure
        Map<String, Object> response = new HashMap<>();
        response.put("categoryName", categoryName);
        response.put("dealItems", deals);

        return response;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEBayDealItem(@RequestBody EBayDealItem eBayDealItem) {
        // Save the eBay deal item to the database
        eBayDealItemRepository.save(eBayDealItem);

        return ResponseEntity.status(HttpStatus.CREATED).body("eBay Deal item added successfully");
    }
}