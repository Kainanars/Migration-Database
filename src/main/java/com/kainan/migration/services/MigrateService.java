package com.kainan.migration.services;

import com.kainan.migration.entities.MigrationResult;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MigrateService {
    public MigrationResult migratePostgresToMongo(
            String SQLUrl, String mongoUrl,
            String SQLTable, String mongoCollection,
            String mongoDatabase
    ) {
        long startTime = System.currentTimeMillis();

        int count = 0;

        try {
            // Conecta ao banco relacional
            DriverManagerDataSource dataSource = new DriverManagerDataSource(SQLUrl);
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            // Conecta ao MongoDB
            MongoClient mongoClient = MongoClients.create(mongoUrl);
            MongoDatabase mongoDB = mongoClient.getDatabase(mongoDatabase);
            MongoCollection<Document> collection = mongoDB.getCollection(mongoCollection);

            // Le os dados do banco relacional e insere no MongoDB
            List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM " + SQLTable);
            for (Map<String, Object> row : rows) {
                Document document = new Document();
                // Usa o _id do MongoDB
                Object id = row.get("id");
                row.remove("id");
                document.append("_id", id);
                for (Map.Entry<String, Object> entry : row.entrySet()) {
                    document.append(entry.getKey(), entry.getValue());
                }
                collection.insertOne(document);
                count++;
            }

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            return new MigrationResult(count, duration);
        } catch (Exception e) {
            e.printStackTrace();
            return new MigrationResult(0, -1);
        }
    }


}