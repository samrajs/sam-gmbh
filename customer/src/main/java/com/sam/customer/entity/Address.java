package com.sam.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {
    @Id
    private Long addressId;
    private Long customerId;
    private String street;
    private String houseNumber;
    private String city;
    private String zip;
}