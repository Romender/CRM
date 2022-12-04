package com.fabits.crm.upload;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;

public enum UploadType {
    CUSTOMER (new CSVParser()), EMPLOYEE (new CSVParserBuilder().withSeparator('|').build());


    private final CSVParser csvParser;

     UploadType(CSVParser csvParser) {
        this.csvParser = csvParser;
    }

    public CSVParser getCsvParser() {
         return this.csvParser;
    }

}
