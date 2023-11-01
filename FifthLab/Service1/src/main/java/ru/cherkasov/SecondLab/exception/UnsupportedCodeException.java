package ru.cherkasov.SecondLab.exception;

public class UnsupportedCodeException extends Exception {
    private final int errorCode;

    public UnsupportedCodeException(int errorCode) {
        super("Unsupported code: " + errorCode);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
