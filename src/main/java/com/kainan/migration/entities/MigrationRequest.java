package com.kainan.migration.entities;

import lombok.Data;

@Data
public class MigrationRequest {
    private String sqlDatabaseUrl;
    private String mongoUrl;
    private String sqlDatabaseTable;
    private String mongoCollection;
    private String mongoDatabase;
}
