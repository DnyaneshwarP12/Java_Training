package com.example.LoggingAndMonitoring.health;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;

public class DatabaseHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {

        boolean databaseUp = true;

        if (databaseUp) {
            return Health.up()
                    .withDetail("Database", "Connected")
                    .build();
        }

        return Health.down()
                .withDetail("Database", "Not reachable")
                .build();
    }
}
