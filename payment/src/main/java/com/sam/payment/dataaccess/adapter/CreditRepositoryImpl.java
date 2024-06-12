package com.sam.payment.dataaccess.adapter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sam.payment.application.ports.output.repository.CreditRepository;
import com.sam.payment.dataaccess.mapper.CreditDataAccessMapper;
import com.sam.payment.dataaccess.repository.CreditJpaRepository;
import com.sam.payment.domain.entity.Credit;
import com.sam.payment.domain.valueobject.CustomerId;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CreditRepositoryImpl implements CreditRepository {
    private final CreditDataAccessMapper mapper;
    private final CreditJpaRepository repository;

    @Override
    public Credit save(Credit credit) {
        return mapper.toCredit(repository.save(mapper.toCreditEntity(credit)));
    }

    @Override
    public Optional<Credit> findById(CustomerId customerId) {
        return repository.findById( customerId.getValue() ).map( mapper::toCredit );
    }

}
