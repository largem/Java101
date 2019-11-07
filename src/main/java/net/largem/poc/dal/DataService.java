package net.largem.poc.dal;

import java.sql.ResultSet;
import java.util.List;

public interface DataService {
    ResultSet query(QueryStatement queryStatement);

    <T extends Record> void batchInsert(List<T> records);
}
