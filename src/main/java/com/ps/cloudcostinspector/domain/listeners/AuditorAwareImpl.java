package com.ps.cloudcostinspector.domain.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import java.util.Optional;

@Slf4j
public class AuditorAwareImpl implements AuditorAware<String> {

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyOperation(Object object) {
      log.info("Request called");

    }

    @Override
    public Optional<String> getCurrentAuditor() {
        Optional<String> user = Optional.of("Dummy");
        return user;
//        return Optional.ofNullable(SecurityContextHolder.getContext())
//                .map(e -> e.getAuthentication())
//                .map(Authentication::getName);
    }

//    private void audit(String operation) {
//        setOperation(operation);
//        setTimestamp((new Date()).getTime());
//    }
}
