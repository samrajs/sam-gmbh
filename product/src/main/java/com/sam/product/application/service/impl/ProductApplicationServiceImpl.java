package com.sam.product.application.service.impl;

import org.springframework.stereotype.Service;

import com.sam.product.application.dto.create.CreateProductCommand;
import com.sam.product.application.dto.create.CreateProductResponse;
import com.sam.product.application.dto.update.MakeItAvailableCommand;
import com.sam.product.application.dto.update.PhaseOutCommand;
import com.sam.product.application.ports.input.service.ProductApplicationService;
import com.sam.product.application.service.handler.CreateProductCommandHandler;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductApplicationServiceImpl implements ProductApplicationService {
    private final CreateProductCommandHandler orderCreateProductCommandHandler;

    @Override
    public CreateProductResponse createProduct(CreateProductCommand command) {
        return orderCreateProductCommandHandler.createProduct(command);
    }

    @Override
    public void makeItAvailable(MakeItAvailableCommand command) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeItAvailable'");
    }

    @Override
    public void phaseItOut(PhaseOutCommand command) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'phaseItOut'");
    }

}
