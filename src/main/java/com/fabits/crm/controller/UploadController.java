package com.fabits.crm.controller;

import com.fabits.crm.upload.UploadFileHelper;
import com.fabits.crm.upload.UploadType;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;

@RestController
@AllArgsConstructor
public class UploadController {

    private final UploadFileHelper uploadFileHelper;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file,
                                             @RequestParam("uploadType") String uploadTypeString) throws IOException, CsvException {
        UploadType uploadType = UploadType.valueOf(uploadTypeString);
        CSVReader reader = new CSVReaderBuilder(new InputStreamReader(file.getInputStream()))
                .withCSVParser(uploadType.getCsvParser()).build();
        uploadFileHelper.processFile(reader, uploadType);
        return ResponseEntity.ok("");
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
