package com.sam.payment.application.dto.update;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MakeItAvailableCommand {
    @NotNull
    private final UUID productId;
}