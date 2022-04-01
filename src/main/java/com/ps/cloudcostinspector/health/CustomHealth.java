package com.ps.cloudcostinspector.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealth implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    private int check() {
        //TODO - implement a check here
        // non-zero value will show "DOWN" in below endpoint
        // http://localhost:8080/actuator/health
        return 0;
    }
}
