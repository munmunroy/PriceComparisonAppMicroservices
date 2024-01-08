package com.example.model;

import lombok.Getter;

import java.util.List;

@Getter
public class DealResponse {
    private String categoryName;
    private List<DealItem> dealItems;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<DealItem> getDealItems() {
        return dealItems;
    }

    public void setDealItems(List<DealItem> dealItems) {
        this.dealItems = dealItems;
    }
}
