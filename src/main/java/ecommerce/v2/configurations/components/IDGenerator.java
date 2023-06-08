package ecommerce.v2.configurations.components;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class IDGenerator {
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
