package net.largem.poc.dal;

import java.util.List;

public interface RecordRepository<T extends Record> {
    List<T> query(QueryStatement query);
    void batchInsert(List<T> records);
}
