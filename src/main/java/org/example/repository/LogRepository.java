package org.example.repository;

import java.util.List;

import org.example.model.LogEntry;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface LogRepository extends MongoRepository<LogEntry, String> {
    List<LogEntry> findTop10ByOrderByTimestampDesc();
}