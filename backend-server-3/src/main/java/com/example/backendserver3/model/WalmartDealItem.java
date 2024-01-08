package com.example.backendserver3.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Data
@Entity
public class WalmartDealItem {
    @Id
    private String itemId;
    private String productTitle;
    private String size;
    private String brand;

    @Embedded
    private Image image;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "marketing_original_value")),
            @AttributeOverride(name = "currency", column = @Column(name = "marketing_original_currency"))
    })
    private MarketingPrice marketingPrice;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "price_value")),
            @AttributeOverride(name = "currency", column = @Column(name = "price_currency"))
    })
    private Price price;

    private int stock;
    private LocalDateTime dealStartDate;
    private LocalDateTime dealEndDate;

    // Constructors, getters, and setters


//    public DealItem(String itemId, String productTitle, String size, String brand, Image image, MarketingPrice marketingPrice, Price price, int stock, LocalDateTime dealStartDate, LocalDateTime dealEndDate, String categoryName) {
//        this.itemId = itemId;
//        this.productTitle = productTitle;
//        this.size = size;
//        this.brand = brand;
//        this.image = image;
//        this.marketingPrice = marketingPrice;
//        this.price = price;
//        this.stock = stock;
//        this.dealStartDate = dealStartDate;
//        this.dealEndDate = dealEndDate;
//        this.categoryName = categoryName;
//    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setMarketingPrice(MarketingPrice marketingPrice) {
        this.marketingPrice = marketingPrice;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDealStartDate(LocalDateTime dealStartDate) {
        this.dealStartDate = dealStartDate;
    }

    public void setDealEndDate(LocalDateTime dealEndDate) {
        this.dealEndDate = dealEndDate;
    }

    // Add a field for categoryName
    private String categoryName;

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
@Getter
@Embeddable
class Image {
    private String imageUrl;

    // Constructors, getters, and setters

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
@Getter
@Embeddable
class MarketingPrice {
    @Embedded
    private OriginalPrice originalPrice;

    private double discountPercentage;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "discount_value")),
            @AttributeOverride(name = "currency", column = @Column(name = "discount_currency"))
    })
    private DiscountAmount discountAmount;

    private String priceTreatment;

    // Constructors, getters, and setters

    public void setOriginalPrice(OriginalPrice originalPrice) {
        this.originalPrice = originalPrice;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setDiscountAmount(DiscountAmount discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setPriceTreatment(String priceTreatment) {
        this.priceTreatment = priceTreatment;
    }
}

@Getter
@Embeddable
class OriginalPrice {
    private double value;
    private String currency;

    // Constructors, getters, and setters

    public void setValue(double value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

@Getter
@Embeddable
class DiscountAmount {
    private double value;
    private String currency;

    // Constructors, getters, and setters

    public void setValue(double value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}

@Getter
@Embeddable
class Price {
    private double value;
    private String currency;

    // Constructors, getters, and setters

    public void setValue(double value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
