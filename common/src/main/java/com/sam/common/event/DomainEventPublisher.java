package com.sam.common.event;

public interface DomainEventPublisher<T extends DomainEvent> {
    void publish(T domainEvent);
}
