package com.kainan.migration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MigrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MigrationApplication.class, args);
    }

}