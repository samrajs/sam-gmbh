package com.sam.payment.dataaccess.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.payment.dataaccess.entity.CreditEntity;

@Repository
public interface CreditJpaRepository extends JpaRepository<CreditEntity, UUID> {
}
