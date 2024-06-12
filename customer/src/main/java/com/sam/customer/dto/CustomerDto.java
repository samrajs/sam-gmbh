package com.sam.customer.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name="Customer",
        description = "Schema to hold customer information"
)
public class CustomerDto {
    @Schema(
            description = "Name of the customer",
            example = "Samraj Subramaniam"
    )
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 100)
    private String name;

    @Schema(
            description = "E-Mail address of the customer",
            example = "samrajs@gmail.com"
    )
    @NotEmpty(message = "E-Mail cannot be null or empty")
    @Email(message = "E-Mail format is wrong")
    private String email;
    @Schema(
            description = "Mobile number of the customer",
            example = "012345678901"
    )
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Mobile number should be numeric and should be of the length 12 digits")
    private String mobileNumber;
}