package com.sam.customer.service.impl;

import com.sam.customer.dto.CustomerDto;
import com.sam.customer.entity.Customer;
import com.sam.customer.exception.CustomerAlreadyExists;
import com.sam.customer.exception.ResourceNotFoundException;
import com.sam.customer.mapper.CustomerMapper;
import com.sam.customer.repository.CustomerRepository;
import com.sam.customer.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService {
    private CustomerRepository customerRepository;
    @Override
    public void createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());

        Optional<Customer> optionalCustomer = customerRepository.findByEmail(customerDto.getEmail());
        optionalCustomer.ifPresent(
                c -> {
                    throw new CustomerAlreadyExists("Customer already exists with email " + customer.getEmail());
                });

        //customer.setCreatedBy("samrajs");
        //customer.setCreatedAt(LocalDateTime.now());
        Customer savedCustomer = customerRepository.save(customer);
    }

    @Override
    public CustomerDto fetchCustomer(String email) {
        Optional<Customer> customer = customerRepository.findByEmail(email);

        customer.orElseThrow( () -> new ResourceNotFoundException( "Customer", "E-Mail", email) );

        CustomerDto customerDto = new CustomerDto();

        customer.ifPresent(c->{
            CustomerMapper.mapToCustomerDto(c, customerDto);
        });

        return customerDto;
    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        Optional<Customer> customer = customerRepository.findByEmail(customerDto.getEmail());

        customer.orElseThrow( () -> new ResourceNotFoundException( "Customer", "E-Mail", customerDto.getEmail()) );

        customerRepository.save(CustomerMapper.mapToCustomer(customerDto, customer.get()));
    }

    @Override
    public void deleteCustomer(String email) {
        Optional<Customer> customer = customerRepository.findByEmail(email);

        customer.orElseThrow( () -> new ResourceNotFoundException( "Customer", "E-Mail", email) );

        customerRepository.deleteById(customer.get().getCustomerId());
    }
}
