package com.sam.payment.domain.entity;

import com.sam.common.entity.BaseEntity;
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
public class CreditHistory extends BaseEntity<CreditHistoryId> {
    private CustomerId customerId;
    private Money amount;
    private TransactionType transactionType;
}
