package com.fabits.crm.exception;

public class MandatoryHeaderMissingException extends RuntimeException {
    private static final String MESSAGE = "Missing mandatory headers %s";

    public MandatoryHeaderMissingException(String missingHeaders) {
        super(String.format(MESSAGE, missingHeaders));
    }
}
