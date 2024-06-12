package com.sam.product.controller.rest;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.sam.product.application.dto.create.CreateProductCommand;
import com.sam.product.application.dto.create.CreateProductResponse;
import com.sam.product.application.ports.input.service.ProductApplicationService;


@Tag(
        name="REST APIs for products",
        description="REST APIs for managing products"
)
@RestController
@RequestMapping(path="/api/v1/product", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class ProductController {
    private final ProductApplicationService service;

    @Operation(
            summary = "Create product REST API",
            description = "REST API for product creation"

    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED"
    )
    //@PostMapping("/create")
    @PutMapping
    public ResponseEntity<CreateProductResponse> createProduct(@Valid @RequestBody CreateProductCommand createProductCommand) {
        CreateProductResponse response = service.createProduct(createProductCommand);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

        //return ResponseEntity.status(HttpStatus.CREATED)
        //        .body(new ResponseDto(CustomerConstants.STATUS_201, CustomerConstants.MESSAGE_201));
    }
}
