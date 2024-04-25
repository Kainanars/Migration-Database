package com.kainan.migration.controllers;

import com.kainan.migration.entities.MigrationRequest;
import com.kainan.migration.entities.MigrationResult;
import com.kainan.migration.services.MigrateService;
import com.kainan.migration.services.MongoService;
import com.kainan.migration.services.SQLDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MigrationController {

    @Autowired
    private SQLDatabaseService sqlDatabaseService;

    @Autowired
    private MongoService mongoService;

    @Autowired
    private MigrateService migrateService;


    @PostMapping("/migrate")
    public String migrateData(@RequestBody MigrationRequest request) {
        if (!sqlDatabaseService.testConnection(request.getSqlDatabaseUrl())) {
            return "Erro ao conectar ao Banco relacional.";
        }

        if (!mongoService.testConnection(request.getMongoUrl())) {
            return "Erro ao conectar ao MongoDB.";
        }

        MigrationResult result = migrateService.migratePostgresToMongo(
                request.getSqlDatabaseUrl(), request.getMongoUrl(),
                request.getSqlDatabaseTable(), request.getMongoCollection(),
                request.getMongoDatabase());

        if (result.getCount() > 0) {
            return String.format("Migração concluída com sucesso! %d objetos transferidos. Tempo de migração: %d ms", result.getCount(), result.getDuration());
        } else {
            return "Erro ao realizar migração de dados.";
        }
    }
}
