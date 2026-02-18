package com.market.domain;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Represents a product in the supermarket")
public class Product {
    @Schema(description = "Unique product identifier", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Integer productId;

    @Schema(description = "Product name", example = "Apple")
    private String name;

    @Schema(description = "Identifier of the category this product belongs to", example = "3")
    private Integer categoryId;

    @Schema(description = "Product sale price", example = "2.50")
    private Double price;

    @Schema(description = "Available stock quantity", example = "95")
    private Integer stock;

    @Schema(description = "Indicates whether the product is active and available for sale", example = "true")
    private Boolean active;

    @Schema(description = "Detailed category information associated with the product", implementation = Category.class, accessMode = Schema.AccessMode.READ_ONLY)
    private Category category;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
