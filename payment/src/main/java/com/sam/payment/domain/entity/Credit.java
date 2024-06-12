package com.sam.payment.domain.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.sam.common.entity.AggregateRoot;
import com.sam.payment.domain.exception.NotEnoughCredit;
import com.sam.payment.domain.valueobject.CreditHistoryId;
import com.sam.payment.domain.valueobject.CustomerId;
import com.sam.payment.domain.valueobject.Money;
import com.sam.payment.domain.valueobject.TransactionType;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@ToString(callSuper = true)
public class Credit extends AggregateRoot<CustomerId> {
    private Money balance;
    private List<CreditHistory> creditHistories;

    public static Credit init( CustomerId customerId ) {
        return Credit.builder()
                .id(customerId)
                .balance( Money.ZERO )
                .creditHistories( new ArrayList<>())
                .build();
    }

    public void addCredit( Money credit ) {
        balance = balance.add(credit);
        creditHistories.add( CreditHistory.builder()
                                    .id( CreditHistoryId.from( UUID.randomUUID() ) )
                                    .amount(credit)
                                    .customerId(getId())
                                    .transactionType(TransactionType.CREDIT)
                                    .build());
    }

    public void subtractCredit( Money credit ) {
        validatePayment(credit);
        creditHistories.add( CreditHistory.builder()
                                    .id( CreditHistoryId.from( UUID.randomUUID() ) )
                                    .amount(credit)
                                    .customerId(getId())
                                    .transactionType( TransactionType.DEBIT)
                                    .build());
        balance = balance.subtract(credit);
    }

    private void validatePayment( Money amount ) {
        if ( !balance.isGreaterThan( amount ) ) {
            throw new NotEnoughCredit(balance, amount);
        }
    }

    public Optional<Credit> get() {
        return Optional.ofNullable( Credit.builder().id( CustomerId.from( UUID.randomUUID()) ).build());
    }
}
