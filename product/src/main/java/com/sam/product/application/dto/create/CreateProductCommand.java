package com.sam.product.application.dto.create;

import java.math.BigDecimal;

import com.sam.product.domain.valueobject.ProductCategory;
import com.sam.product.domain.valueobject.ProductStatus;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateProductCommand {
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private BigDecimal price;
    @NotNull
    private ProductCategory category;
    @NotNull
    private ProductStatus status;
}
