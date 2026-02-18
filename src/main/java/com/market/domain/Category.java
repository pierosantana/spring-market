package com.market.domain;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Represents a product category in the supermarket")
public class Category {

    @Schema(
            description = "Unique category identifier",
            example = "3",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Integer categoryId;

    @Schema(
            description = "Category name",
            example = "Fruits"
    )
    private String category;

    @Schema(
            description = "Indicates whether the category is active",
            example = "true"
    )
    private Boolean active;
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
