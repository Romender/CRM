package com.fabits.crm.exception;

import java.util.List;

public class MissingMandatoryFieldsException extends RuntimeException {
    private  static final String MESSAGE = "Missing mandatory fields %s";

    public MissingMandatoryFieldsException(List<String> fields) {
        super(String.format(MESSAGE, String.join(",", fields)));
    }
}
