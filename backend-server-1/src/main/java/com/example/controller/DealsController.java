package com.example.controller;

import com.example.model.DealItem;
import com.example.repository.DealRepository;
import com.example.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/backendserver1/amazon")
public class DealsController {
    @Autowired
    private DealRepository dealItemRepository;
    @Autowired
    private DealService dealService;

    @GetMapping("/{categoryName}")
    public Map<String, Object> getDealsByCategory(@PathVariable String categoryName) {
        List<DealItem> deals = dealItemRepository.findByCategoryName(categoryName);

        // Set the categoryName for each deal item
        deals.forEach(dealItem -> dealItem.setCategoryName(categoryName));

        // Create the response structure
        Map<String, Object> response = new HashMap<>();
        response.put("categoryName", categoryName);
        response.put("dealItems", deals);

        return response;
    }
    // New endpoint for adding a deal
    @PostMapping("/add-deal")
    public ResponseEntity<String> addDeal(@RequestBody DealItem dealItem) {
        dealService.addDeal(dealItem);
        return ResponseEntity.ok("Deal added successfully!");
    }
}
