package com.fabits.crm.exception;

import com.fabits.crm.upload.UploadType;

public class UploaderNotFoundException extends RuntimeException {
    private static final String MESSAGE = "No upload configuration found for %s";

    public UploaderNotFoundException(UploadType uploadType) {
        super(String.format(MESSAGE, uploadType.toString()));
    }
}
