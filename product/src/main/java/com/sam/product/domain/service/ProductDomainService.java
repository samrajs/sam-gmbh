package com.sam.product.domain.service;

import com.sam.product.domain.entity.Product;
import com.sam.product.domain.event.ProductAvailable;
import com.sam.product.domain.event.ProductCreated;
import com.sam.product.domain.event.ProductPhasingOut;

public interface ProductDomainService {
    ProductCreated validateAndInitProduct( Product product );
    ProductAvailable makeItAvailable( Product product );
    ProductPhasingOut phaseOut( Product product );
}
