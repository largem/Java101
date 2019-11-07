package net.largem.poc.dal;

import com.google.common.collect.ImmutableSet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DynamicRecordRepository implements RecordRepository<DynamicRecord> {

    private final DataService dataService;
    private final ImmutableSet<Field<?>> fields;

    public DynamicRecordRepository(DataService dataService, Set<Field<?>> fields) {
        this.dataService = dataService;
        this.fields = ImmutableSet.copyOf(fields);
    }

    @Override
    public DynamicRecord newRecord() {
        return new DynamicRecord(fields);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DynamicRecord> query(QueryStatement query) {
        List<DynamicRecord> res = new ArrayList<>();
        ResultSet resultSet = dataService.query(query);
        try {
            while (resultSet.next()) {
                DynamicRecord record = newRecord();
                for (Field field : fields) {
                    Object value = resultSet.getObject(field.getName());
                    record.setFieldValue(field, field.getValue(value));
                    res.add(record);
                }
            }
        }catch (SQLException e) {
        }

        return res;
    }

    @Override
    public void batchInsert(List<DynamicRecord> records) {
        if (!records.stream().allMatch(rec -> rec.getFields().equals(fields))) {
            throw new IllegalArgumentException("invalid field found in records");
        }

        dataService.batchInsert(records);
    }
}
