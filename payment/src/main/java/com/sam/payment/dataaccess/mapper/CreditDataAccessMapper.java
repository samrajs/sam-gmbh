package com.sam.payment.dataaccess.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sam.payment.dataaccess.entity.CreditEntity;
import com.sam.payment.dataaccess.entity.CreditHistoryEntity;
import com.sam.payment.domain.entity.Credit;
import com.sam.payment.domain.entity.CreditHistory;
import com.sam.payment.domain.valueobject.CreditHistoryId;
import com.sam.payment.domain.valueobject.CustomerId;
import com.sam.payment.domain.valueobject.Money;

@Component
public class CreditDataAccessMapper {
    public CreditEntity toCreditEntity( Credit credit ) {
        CreditEntity creditEntity = CreditEntity.builder()
            .customerId( credit.getId().getValue() )
            .balance( credit.getBalance().getAmount() )
            .creditHistories( toCreditHistoryEntities( credit.getCreditHistories() ) )
            .build();

        creditEntity.getCreditHistories().forEach( creditHistory -> creditHistory.setCredit( creditEntity ) );

        return creditEntity;
    }

    private List<CreditHistoryEntity> toCreditHistoryEntities(List<CreditHistory> creditHistories) {
        return creditHistories.stream().map( creditHistory -> CreditHistoryEntity.builder()
                                                                .id( creditHistory.getId().getValue() )
                                                                .amount( creditHistory.getAmount().getAmount() )
                                                                .type( creditHistory.getTransactionType() )
                                                                .build()
                                                                ).collect( Collectors.toList() );
    }

    public Credit toCredit( CreditEntity creditEntity ) {
        return Credit.builder()
            .id( CustomerId.from( creditEntity.getCustomerId() ) )
            .balance( new Money( creditEntity.getBalance() ))
            .creditHistories( toCreditHistories(creditEntity.getCreditHistories()))
            .build();
    }

    private List<CreditHistory> toCreditHistories(List<CreditHistoryEntity> creditHistoryEntities) {
        return creditHistoryEntities.stream().map( historyEntity -> CreditHistory.builder()
                                                                        .id(CreditHistoryId.from(historyEntity.getId()))
                                                                        .amount(new Money( historyEntity.getAmount()))
                                                                        .transactionType(historyEntity.getType())
                                                                        .build()
        ).collect( Collectors.toList() );
    }
}
