package com.sam.customer.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String street;
    private String houseNumber;
    private String city;
    private String zip;
}