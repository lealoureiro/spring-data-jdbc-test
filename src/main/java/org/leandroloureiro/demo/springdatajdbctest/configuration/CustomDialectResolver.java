package org.leandroloureiro.demo.springdatajdbctest.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.data.jdbc.repository.config.DialectResolver;
import org.springframework.data.relational.core.dialect.Dialect;
import org.springframework.data.relational.core.dialect.H2Dialect;
import org.springframework.data.relational.core.dialect.MySqlDialect;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Objects;
import java.util.Optional;

public class CustomDialectResolver implements DialectResolver.JdbcDialectProvider {

    @Override
    public Optional<Dialect> getDialect(JdbcOperations operations) {

        if (operations instanceof JdbcTemplate jdbcTemplate) {

            var dataSource = jdbcTemplate.getDataSource();

            if (dataSource instanceof HikariDataSource hikariDataSource) {

                return getDialectFromDriver(hikariDataSource.getDriverClassName());

            }

        }

        throw new UnsupportedOperationException("Unable to determine Database Dialect!");

    }

    private static Optional<Dialect> getDialectFromDriver(String driverClassName) {

        if (Objects.isNull(driverClassName)) {
            throw new IllegalArgumentException("Unable to determine driver class name!");
        }

        return switch (driverClassName) {
            case "org.h2.Driver" -> Optional.of(H2Dialect.INSTANCE);
            case "com.mysql.cj.jdbc.Driver" -> Optional.of(MySqlDialect.INSTANCE);
            default -> throw new UnsupportedOperationException("Unsupported database type: " + driverClassName);
        };
    }

}
