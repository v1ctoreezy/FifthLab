package ru.cherkasov.SecondLab.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCodes {
    EMPTY(""),
    VALIDATION_EXCEPTION("VALIDATION_EXCEPTION"),
    UNKNOWN_EXCEPTION("UNKNOWN_EXCEPTION"),
    UNSUPPORTED_EXCEPTION("UNSUPPORTED_EXCEPTION");

    private final String name;

    ErrorCodes(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
