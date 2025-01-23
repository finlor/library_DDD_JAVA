package com.ju.library_ddd.catalog.application;

import com.ju.library_ddd.catalog.domain.Copy;
import com.ju.library_ddd.catalog.domain.CopyId;
import com.ju.library_ddd.catalog.domain.CopyRepository;
import com.ju.library_ddd.lending.domain.LoanClosed;
import com.ju.library_ddd.lending.domain.LoanCreated;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
public class DomainEventListener {

    private final CopyRepository copyRepository;

    public DomainEventListener(CopyRepository copyRepository) {
        this.copyRepository = copyRepository;
    }

    @ApplicationModuleListener
    public void handleEvent(LoanCreated eventCreated) {
        Copy copy = copyRepository.findById(new CopyId(eventCreated.copyId().id())).orElseThrow();
        copy.makeUnavailable();
        copyRepository.save(copy);
    }

    @ApplicationModuleListener
    public void handleEvent(LoanClosed eventClosed){
        Copy copy = copyRepository.findById(new CopyId(eventClosed.copyId().id())).orElseThrow();
        copy.makeAvailable();
        copyRepository.save(copy);
    }
}
