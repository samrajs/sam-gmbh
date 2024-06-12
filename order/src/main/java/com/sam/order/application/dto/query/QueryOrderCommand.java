package com.sam.order.application.dto.query;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class QueryOrderCommand {
    @NotNull
    private UUID orderId;
}
