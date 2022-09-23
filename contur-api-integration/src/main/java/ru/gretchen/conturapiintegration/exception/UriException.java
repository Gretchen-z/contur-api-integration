package ru.gretchen.conturapiintegration.exception;

public class UriException extends RuntimeException{
    public UriException(String uri, String message) {
        super("Некорректный uri " + uri + " " + message);
    }
}
