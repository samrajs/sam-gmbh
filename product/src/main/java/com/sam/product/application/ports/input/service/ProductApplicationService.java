package com.sam.product.application.ports.input.service;

import com.sam.product.application.dto.create.CreateProductCommand;
import com.sam.product.application.dto.create.CreateProductResponse;
import com.sam.product.application.dto.update.MakeItAvailableCommand;
import com.sam.product.application.dto.update.PhaseOutCommand;

public interface ProductApplicationService {
    CreateProductResponse createProduct( CreateProductCommand command );
    void makeItAvailable( MakeItAvailableCommand command );
    void phaseItOut( PhaseOutCommand command );
}
