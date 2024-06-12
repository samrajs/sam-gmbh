package com.sam.product.messaging.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductPayload {
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String description;
    @JsonProperty
    private BigDecimal price;
    @JsonProperty
    private String category;
    @JsonProperty
    private String status;
}
