package com.kainan.migration.services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.stereotype.Service;

@Service
public class MongoService {

    public boolean testConnection(String mongoUrl) {
        try {
            MongoClient mongoClient = MongoClients.create(mongoUrl);
            String mongoDatabases = mongoClient.listDatabaseNames().first();
            System.out.println("Databases: \n" + mongoDatabases);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
