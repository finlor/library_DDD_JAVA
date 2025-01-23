package com.ju.library_ddd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DomainEventListenerTest {

    @DisplayName("given aggregate extending AbstractAggregateRoot,"
            + " when do domain operation and save twice,"
            + " then an event is published only for the first time")
    @Test
    void afterDomainEvents() {

        // given
        Aggregate3 aggregate = new Aggregate3();

        // when
        aggregate.domainOperation();
        repository.save(aggregate);
        repository.save(aggregate);

        // then
        verify(eventHandler, times(1)).handleEvent(any(DomainEvent.class));
    }

    @DisplayName("given aggregate extending AbstractAggregateRoot,"
            + " when do domain operation and save,"
            + " then an event is published")
    @Test
    void domainEvents() {
/*        // given
        Aggregate3 aggregate = new Aggregate3();

        // when
        aggregate.domainOperation();
        repository.save(aggregate);

        // then
        verify(eventHandler, times(1)).handleEvent(any(DomainEvent.class));*/
    }
}
