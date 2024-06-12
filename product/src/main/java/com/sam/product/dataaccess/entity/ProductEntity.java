package com.sam.product.dataaccess.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import com.sam.product.domain.valueobject.ProductCategory;
import com.sam.product.domain.valueobject.ProductStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "products")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @Builder
public class ProductEntity 
{
    @Id
    private UUID id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_description")
    private String description;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(name = "product_status")
    private ProductStatus status;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}