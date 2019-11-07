package net.largem.poc.dal;

import java.util.List;

public class DynamicTable implements Table<DynamicRecord> {

    //consider add DynamicTable as generic type of DataProvide.
    private final RecordRepository recordRepository;

    public DynamicTable(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Override
    public List<DynamicRecord> queryRecord(QueryStatement query) {
        return recordRepository.query(query);
    }
}
