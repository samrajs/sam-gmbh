package com.sam.customer.mapper;

import com.sam.customer.dto.AddressDto;
import com.sam.customer.entity.Address;

public class AddressMapper {
    public AddressDto mapToAddressDto(Address address, AddressDto addressDto) {
        addressDto.setStreet( address.getStreet() );
        addressDto.setHouseNumber(address.getHouseNumber());
        addressDto.setCity(address.getCity());
        addressDto.setZip(address.getZip());

        return addressDto;
    }

    public Address mapToAddress(AddressDto addressDto, Address address ) {
        address.setStreet(addressDto.getStreet());
        address.setHouseNumber(addressDto.getHouseNumber());
        address.setCity(addressDto.getCity());
        address.setZip(addressDto.getZip());
        return address;
    }
}
