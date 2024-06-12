package com.sam.common.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Getter @Setter @ToString
@SuperBuilder
public abstract class BaseEntity<ID> {
    private ID id;
}