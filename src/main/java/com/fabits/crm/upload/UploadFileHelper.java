package com.fabits.crm.upload;

import reactor.core.publisher.Flux;

import java.io.BufferedReader;

public class UploadFileHelper {

    public void processFile(BufferedReader reader, UploadType uploadType) {
         Flux.fromStream(reader.lines())
                .log()
                .subscribe();

    }
}