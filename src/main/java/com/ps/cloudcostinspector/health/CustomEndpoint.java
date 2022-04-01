package com.ps.cloudcostinspector.health;


import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

/**
 * Creates custom url:
 * http://localhost:8080/actuator/my-custom
 */
@Component
@WebEndpoint (id="mycustom")
public class CustomEndpoint {

    @ReadOperation
    public String getData() {
        return "my data";
    }
}
