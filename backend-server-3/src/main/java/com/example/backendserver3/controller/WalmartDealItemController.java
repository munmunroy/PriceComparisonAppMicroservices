package com.example.backendserver3.controller;

import com.example.backendserver3.model.WalmartDealItem;
import com.example.backendserver3.repository.WalmartDealItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/backendserver3/walmart/deals")
public class WalmartDealItemController {
    @Autowired
    private WalmartDealItemRepository walmartDealItemRepository;

    @GetMapping("/{categoryName}")
    public Map<String, Object> getDealsByCategory(@PathVariable String categoryName) {
        List<WalmartDealItem> deals = walmartDealItemRepository.findByCategoryName(categoryName);

        // Set the categoryName for each deal item
        deals.forEach(walmartDealItem -> walmartDealItem.setCategoryName(categoryName));

        // Create the response structure
        Map<String, Object> response = new HashMap<>();
        response.put("categoryName", categoryName);
        response.put("dealItems", deals);

        return response;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addWalmartDealItem(@RequestBody WalmartDealItem walmartDealItem) {
        // Save the Walmart deal item to the database
        walmartDealItemRepository.save(walmartDealItem);

        return ResponseEntity.status(HttpStatus.CREATED).body("Walmart Deal item added successfully");
    }
}
