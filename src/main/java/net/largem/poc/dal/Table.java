package net.largem.poc.dal;

import java.util.List;

public interface Table<T extends Record> {
    List<T> queryRecord(QueryStatement query);
}
