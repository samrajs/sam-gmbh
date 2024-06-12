package com.sam.customer.controller;


import com.sam.customer.constants.CustomerConstants;
import com.sam.customer.dto.CustomerDto;
import com.sam.customer.dto.ErrorResponseDto;
import com.sam.customer.dto.ResponseDto;
import com.sam.customer.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name="CRUD REST APIs for customers",
        description="CRUD REST APIs for create, update, delete customer details"
)
@RestController
@RequestMapping(path="/api/v1/customer", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class CustomerController {
    ICustomerService customerService;
    @Operation(
            summary = "Create customer REST API",
            description = "REST API for customer creation"

    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        customerService.createCustomer(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(CustomerConstants.STATUS_201, CustomerConstants.MESSAGE_201));
    }
    @Operation(
            summary = "Fetch customer REST API",
            description = "REST API to fetch customer"

    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    )
    @GetMapping(path = "fetch")
    public ResponseEntity<CustomerDto> fetchCustomer(@Email(message = "E-Mail format is wrong")
                                                         @RequestParam(name = "email") String email) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(customerService.fetchCustomer(email));
    }

    @Operation(
            summary = "Update customer REST API",
            description = "REST API for customer data update"

    )
    @ApiResponses({
        @ApiResponse(
                responseCode = "200",
                description = "HTTP Status OK"
        ),
        @ApiResponse(
                responseCode = "404",
                description = "Page not found",
                content = @Content(
                        examples = {@ExampleObject(
                                name = "responseCode",
                                value = "{\"responseCode\": \"404\", \"description\":\"Page not found\"}"
                        )},
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = ResponseDto.class)
                )
        ),
        @ApiResponse(
                responseCode = "500",
                description = "HTTP Status Internal Server Error",
                content = @Content(
                        schema = @Schema(implementation = ErrorResponseDto.class)
                )
        )}
    )
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCustomer(@Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(CustomerConstants.STATUS_200, CustomerConstants.MESSAGE_200));
    }

    @Operation(
            summary = "Delete customer REST API",
            description = "REST API for delete customer"

    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error"
            )}
    )
    @DeleteMapping(path = "delete")
    public ResponseEntity<ResponseDto> deleteCustomer(
            @Email(message = "E-Mail format is wrong") @RequestParam(name = "email") String email) {
        customerService.deleteCustomer(email);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(CustomerConstants.STATUS_200, CustomerConstants.MESSAGE_200));
    }

}
