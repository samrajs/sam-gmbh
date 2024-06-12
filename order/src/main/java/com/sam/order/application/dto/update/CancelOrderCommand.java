package com.sam.order.application.dto.update;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CancelOrderCommand {
    public UUID orderId;
}
