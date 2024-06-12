package com.sam.payment.dataaccess.entity;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import com.sam.common.dataaccess.AuditableEntity;
import com.sam.payment.domain.valueobject.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "payments")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor @SuperBuilder
public class PaymentEntity extends AuditableEntity {
    @Id
    private UUID id;
    private UUID customerId;
    private UUID orderId;
    private BigDecimal orderAmount;
    //@Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
