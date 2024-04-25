package com.kainan.migration.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;


@Service
public class SQLDatabaseService {
    public boolean testConnection(String postgresUrl) {
        try {
            DriverManagerDataSource dataSource = new DriverManagerDataSource(postgresUrl);
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.execute("SELECT 1");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
