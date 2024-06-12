package com.sam.customer.service;

import com.sam.customer.dto.CustomerDto;

public interface ICustomerService {
    /**
     *
     * @param customerDto
     */
    void createCustomer(CustomerDto customerDto);
    CustomerDto fetchCustomer(String email);

    void updateCustomer(CustomerDto customerDto);

    void deleteCustomer(String email);
}
