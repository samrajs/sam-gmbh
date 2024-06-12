package com.sam.product.application.ports.output.repository;

import java.util.Optional;

import com.sam.product.domain.entity.Product;
import com.sam.product.domain.valueobject.ProductId;

public interface ProductRepository {
    Product save( Product product );

    Optional<Product> findById( ProductId productId );
}
