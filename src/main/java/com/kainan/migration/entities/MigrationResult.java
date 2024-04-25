package com.kainan.migration.entities;

import lombok.Data;

@Data
public class MigrationResult {
    private int count;
    private long duration;

    public MigrationResult(int count, long duration) {
        this.count = count;
        this.duration = duration;
    }
}