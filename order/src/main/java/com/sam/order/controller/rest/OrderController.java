package com.sam.order.controller.rest;


import com.sam.order.application.dto.create.CreateOrderCommand;
import com.sam.order.application.dto.create.CreateOrderResponse;
import com.sam.order.application.dto.update.CancelOrderCommand;
import com.sam.order.application.ports.input.service.OrderApplicationService;
import com.sam.order.controller.dto.ResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Tag(
        name="CRUD REST APIs for orders",
        description="CRUD REST APIs for create, update, delete order details"
)
@RestController
@RequestMapping(path="/api/v1/order", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class OrderController {
    OrderApplicationService service;

    @Operation(
        summary = "Create order REST API",
        description = "REST API for order creation"

    )
    @ApiResponse(
        responseCode = "201",
        description = "HTTP Status OK"
    )
    @PutMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@Valid @RequestBody CreateOrderCommand command) {
        log.info( "CreateOrderCommand received : {}", command);
        CreateOrderResponse response = service.createOrder(command);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @Operation(
        summary = "Cancel order REST API",
        description = "REST API for order cancellation"
        )
        @ApiResponse(
        responseCode = "200",
        description = "HTTP Status OK"
        )
        @PostMapping
        public ResponseEntity<ResponseDto> cancelOrder(@Valid @RequestBody CancelOrderCommand command) {
                service.cancel(command);

                return ResponseEntity.status(HttpStatus.OK)
                        .body(new ResponseDto(HttpStatus.OK, "Order Cancelled"));
        }

    /*@Operation(
            summary = "Fetch Order REST API",
            description = "REST API to fetch order"

    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    )
    @GetMapping(path = "fetch")
    public ResponseEntity<OrderDto> fetchOrder(@NotNull(message = "Order id is required")
                                                         @RequestParam(name = "orderId") String orderId) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(service. .fetchOrder(orderId));
    }

    @Operation(
            summary = "Update Order REST API",
            description = "REST API for order data update"

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
    public ResponseEntity<ResponseDto> updateOrder(@Valid @RequestBody OrderDto orderDto) {
        orderService.updateOrder(orderDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(OrderConstants.STATUS_200, OrderConstants.MESSAGE_200));
    }

    @Operation(
            summary = "Delete order REST API",
            description = "REST API for delete order"

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
    public ResponseEntity<ResponseDto> deleteOrder(
            @NotNull(message = "Order Id is required") @RequestParam(name = "orderId") String orderId) {
        orderService.cancelOrder(orderId);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(OrderConstants.STATUS_200, OrderConstants.MESSAGE_200));
    }*/

}
