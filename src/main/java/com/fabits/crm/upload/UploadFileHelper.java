package com.fabits.crm.upload;

import com.fabits.crm.exception.UploaderNotFoundException;
import com.fabits.crm.upload.helper.UploadHelper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Persistable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@AllArgsConstructor
public class UploadFileHelper {

    private final List<UploadHelper<? extends Persistable<?>, ?>> uploadHelperList;

    public void processFile(CSVReader reader, UploadType uploadType) throws IOException, CsvException {
        UploadHelper<? extends Persistable<?>, ?> uploader = uploadHelperList.stream()
                .filter(x -> x.forUploadType().equals(uploadType))
                .findFirst().orElseThrow(() -> new UploaderNotFoundException(uploadType));
        String[] headers = reader.readNext();
        if (uploader.verifyHeaders(headers)) {
            Flux.fromStream(reader.readAll().stream()).log()
                    .map(x -> toMap(headers, x))
                    .map(uploader::fromMap)
                    .subscribe(uploader::persistData);
        }
    }

    private Map<String, String> toMap(String[] headers, String[] data) {
        return IntStream.range(0, headers.length).boxed()
                .collect(Collectors.toMap(x -> headers[x].toUpperCase(Locale.ROOT), x -> data[x]));

    }
}