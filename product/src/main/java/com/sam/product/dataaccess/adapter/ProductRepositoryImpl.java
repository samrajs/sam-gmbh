package com.sam.product.dataaccess.adapter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sam.product.application.ports.output.repository.ProductRepository;
import com.sam.product.dataaccess.mapper.ProductDataAccessMapper;
import com.sam.product.dataaccess.repository.ProductJpaRepository;
import com.sam.product.domain.entity.Product;
import com.sam.product.domain.valueobject.ProductId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ProductRepositoryImpl implements ProductRepository{
    private final ProductDataAccessMapper mapper;
    private final ProductJpaRepository repository;

    @Override
    public Product save(Product product) {
        return mapper.productEntityToProduct( repository.save( mapper.productToProductEntity(product) ) );
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return repository.findById( productId.getValue() ).map(mapper::productEntityToProduct);
    }

}
